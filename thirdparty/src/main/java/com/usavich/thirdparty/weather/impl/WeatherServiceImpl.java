package com.usavich.thirdparty.weather.impl;

import com.usavich.entity.common.PM25DetailInfo;
import com.usavich.thirdparty.backend.TaskJobs;
import com.usavich.thirdparty.httpService.impl.PM25GetRequest;
import com.usavich.thirdparty.httpService.impl.PMCityGetRequest;
import com.usavich.thirdparty.weather.def.WeatherService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/3/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private PM25GetRequest pm25GetRequest;

    @Autowired
    private PMCityGetRequest pmCityGetRequest;

    @Override
    public Map<String, PM25DetailInfo> getPM25Object() {
        try {
            pm25GetRequest.executeHttpRequest();
            String response = pm25GetRequest.getResponseMessage();
            JSONArray jsonArray = new JSONArray(response);
            Map<String, PM25DetailInfo> pmList = new HashMap<String, PM25DetailInfo>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                PM25DetailInfo pmInfo = new PM25DetailInfo();
                try {
                    pmInfo.setArea(String.valueOf(jsonObject.get("area")));
                    pmInfo.setAqi(String.valueOf(jsonObject.get("aqi")));
                    pmInfo.setPm2_5(String.valueOf(jsonObject.get("pm2_5")));
                    pmInfo.setPm2_5_24h(String.valueOf(jsonObject.get("pm2_5_24h")));
                    pmInfo.setQuality(String.valueOf(jsonObject.get("quality")));
                    pmInfo.setLevel(String.valueOf(jsonObject.get("level")));
                    if (pmInfo.getArea() != null && !pmInfo.getArea().isEmpty()) {
                        pmList.put(pmInfo.getArea(), pmInfo);
                    }
                } catch (Exception jex) {
                }

            }
            return pmList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<String> getPMCityObject() {
        try {
            pmCityGetRequest.executeHttpRequest();
            String response = pmCityGetRequest.getResponseMessage();
            JSONObject jsonObject = new JSONObject(response);
            List<String> cities = new ArrayList<String>();
            JSONArray jsonArray = jsonObject.getJSONArray("cities");
            for (int i = 0; i < jsonArray.length(); i++) {
                cities.add(jsonArray.getString(i));
            }
            return cities;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PM25DetailInfo getPM25ByCityName(String cityName, String provinceName) {
        if (TaskJobs.cityList != null && TaskJobs.pmInfos != null) {
            for (String city : TaskJobs.cityList) {
                if (cityName.indexOf(city) >= 0 || provinceName.indexOf(city) >= 0) {
                    return TaskJobs.pmInfos.get(city);
                }
            }
        }
        return null;
    }
}