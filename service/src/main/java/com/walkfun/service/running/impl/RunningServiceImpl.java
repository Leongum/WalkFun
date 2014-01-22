package com.walkfun.service.running.impl;

import com.walkfun.db.common.dao.def.CommonDAO;
import com.walkfun.db.running.dao.def.RunningDAO;
import com.walkfun.entity.account.UserInfo;
import com.walkfun.entity.running.RunningHistory;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.running.def.RunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunningServiceImpl implements RunningService {

    @Autowired
    private RunningDAO runningDAO;

    @Autowired
    private CommonDAO commonDAO;

    @Autowired
    private AccountService accountService;

    @Override
    public List<RunningHistory> getRunningHistories(Integer userId, Integer missionId) {
        return runningDAO.getRunningHistories(userId, missionId);
    }

    @Override
    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime, int startSize, int pageSize) {
        return runningDAO.getRunningHistoriesByDate(userId, lastUpdateTime, startSize, pageSize);
    }

    @Override
    @Transactional
    public void createRunningHistory(Integer userId, List<RunningHistory> runningHistoryList) {
        UserInfo userInfo = accountService.getAccountInfoByID(userId);
        for (RunningHistory runningHistory : runningHistoryList) {
            runningDAO.createRunningHistory(runningHistory);
            //need add user info
            userInfo = updateUserInfo(userInfo, runningHistory);
        }
        accountService.updateAccountInfo(userInfo);
    }

    private UserInfo updateUserInfo(UserInfo userInfo, RunningHistory runningHistory) {
        //todo:: add userInfo update.
//        if (runningHistory.getValid() == 1) {
//            double experience = userInfo.getExperience() + runningHistory.getExperience();
//            userInfo.setExperience(experience);
//            double scores = userInfo.getScores() + runningHistory.getScores();
//            userInfo.setScores(scores);
//            Experience experienceInfo = commonDAO.getExperienceLevel(experience);
//            double level = experienceInfo.getLevel() + (experience - (experienceInfo.getExperienceTotal() - experienceInfo.getExperience())) / experienceInfo.getExperience();
//            userInfo.setLevel(level);
//            userInfo.setTotalRunTimes(userInfo.getTotalRunTimes() + 1);
//            userInfo.setAvgSpeed((userInfo.getAvgSpeed() + runningHistory.getAvgSpeed()) / 2);
//            userInfo.setTotalDistance(userInfo.getTotalDistance() + runningHistory.getDistance());
//            userInfo.setSpendCarlorie(userInfo.getSpendCarlorie() + runningHistory.getSpendCarlorie());
//        }
        return userInfo;
    }
}
