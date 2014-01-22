package com.walkfun.db.running.dao.impl;

import com.walkfun.entity.running.RunningHistory;
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

    public List<RunningHistory> getRunningHistories(@Param("userId") Integer userId, @Param("missionId") Integer missionId);

    public void createRunningHistory(@Param("entity") RunningHistory runningHistory);

    public List<RunningHistory> getRunningHistoriesByDate(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime, @Param("startSize") int startSize, @Param("pageSize") int pageSize);
}
