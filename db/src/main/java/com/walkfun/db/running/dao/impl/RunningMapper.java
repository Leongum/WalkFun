package com.walkfun.db.running.dao.impl;

import com.walkfun.entity.running.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RunningMapper {

    public RunningHistory getRunningHistoryByUuid(@Param("runUuid") String runUuid);

    public List<RunningHistory> getRunningHistoriesByDate(@Param("userId") Integer userId,
                                                          @Param("lastUpdateTime") Date lastUpdateTime);

    public void createRunningHistory(@Param("entity") RunningHistory runningHistory);

    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(@Param("userId") Integer userId);

    public List<MissionHistory> getMissionHistoriesByDate(@Param("userId") Integer userId,
                                                          @Param("lastUpdateTime") Date lastUpdateTime);

    public List<MissionHistory> getUsingMissionHistories(@Param("userId") Integer userId);

    public void createOrUpdateMissionHistory(@Param("entity") MissionHistory missionHistory);
}
