package com.usavich.thirdparty.backend;

import com.usavich.entity.common.PM25DetailInfo;
import com.usavich.thirdparty.weather.def.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-8-26
 * Time: 下午3:35
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TaskJobs {

    @Autowired
    private WeatherService weatherService;

    public static Map<String,PM25DetailInfo> pmInfos = new HashMap<String, PM25DetailInfo>();

    public static List<String> cityList = new ArrayList<String>();

    public void pm25SyncJob() {
        pmInfos = weatherService.getPM25Object();
        cityList = weatherService.getPMCityObject();
    }
}
