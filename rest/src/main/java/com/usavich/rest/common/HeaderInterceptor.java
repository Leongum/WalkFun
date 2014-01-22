package com.usavich.rest.common;

import com.usavich.common.lib.CommonUtils;
import com.usavich.common.lib.Universe;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 7/12/13
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderInterceptor extends AbstractPhaseInterceptor<Message> {
    private static final int UNIQUE = 0;

    public HeaderInterceptor() {
        super(Phase.READ);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Universe.clear();
        Map<String, List<String>> headers = CastUtils.cast((Map) message.get(Message.PROTOCOL_HEADERS));
        if (headers != null) {
            List<String> keyList = headers.get(RestDef.HEADER_PARAM_KEY);
            if (keyList != null && keyList.size() > 0) {
                String key = keyList.get(UNIQUE);
                Universe.current().setUuid(key.split("#")[0]);
                Universe.current().setUserId(CommonUtils.parseIntegerToNull(key.split("#")[1]));
            }
        }
    }
}
