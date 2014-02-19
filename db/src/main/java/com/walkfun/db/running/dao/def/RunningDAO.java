package com.walkfun.db.running.dao.def;

import com.walkfun.entity.running.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RunningDAO {

    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime);

    public void createRunningHistory(RunningHistory runningHistory);

    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(Integer userId);

    public List<MissionHistory> getMissionHistoriesByDate(Integer userId, Date lastUpdateTime);

    public void createOrUpdateMissionHistory(MissionHistory missionHistory);
}
