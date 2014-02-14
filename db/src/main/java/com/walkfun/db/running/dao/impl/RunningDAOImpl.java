package com.walkfun.db.running.dao.impl;

import com.walkfun.db.running.dao.def.RunningDAO;
import com.walkfun.entity.running.MissionHistory;
import com.walkfun.entity.running.RunningHistory;
import com.walkfun.entity.running.SimpleRunningHistory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunningDAOImpl implements RunningDAO {

    @Autowired
    private RunningMapper runningMapper;

    @Override
    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime) {
        return runningMapper.getRunningHistoriesByDate(userId, lastUpdateTime);
    }

    @Override
    public void createRunningHistory(RunningHistory runningHistory) {
        RunningHistory existingHistory = runningMapper.getRunningHistoryByUuid(runningHistory.getRunUuid());
        if (existingHistory == null || existingHistory.getUserId() == null) {
            runningMapper.createRunningHistory(runningHistory);
        }
    }

    @Override
    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(Integer userId) {
        return runningMapper.getSimpleRunningHistoriesByDate(userId);
    }

    @Override
    public List<MissionHistory> getMissionHistoriesByDate(Integer userId, Date lastUpdateTime) {
        return runningMapper.getMissionHistoriesByDate(userId, lastUpdateTime);
    }

    @Override
    public List<MissionHistory> getUsingMissionHistories(Integer userId) {
        return runningMapper.getUsingMissionHistories(userId);
    }

    @Override
    public void createOrUpdateMissionHistory(MissionHistory missionHistory) {
        runningMapper.createOrUpdateMissionHistory(missionHistory);
    }
}
