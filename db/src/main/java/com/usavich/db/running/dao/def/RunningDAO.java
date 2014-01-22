package com.usavich.db.running.dao.def;

import com.usavich.entity.running.*;

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

    public List<RunningHistory> getRunningHistories(Integer userId, Integer missionId);

    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime, int startSize, int pageSize);

    public void createRunningHistory(RunningHistory runningHistory);

    public List<OnGoingRunning> getOnGoingRunning(Integer userId, Date lastUpdateTime);

    public void createOnGoingRunning(OnGoingRunning goingRunning);
}
