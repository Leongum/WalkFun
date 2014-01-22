package com.walkfun.rest.thirdParty;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.common.PM25DetailInfo;
import com.walkfun.thirdparty.weather.def.WeatherService;
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
