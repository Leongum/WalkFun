package com.usavich.thirdparty.weather.def;

import com.usavich.entity.common.PM25DetailInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/3/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherService {

    Map<String, PM25DetailInfo> getPM25Object();

    List<String> getPMCityObject();

    PM25DetailInfo getPM25ByCityName(String cityName, String provinceName);
}
