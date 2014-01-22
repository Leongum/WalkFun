package com.usavich.thirdparty.httpService;

import com.usavich.common.logService.LogHelper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientConnectionPool {

    private static LogHelper logger = new LogHelper(AbstractExecuteRequest.class);
    /**
     * The client.
     */
    private HttpClient client;

    /**
     * The default timeout.
     */
    private long defaultTimeout = 15;

    /**
     * The default unit.
     */
    private TimeUnit defaultUnit = TimeUnit.SECONDS;

    /**
     * After properties set.
     *
     * @throws Exception the exception
     */
    public void afterPropertiesSet() throws Exception {

        // init the client
        client = new DefaultHttpClient();

        client.getConnectionManager().closeIdleConnections(defaultTimeout, defaultUnit);
    }

    /**
     * Destroy.
     *
     * @throws Exception the exception
     */
    public void destroy() throws Exception {

        ClientConnectionManager mgr = client.getConnectionManager();
        mgr.shutdown();
    }

    /**
     * Execute http method.
     *
     * @param <T>             the generic type
     * @param request         the request
     * @param responseHandler the response handler
     * @return the t
     * @throws ClientProtocolException the client protocol exception
     * @throws java.io.IOException     Signals that an I/O exception has occurred.
     */
    public <T> T executeHttpMethod(HttpUriRequest request, ResponseHandler<? extends T> responseHandler)
            throws ClientProtocolException, IOException {
        LogRequest(request);
        return client.execute(request, responseHandler);
    }


    /**
     * Gets the default timeout.
     *
     * @return the default timeout
     */
    public long getDefaultTimeout() {

        return defaultTimeout;
    }

    /**
     * Gets the default unit.
     *
     * @return the default unit
     */
    public TimeUnit getDefaultUnit() {

        return defaultUnit;
    }

    /**
     * Sets the default timeout.
     *
     * @param defaultTimeout the new default timeout
     */
    public void setDefaultTimeout(long defaultTimeout) {

        this.defaultTimeout = defaultTimeout;
    }

    /**
     * Sets the default unit.
     *
     * @param defaultUnit the new default unit
     */
    public void setDefaultUnit(TimeUnit defaultUnit) {

        this.defaultUnit = defaultUnit;
    }

    private void LogRequest(HttpUriRequest request) throws IOException {
        logger.logInfo("*** EXECUTING " + request.getMethod());
        logger.logInfo("*** URI: " + request.getURI());
        String headers = "*** Headers: [";
        for (Header h : request.getAllHeaders())
            headers += h.getName() + ": " + h.getValue() + ", ";
        headers = headers.substring(0, headers.length() - 2) + "]";
        logger.logInfo(headers);
        if (request instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();
            logger.logInfo("*** Body:");
            if (entity != null) {
                logger.logInfo(EntityUtils.toString(entity));
            }
        }
    }
}
