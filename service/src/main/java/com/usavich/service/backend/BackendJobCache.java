package com.usavich.service.backend;

import com.usavich.common.lib.CommonUtils;
import com.usavich.common.lib.MethodCollector;
import com.usavich.entity.common.RecommendApp;
import com.usavich.entity.common.SystemMessage;
import com.usavich.entity.common.VersionControl;
import com.usavich.entity.mission.Mission;
import com.usavich.entity.plan.Plan;
import com.usavich.service.common.def.CommonService;
import com.usavich.service.mission.def.MissionService;
import com.usavich.service.plan.def.PlanService;
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

    @Autowired
    private PlanService planService;

    public static VersionControl versionControlIOS = new VersionControl();

    public static List<Mission> allMissions = new ArrayList<Mission>();

    public static List<SystemMessage> allMessages = new ArrayList<SystemMessage>();

    public static List<Plan> first100Plan  = new ArrayList<Plan>();

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
            if (mission.getLastUpdateTime().after(missionLastTime)) {
                missionLastTime = mission.getLastUpdateTime();
            }
            if (mission.getLastUpdateTime().before(missionFirstTime)) {
                missionFirstTime = mission.getLastUpdateTime();
            }
        }
    }


    public void systemMessageServiceJob() {
        allMessages = commonService.getSystemMessage(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (SystemMessage systemMessage : allMessages) {
            if (systemMessage.getLastUpdateTime().after(messageLastTime)) {
                messageLastTime = systemMessage.getLastUpdateTime();
            }
            if (systemMessage.getLastUpdateTime().before(messageFirstTime)) {
                messageFirstTime = systemMessage.getLastUpdateTime();
            }
        }
    }

    public void recommendAppServiceJob() {
        allRecommendApp = commonService.getRecommendApp(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (RecommendApp recommendApp : allRecommendApp) {
            if (recommendApp.getLastUpdateTime().after(recommendAppLastTime)) {
                recommendAppLastTime = recommendApp.getLastUpdateTime();
            }
            if (recommendApp.getLastUpdateTime().before(recommendAppFirstTime)) {
                recommendAppFirstTime = recommendApp.getLastUpdateTime();
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

    public void sortPlanJob(){
        first100Plan = planService.getPlanByPageNo(0,100);
    }
}
