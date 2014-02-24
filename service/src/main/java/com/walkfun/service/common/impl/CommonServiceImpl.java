package com.walkfun.service.common.impl;

import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.db.common.dao.def.CommonDAO;
import com.walkfun.entity.common.*;
import com.walkfun.entity.enums.ActionDefineTypeEnum;
import com.walkfun.service.backend.BackendJobCache;
import com.walkfun.service.common.def.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午1:52
 * To change this template use File | Settings | File Templates.
 */
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDAO commonDAO;

    @Qualifier("backendJobCache")
    @Autowired
    private BackendJobCache backendJobCache;

    @Override
    @Transactional
    public VersionControl getVersionControl(String platform) {
        try {
            return commonDAO.getVersionControl(platform);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public VersionControl getVersionForRest(String platform) {
        try {
            VersionControl versionControl = new VersionControl();
            if (platform.equalsIgnoreCase("ios")) {
                versionControl = BackendJobCache.versionControlIOS;
            } else {
                versionControl = getVersionControl(platform);
            }
            versionControl.setMessageLastUpdateTime(BackendJobCache.messageLastTime);
            versionControl.setMissionLastUpdateTime(BackendJobCache.missionLastTime);
            versionControl.setRecommendLastUpdateTime(BackendJobCache.recommendAppLastTime);
            versionControl.setProductLastUpdateTime(BackendJobCache.productLastTime);
            versionControl.setActionDefineUpdateTime(BackendJobCache.actionDefineLastTime);
            return versionControl;
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SystemMessage> getSystemMessage(Date lastUpdateTime) {
        try {
            return commonDAO.getSystemMessage(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SystemMessage> getSystemMessageForRest(Date lastUpdateTime) {
        try {
            if (lastUpdateTime.before(BackendJobCache.messageFirstTime)) {
                return BackendJobCache.allMessages;
            }
            if (lastUpdateTime.after(BackendJobCache.messageLastTime)) {
                return new ArrayList<SystemMessage>();
            }
            return getSystemMessage(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public void evictCache(String cacheId) {
    }

    @Override
    public List<RecommendApp> getRecommendApp(Date lastUpdateTime) {
        try {
            return commonDAO.getRecommendApp(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<RecommendApp> getRecommendAppForRest(Date lastUpdateTime) {
        try {
            if (lastUpdateTime.before(BackendJobCache.recommendAppFirstTime)) {
                return BackendJobCache.allRecommendApp;
            }
            if (lastUpdateTime.after(BackendJobCache.recommendAppLastTime)) {
                return new ArrayList<RecommendApp>();
            }
            return getRecommendApp(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<ActionDefinition> getActionDefine(Date lastUpdateTime) {
        try {
            return commonDAO.getActionDefine(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<ActionDefinition> getActionDefineForRest(Date lastUpdateTime) {
        try {
            if (lastUpdateTime.before(BackendJobCache.actionDefineFirstTime)) {
                return BackendJobCache.allActionDefine;
            }
            if (lastUpdateTime.after(BackendJobCache.actionDefineLastTime)) {
                return new ArrayList<ActionDefinition>();
            }
            return getActionDefine(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public ActionDefinition getActionDefineById(Integer actionId) {
        for(ActionDefinition actionDefinition : BackendJobCache.allActionDefine){
            if(actionDefinition.getActionId() == actionId){
                return actionDefinition;
            }
        }
        return null;
    }

    @Override
    public List<ActionDefinition> getRewardActionDefine() {
        List<ActionDefinition> actionDefinitionList = new ArrayList<ActionDefinition>();
        for(ActionDefinition actionDefinition : BackendJobCache.allActionDefine){
            if(actionDefinition.getActionType() == ActionDefineTypeEnum.REWARD.ordinal()){
                actionDefinitionList.add(actionDefinition);
            }
        }
        return actionDefinitionList;
    }

    @Override
    public List<ExperienceDefinition> getExperienceDefine() {
        try {
            return commonDAO.getExperienceDefine();
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public void evictJobCache(String jobCache) {
        if (jobCache.equalsIgnoreCase("missionServiceJob")) {
            backendJobCache.missionServiceJob();
        } else if (jobCache.equalsIgnoreCase("systemMessageServiceJob")) {
            backendJobCache.systemMessageServiceJob();
        } else if (jobCache.equalsIgnoreCase("recommendAppServiceJob")) {
            backendJobCache.recommendAppServiceJob();
        } else if (jobCache.equalsIgnoreCase("versionServiceJob")) {
            backendJobCache.versionServiceJob();
        } else if (jobCache.equalsIgnoreCase("productServiceJob")) {
            backendJobCache.productServiceJob();
        }  else if (jobCache.equalsIgnoreCase("actionDefineServiceJob")) {
            backendJobCache.actionDefineServiceJob();
        }  else if (jobCache.equalsIgnoreCase("recommendUserServiceJob")) {
            backendJobCache.recommendUserServiceJob();
        }  else if (jobCache.equalsIgnoreCase("experienceServiceJob")) {
            backendJobCache.experienceServiceJob();
        }
    }
}
