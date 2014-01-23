package com.walkfun.rest.common;

import com.walkfun.common.exception.ErrorMessageMapper;
import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.common.lib.CommonUtils;
import com.walkfun.common.logService.LogHelper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/18/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Provider
public class RestExceptionMapper implements ExceptionMapper {

    public class InvalidRequestMessage {
        private String errormessage;

        public InvalidRequestMessage(String errormessage) {
            this.errormessage = errormessage;
        }

        public String getErrormessage() {
            return errormessage;
        }

        public void setErrormessage(String errormessage) {
            this.errormessage = errormessage;
        }
    }

    private static LogHelper logger = new LogHelper(RestExceptionMapper.class);

    public Response toResponse(Throwable ex) {
        Response.ResponseBuilder rb = Response.status(Response.Status.NOT_ACCEPTABLE);
        InvalidRequestMessage entity = new InvalidRequestMessage(ErrorMessageMapper.PARAM_ERROR.toString());
        if (ex instanceof ServerRequestException) {
            entity = new InvalidRequestMessage(ex.getMessage());
        } else {
            logger.logError(ex.getMessage() + "\r\n" + ex.getStackTrace());
        }
        rb.type("application/json;charset=UTF-8");
        rb.entity(entity);
        return rb.build();
    }
}
