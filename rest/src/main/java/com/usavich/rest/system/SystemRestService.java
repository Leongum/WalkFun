package com.usavich.rest.system;

import com.usavich.common.lib.CommonUtils;
import com.usavich.common.lib.Universe;
import com.usavich.entity.common.*;
import com.usavich.service.common.def.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
        CommonUtils.newMethodCall("SystemRestService.getVersionControl");
        VersionControl versionControl = commonService.getVersionForRest(platform);
        versionControl.setSystemTime(Universe.current().getSystemTime());
        return versionControl;
    }

    @Override
    public List<SystemMessage> getSystemMessage(String lastUpdateTime) {
        CommonUtils.newMethodCall("SystemRestService.getSystemMessage");
        return commonService.getSystemMessageForRest(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<RecommendApp> getRecommendApp(String lastUpdateTime) {
        CommonUtils.newMethodCall("SystemRestService.getRecommendApp");
        return commonService.getRecommendAppForRest(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createFeedbackInfo(Feedback feedback) {
        CommonUtils.newMethodCall("SystemRestService.createFeedbackInfo");
        feedback.setCommitTime(new Date());
        commonService.createFeedback(feedback);
    }

    @Override
    public void createDownLoadInfo(Statistics statistics) {
        CommonUtils.newMethodCall("SystemRestService.createDownLoadInfo");
        statistics.setDownloadTime(new Date());
        commonService.createDownLoadInfo(statistics);
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
