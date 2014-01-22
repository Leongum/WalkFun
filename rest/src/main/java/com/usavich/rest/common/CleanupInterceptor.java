package com.usavich.rest.common;

import com.usavich.common.lib.Universe;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 7/23/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class CleanupInterceptor extends AbstractPhaseInterceptor<Message> {

    public CleanupInterceptor() {
        super(Phase.SEND_ENDING);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Universe.clear();
    }
}
