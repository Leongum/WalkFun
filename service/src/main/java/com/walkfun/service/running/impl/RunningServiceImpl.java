package com.walkfun.service.running.impl;

import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.db.running.dao.def.RunningDAO;
import com.walkfun.entity.running.*;
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

    @Override
    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime) {
        try {
            return runningDAO.getRunningHistoriesByDate(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createRunningHistory(List<RunningHistory> runningHistoryList) {
        try {
            for (RunningHistory runningHistory : runningHistoryList) {
                runningDAO.createRunningHistory(runningHistory);
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(Integer userId) {
        try {
            return runningDAO.getSimpleRunningHistoriesByDate(userId);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<MissionHistory> getMissionHistoriesByDate(Integer userId, Date lastUpdateTime) {
        try {
            return runningDAO.getMissionHistoriesByDate(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createOrUpdateMissionHistory(List<MissionHistory> missionHistories) {
        try {
            for (MissionHistory missionHistory : missionHistories) {
                runningDAO.createOrUpdateMissionHistory(missionHistory);
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }
}
