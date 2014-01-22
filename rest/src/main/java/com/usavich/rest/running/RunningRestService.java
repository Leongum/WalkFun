package com.usavich.rest.running;

import com.usavich.common.lib.CommonUtils;
import com.usavich.entity.running.OnGoingRunning;
import com.usavich.entity.running.RunningHistory;
import com.usavich.service.account.def.AccountService;
import com.usavich.service.running.def.RunningService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
    public List<RunningHistory> getRunningHistories(String userId, String lastUpdateTime, int pageNo, int pageSize) {
        CommonUtils.newMethodCall("RunningRestService.getRunningHistories");
        if (pageNo <= 0)
            pageNo = defaultPageNo;
        if (pageSize <= 0)
            pageSize = defaultPageSize;
        int startSize = Math.max((pageNo - 1), 0) * pageSize;

        return runningService.getRunningHistoriesByDate(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime), startSize, pageSize);
    }

    @Override
    public List<OnGoingRunning> getOnGoingRunning(String userId, String lastUpdateTime) {
        CommonUtils.newMethodCall("RunningRestService.getOnGoingRunning");
        return runningService.getOnGoingRunning(CommonUtils.parseIntegerToNull(userId), CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createRunningHistory(String userId, List<RunningHistory> runningHistoryList) {
        CommonUtils.newMethodCall("RunningRestService.createRunningHistory");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (RunningHistory runningHistory : runningHistoryList) {
            runningHistory.setUserId(CommonUtils.parseIntegerToNull(userId));
            if(runningHistory.getCommitTime() == null){
                runningHistory.setCommitTime(new Date());
            }
            if (runningHistory.getValid() != 1) {
                runningHistory.setExperience(0);
                runningHistory.setScores(0);
                runningHistory.setExtraExperience(0);
            }
        }
        runningService.createRunningHistory(CommonUtils.parseIntegerToNull(userId), runningHistoryList);
    }

    @Override
    public void createOnGoingRunning(String userId, List<OnGoingRunning> onGoingRunningList) {
        CommonUtils.newMethodCall("RunningRestService.createOnGoingRunning");
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        for (OnGoingRunning onGoingRunning : onGoingRunningList) {
            onGoingRunning.setUserId(CommonUtils.parseIntegerToNull(userId));
        }
        runningService.createOnGoingRunning(CommonUtils.parseIntegerToNull(userId), onGoingRunningList);
    }
}
