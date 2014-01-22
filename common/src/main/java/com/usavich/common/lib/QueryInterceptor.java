package com.usavich.common.lib;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/5/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class})})
public class QueryInterceptor implements Interceptor {
    private static final char SPACE = ' ';
    private static Field sqlField;
    private static Field sqlSourceFiled;

    public QueryInterceptor() {
        try {
            sqlField = BoundSql.class.getDeclaredField("sql");
            sqlField.setAccessible(true);

            sqlSourceFiled = MappedStatement.class.getDeclaredField("sqlSource");
            sqlSourceFiled.setAccessible(true);
        } catch (NoSuchFieldException e) {
            // silent ignore
        }
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];

        SqlSource sqlSource = mappedStatement.getSqlSource();
        if (!(sqlSource instanceof Proxy && Proxy.getInvocationHandler(sqlSource) instanceof SqlSourceProxy)) {
            SqlSource sqlSourceProxy = (SqlSource) Proxy.newProxyInstance(SqlSource.class.getClassLoader(),
                    new Class<?>[]{SqlSource.class},
                    new SqlSourceProxy(mappedStatement.getSqlSource()));
            sqlSourceFiled.set(mappedStatement, sqlSourceProxy);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

    class SqlSourceProxy implements InvocationHandler, Serializable {
        private SqlSource target;

        public SqlSourceProxy(SqlSource target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("getBoundSql".equals(method.getName())) {
                BoundSql boundSql = target.getBoundSql(args[0]);
                String beautifySql = tenderlyBeautifySql(boundSql.getSql());
                sqlField.set(boundSql, tenderlyBeautifySql(beautifySql));
                return boundSql;
            }

            return method.invoke(target, args);
        }

        private String tenderlyBeautifySql(String sql) {
            char[] input = CommonUtils.checkString(sql.trim(), "input query").toCharArray();
            boolean inSingleQuotes = false;
            boolean inDoubleQuotes = false;
            int pos = 0;

            for (int i = 1; i < input.length; i++) {
                if (isLineBreakOrSpace(input[i]) && !inSingleQuotes && !inDoubleQuotes && input[pos] == SPACE)
                    continue;

                if (input[i] == '\'' && input[i - 1] != '\\')
                    inSingleQuotes = !inSingleQuotes;

                if (input[i] == '"' && input[i - 1] != '\\')
                    inDoubleQuotes = !inDoubleQuotes;

                input[++pos] = (inSingleQuotes || inDoubleQuotes || !isLineBreakOrSpace(input[i])) ? input[i] : SPACE;
            }

            return new String(Arrays.copyOf(input, pos + 1));
        }

        private boolean isLineBreakOrSpace(char ch) {
            return ch == '\n' || ch == '\r' || ch == SPACE;
        }
    }
}

