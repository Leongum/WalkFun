package com.usavich.thirdparty.httpService;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractResponseHandler extends AbstractExecuteRequest implements ResponseHandler<ResponseStatus>{

    /**
     * The error message.
     */
    private String errorMessage;

    /**
     * The response message.
     */
    private String responseMessage;

    /**
     * The status code.
     */
    private int statusCode;

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {

        return errorMessage;
    }

    /**
     * Default ResponseHandler.
     *
     * @return the default response handler
     */
    @Override
    protected ResponseHandler<ResponseStatus> getResponseHandler() {

        return this;
    }

    /**
     * Gets the response message.
     *
     * @return the response message
     */
    public String getResponseMessage() {

        return responseMessage;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public int getStatusCode() {

        return statusCode;
    }

    /**
     * Default handleResponse method.
     *
     * @param response
     *        the response
     * @return the response status
     * @throws org.apache.http.client.ClientProtocolException
     *         the client protocol exception
     * @throws java.io.IOException
     *         Signals that an I/O exception has occurred.
     */
    @Override
    public ResponseStatus handleResponse(HttpResponse response) throws ClientProtocolException, IOException {

        try {
            logger.logInfo("===========response body==============");
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200 || statusCode == 204) {
                if(response.getEntity() != null) {

                    responseMessage = EntityUtils.toString(response.getEntity(), "UTF-8");
                    logger.logInfo(responseMessage);
                }
                return ResponseStatus.SUCCESS;
            }
            if(response.getEntity() != null) {
                errorMessage = EntityUtils.toString(response.getEntity());
                logger.logInfo(errorMessage);
            }
            return ResponseStatus.FAILURE;
        } finally {
            EntityUtils.consume(response.getEntity());
        }
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage
     *        the new error message
     */
    public void setErrorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
    }

    /**
     * Sets the response message.
     *
     * @param responseMessage
     *        the new response message
     */
    public void setResponseMessage(String responseMessage) {

        this.responseMessage = responseMessage;
    }

    /**
     * Sets the status code.
     *
     * @param statusCode
     *        the new status code
     */
    public void setStatusCode(int statusCode) {

        this.statusCode = statusCode;
    }
}
