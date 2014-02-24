package com.walkfun.rest.running;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.running.*;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.running.def.RunningService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunningRestService implements RunningRestDef {

    @Autowired
    private RunningService runningService;

    @Autowired
    private AccountService accountService;

    @Override
    public List<RunningHistory> getRunningHistories(String userId, String lastUpdateTime) {
        return runningService.getRunningHistoriesByDate(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createRunningHistory(String userId, List<RunningHistory> runningHistoryList) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (RunningHistory runningHistory : runningHistoryList) {
            runningHistory.setUserId(CommonUtils.parseIntegerToNull(userId));
            if (runningHistory.getValid() != 1) {
                runningHistory.setExperience(0);
                runningHistory.setGoldCoin(0);
                runningHistory.setExtraExperience(0);
            }
        }
        runningService.createRunningHistory(CommonUtils.parseIntegerToNull(userId),runningHistoryList);
    }

    @Override
    public List<SimpleRunningHistory> getSimpleRunningHistories(String userId) {
        return runningService.getSimpleRunningHistoriesByDate(CommonUtils.parseIntegerToNull(userId));
    }

    @Override
    public List<MissionHistory> getMissionHistoriesByDate(String userId,String lastUpdateTime) {
        return runningService.getMissionHistoriesByDate(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createOrUpdateMissionHistory(String userId, List<MissionHistory> missionHistoryList) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (MissionHistory runningHistory : missionHistoryList) {
            runningHistory.setUserId(CommonUtils.parseIntegerToNull(userId));
        }
        runningService.createOrUpdateMissionHistory(CommonUtils.parseIntegerToNull(userId),missionHistoryList);
    }
}
