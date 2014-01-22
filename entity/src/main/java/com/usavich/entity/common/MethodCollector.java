package com.usavich.entity.common;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-12
 * Time: 下午11:57
 * To change this template use File | Settings | File Templates.
 */
public class MethodCollector {

    private String methodName;
    private Integer methodTimes;
    private Date useDate;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getMethodTimes() {
        return methodTimes;
    }

    public void setMethodTimes(Integer methodTimes) {
        this.methodTimes = methodTimes;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }
}
