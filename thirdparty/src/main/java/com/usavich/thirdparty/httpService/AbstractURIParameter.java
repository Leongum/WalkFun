package com.usavich.thirdparty.httpService;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractURIParameter extends AbstractResponseHandler{

    /**
     * Put the data to HTTP entity.
     *
     * @return the HTTP entity
     */
    protected abstract HttpEntity getHttpEntity();

    /**
     * Gets the HTTP method.
     *
     * @return GET/POST/PUT/DELETE
     */
    protected abstract String getMethod();

    /**
     * Sets the http params map.
     *
     * @return the http params
     */
    protected abstract Map<String, Object> getHttpParams();

    /**
     * Sets the http header map.
     *
     * @return the http header
     */
    protected abstract Map<String, String> getHttpHeader();

    /**
     * Gets the request.
     *
     * @return the request
     */
    @Override
    protected HttpUriRequest getRequest() {
        return getRequest(null);
    }

    /**
     * Gets the request.
     *
     * @return the request
     */
    @Override
    protected HttpUriRequest getRequest(Map<String, String> headers) {

        try {

            HttpEntityEnclosingRequest request = new BasicHttpEntityEnclosingRequest(getMethod(), getUri());

            Map<String, Object> customHttpParams = getHttpParams();

            if (customHttpParams != null) {
                for (Map.Entry<String, Object> entity : customHttpParams.entrySet()) {
                    request.getParams().setParameter(entity.getKey(), entity.getValue());
                }
            }

            Map<String, String> customHttpHeader = getHttpHeader();
            if (customHttpHeader != null) {
                // put all HTTP headers
                for (Map.Entry<String, String> entity : customHttpHeader.entrySet()) {
                    request.setHeader(entity.getKey(), entity.getValue());
                }
            }

            if (headers != null) {
                // put all addtional HTTP headers
                for (Map.Entry<String, String> entity : headers.entrySet()) {
                    request.setHeader(entity.getKey(), entity.getValue());
                }
            }

            // put data to http body
            HttpEntity entity = getHttpEntity();

            if (entity != null) {
                request.setEntity(entity);
            }

            return new EntityEnclosingRequestWrapper(request);

        } catch (ProtocolException e) {
            throw new IllegalStateException("The http request uri can not be created.", e);
        }

    }

    /**
     * Gets the uri.
     *
     * @return the uri
     */
    public abstract String getUri();
}
