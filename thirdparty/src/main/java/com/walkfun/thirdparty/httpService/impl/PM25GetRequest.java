package com.walkfun.thirdparty.httpService.impl;

import com.walkfun.thirdparty.httpService.*;
import org.apache.http.HttpEntity;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class PM25GetRequest extends AbstractURIParameter {

    private String pm25GetUrl;

    @Override
    protected HttpEntity getHttpEntity() {
        return null;
    }

    @Override
    protected String getMethod() {
        return "GET";
    }

    @Override
    protected Map<String, Object> getHttpParams() {
        return null;
    }

    @Override
    protected Map<String, String> getHttpHeader() {
        return null;
    }

    @Override
    public String getUri() {
        return pm25GetUrl;
    }

    public String getPm25GetUrl() {
        return pm25GetUrl;
    }

    public void setPm25GetUrl(String pm25GetUrl) {
        this.pm25GetUrl = pm25GetUrl;
    }
}
