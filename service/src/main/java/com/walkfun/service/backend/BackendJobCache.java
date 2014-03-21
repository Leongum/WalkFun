package com.walkfun.service.backend;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.account.SearchUserInfo;
import com.walkfun.entity.common.*;
import com.walkfun.entity.mission.Mission;
import com.walkfun.entity.vproduct.VProduct;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.common.def.CommonService;
import com.walkfun.service.mission.def.MissionService;
import com.walkfun.service.vproduct.def.VProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private VProductService vProductService;

    @Autowired
    private AccountService accountService;

    public static VersionControl versionControlIOS = new VersionControl();

    public static List<Mission> allMissions = new ArrayList<Mission>();

    public static List<RecommendApp> allRecommendApp = new ArrayList<RecommendApp>();

    public static List<ActionDefinition> allActionDefine = new ArrayList<ActionDefinition>();

    public static List<FightDefinition> allFightDefine = new ArrayList<FightDefinition>();

    public static List<VProduct> allProducts = new ArrayList<VProduct>();

    public static List<ExperienceDefinition> allExperience = new ArrayList<ExperienceDefinition>();

    public static List<SearchUserInfo> allRecommendUsers = new ArrayList<SearchUserInfo>();

    public static Date missionLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date missionFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date recommendAppLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date recommendAppFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date actionDefineLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date actionDefineFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date fightDefineLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date fightDefineFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public static Date productLastTime = CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00");

    public static Date productFirstTime = CommonUtils.parseDateDefaultToNull("3001-01-01 00:00:00");

    public void missionServiceJob() {
        allMissions = missionService.getMissions(null, CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (Mission mission : allMissions) {
            if (mission.getUpdateTime().after(missionLastTime)) {
                missionLastTime = mission.getUpdateTime();
            }
            if (mission.getUpdateTime().before(missionFirstTime)) {
                missionFirstTime = mission.getUpdateTime();
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

    public void actionDefineServiceJob() {
        allActionDefine = commonService.getActionDefine(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (ActionDefinition actionDefinition : allActionDefine) {
            if (actionDefinition.getUpdateTime().after(actionDefineLastTime)) {
                actionDefineLastTime = actionDefinition.getUpdateTime();
            }
            if (actionDefinition.getUpdateTime().before(actionDefineFirstTime)) {
                actionDefineFirstTime = actionDefinition.getUpdateTime();
            }
        }
    }

    public void fightDefineServiceJob() {
        allFightDefine = commonService.getFightDefine(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (FightDefinition fightDefinition : allFightDefine) {
            if (fightDefinition.getUpdateTime().after(fightDefineLastTime)) {
                fightDefineLastTime = fightDefinition.getUpdateTime();
            }
            if (fightDefinition.getUpdateTime().before(fightDefineFirstTime)) {
                fightDefineFirstTime = fightDefinition.getUpdateTime();
            }
        }
    }

    public void versionServiceJob() {
        versionControlIOS = commonService.getVersionControl("ios");
    }

    public void productServiceJob() {
        allProducts = vProductService.getVProduct(CommonUtils.parseDateDefaultToNull("2001-01-01 00:00:00"));
        for (VProduct vProduct : allProducts) {
            if (vProduct.getUpdateTime().after(productLastTime)) {
                productLastTime = vProduct.getUpdateTime();
            }
            if (vProduct.getUpdateTime().before(productFirstTime)) {
                productFirstTime = vProduct.getUpdateTime();
            }
        }
    }

    public void experienceServiceJob() {
        allExperience = commonService.getExperienceDefine();
    }

    public void recommendUserServiceJob() {
        allRecommendUsers = accountService.getRecommendFriend();
    }

}
