package com.usavich.thirdparty.httpService;

import com.usavich.common.logService.LogHelper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractExecuteRequest {

    protected LogHelper logger = new LogHelper(AbstractExecuteRequest.class);

    /**
     * The client.
     */
    private HttpClientConnectionPool client;

    /**
     * Execute http request.
     *
     * @return the response status
     * @throws org.apache.http.client.ClientProtocolException
     *         the client protocol exception
     * @throws java.io.IOException
     *         Signals that an I/O exception has occurred.
     */
    public ResponseStatus executeHttpRequest() throws ClientProtocolException, IOException {

        return client.executeHttpMethod(getRequest(), getResponseHandler());

    }

    /**
     * Execute http request with addtional headers
     *
     * @return the response status
     * @throws ClientProtocolException
     *         the client protocol exception
     * @throws IOException
     *         Signals that an I/O exception has occurred.
     */
    public ResponseStatus executeHttpRequest(Map<String, String> headers) throws ClientProtocolException, IOException {

        return client.executeHttpMethod(getRequest(headers), getResponseHandler());

    }

    /**
     * Gets the client.
     *
     * @return the client
     */
    public HttpClientConnectionPool getClient() {

        return client;
    }

    /**
     * Gets the http request.
     *
     * @return the request
     */
    protected abstract HttpUriRequest getRequest();

    /**
     * Gets the http request with addtional headers
     *
     * @return the request
     */
    protected abstract HttpUriRequest getRequest(Map<String, String> headers);

    /**
     * Gets the response handler.
     *
     * @return the response handler
     */
    protected abstract ResponseHandler<ResponseStatus> getResponseHandler();

    /**
     * Sets the client.
     *
     * @param client
     *        the new client
     */
    public void setClient(HttpClientConnectionPool client) {

        this.client = client;
    }
}
