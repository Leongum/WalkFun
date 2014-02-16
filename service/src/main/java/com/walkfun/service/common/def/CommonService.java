package com.walkfun.service.common.def;

import com.walkfun.entity.common.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    List<ActionDefination> getActionDefine(Date lastUpdateTime);

    List<ActionDefination> getActionDefineForRest(Date lastUpdateTime);

    void evictJobCache(String jobCache);
}
