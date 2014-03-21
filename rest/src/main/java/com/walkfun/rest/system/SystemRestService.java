package com.walkfun.rest.system;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.common.lib.Universe;
import com.walkfun.entity.common.*;
import com.walkfun.service.common.def.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午2:04
 * To change this template use File | Settings | File Templates.
 */
public class SystemRestService implements SystemRestDef{

    @Autowired
    private CommonService commonService;

    @Override
    public VersionControl getVersionControl(String platform) {
        VersionControl versionControl = commonService.getVersionForRest(platform);
        versionControl.setSystemTime(Universe.current().getSystemTime());
        return versionControl;
    }

    @Override
    public List<RecommendApp> getRecommendApp(String lastUpdateTime) {
        return commonService.getRecommendAppForRest(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<ActionDefinition> getActionDefine(String lastUpdateTime) {
        return commonService.getActionDefineForRest(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<FightDefinition> getFightDefine(String lastUpdateTime) {
        return commonService.getFightDefineForRest(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void evictCache(String cacheId) {
        commonService.evictCache(cacheId);
    }

    @Override
    public void evictJobCache(String jobCache) {
        commonService.evictJobCache(jobCache);
    }


}
