package com.walkfun.service.backend;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.common.lib.MethodCollector;
import com.walkfun.entity.common.RecommendApp;
import com.walkfun.entity.common.SystemMessage;
import com.walkfun.entity.common.VersionControl;
import com.walkfun.entity.mission.Mission;
import com.walkfun.service.common.def.CommonService;
import com.walkfun.service.mission.def.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-3
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BackendJobCache {

    @Autowired
    private MissionService missionService;

    @Autowired
    private CommonService commonService;

    public static VersionControl versionControlIOS = new VersionControl();

    public static List<Mission> allMissions = new ArrayList<Mission>();

    public static List<SystemMessage> allMessages = new ArrayList<SystemMessage>();

    public static List<RecommendApp> allRecommendApp = new ArrayList<RecommendApp>();

    public static Date missionLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date missionFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date messageLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date messageFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date recommendAppLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date recommendAppFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public void missionServiceJob() {
        allMissions = missionService.getMissions(null, CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"), -1);
        for (Mission mission : allMissions) {
            if (mission.getUpdateTime().after(missionLastTime)) {
                missionLastTime = mission.getUpdateTime();
            }
            if (mission.getUpdateTime().before(missionFirstTime)) {
                missionFirstTime = mission.getUpdateTime();
            }
        }
    }


    public void systemMessageServiceJob() {
        allMessages = commonService.getSystemMessage(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (SystemMessage systemMessage : allMessages) {
            if (systemMessage.getUpdateTime().after(messageLastTime)) {
                messageLastTime = systemMessage.getUpdateTime();
            }
            if (systemMessage.getUpdateTime().before(messageFirstTime)) {
                messageFirstTime = systemMessage.getUpdateTime();
            }
        }
    }

    public void recommendAppServiceJob() {
        allRecommendApp = commonService.getRecommendApp(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (RecommendApp recommendApp : allRecommendApp) {
            if (recommendApp.getUpdateTime().after(recommendAppLastTime)) {
                recommendAppLastTime = recommendApp.getUpdateTime();
            }
            if (recommendApp.getUpdateTime().before(recommendAppFirstTime)) {
                recommendAppFirstTime = recommendApp.getUpdateTime();
            }
        }
    }

    public void versionServiceJob() {
        versionControlIOS = commonService.getVersionControl("ios");
    }

    public void methodCollectorJob() {
        commonService.createMethodCollector(MethodCollector.methods);
        MethodCollector.methods = new HashMap<String, Integer>();
    }

}
