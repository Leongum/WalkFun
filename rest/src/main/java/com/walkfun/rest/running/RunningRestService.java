package com.walkfun.rest.running;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.running.RunningHistory;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.running.def.RunningService;
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
}
