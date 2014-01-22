package com.usavich.thirdparty.httpService.impl;

import com.usavich.thirdparty.httpService.AbstractURIParameter;
import org.apache.http.HttpEntity;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-8-26
 * Time: 下午12:56
 * To change this template use File | Settings | File Templates.
 */
public class PMCityGetRequest extends AbstractURIParameter {

    private String pmCityGetUrl;

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
        return pmCityGetUrl;
    }

    public String getPmCityGetUrl() {
        return pmCityGetUrl;
    }

    public void setPmCityGetUrl(String pmCityGetUrl) {
        this.pmCityGetUrl = pmCityGetUrl;
    }
}
