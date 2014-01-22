package com.usavich.service.running.def;

import com.usavich.entity.running.OnGoingRunning;
import com.usavich.entity.running.RunningHistory;

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

    List<RunningHistory> getRunningHistories(Integer userId, Integer missionId);

    List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime, int startSize, int pageSize);

    void createRunningHistory(Integer userId, List<RunningHistory> runningHistoryList);

    List<OnGoingRunning> getOnGoingRunning(Integer userId, Date lastUpdateTime);

    void createOnGoingRunning(Integer userId, List<OnGoingRunning> goingRunningList);
}
