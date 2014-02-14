package com.walkfun.service.running.def;

import com.walkfun.entity.running.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RunningService {

    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime);

    public void createRunningHistory(List<RunningHistory> runningHistory);

    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(Integer userId);

    public List<MissionHistory> getMissionHistoriesByDate(Integer userId, Date lastUpdateTime);

    public List<MissionHistory> getUsingMissionHistories(Integer userId);

    public void createOrUpdateMissionHistory(List<MissionHistory> runningHistory);

}
