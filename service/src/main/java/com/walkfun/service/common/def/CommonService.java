package com.walkfun.service.common.def;

import com.walkfun.entity.common.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午1:52
 * To change this template use File | Settings | File Templates.
 */
public interface CommonService {
    VersionControl getVersionControl(String platform);

    VersionControl getVersionForRest(String platform);

    List<SystemMessage> getSystemMessage(Date lastUpdateTime);

    List<SystemMessage> getSystemMessageForRest(Date lastUpdateTime);

    void evictCache(String cacheId);

    List<RecommendApp> getRecommendApp(Date lastUpdateTime);

    List<RecommendApp> getRecommendAppForRest(Date lastUpdateTime);

    List<ActionDefinition> getActionDefine(Date lastUpdateTime);

    List<ActionDefinition> getActionDefineForRest(Date lastUpdateTime);

    ActionDefinition getActionDefineById(Integer actionId);

    public List<ActionDefinition> getRewardActionDefine();

    List<ExperienceDefinition> getExperienceDefine();

    void evictJobCache(String jobCache);
}
