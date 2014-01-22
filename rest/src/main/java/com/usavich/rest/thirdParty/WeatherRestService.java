package com.usavich.rest.thirdParty;

import com.usavich.common.lib.CommonUtils;
import com.usavich.entity.common.PM25DetailInfo;
import com.usavich.thirdparty.weather.def.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-8-26
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class WeatherRestService implements WeatherRestDef{

    @Autowired
    private WeatherService weatherService;

    @Override
    public PM25DetailInfo getPM25Info(String cityName, String provinceName) {
        CommonUtils.newMethodCall("WeatherRestService.getPM25Info");
        if(cityName == null || provinceName == null)return null;
        return weatherService.getPM25ByCityName(cityName,provinceName);
    }
}
