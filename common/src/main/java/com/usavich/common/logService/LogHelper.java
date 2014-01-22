package com.usavich.common.logService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class LogHelper {
    private Log logger;

    public LogHelper(String name) {
        logger = LogFactory.getLog(name);
    }

    public LogHelper(Class clazz) {
        logger = LogFactory.getLog(clazz);
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message) {
        System.out.println(message);
        logger.error(message);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }
}
