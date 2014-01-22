package com.usavich.db.mission.dao.def;

import com.usavich.entity.mission.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MissionDAO {

    public List<Mission> getMissions(Integer missionId, Date lastUpdateTime, Integer missionTypeId);

    public List<MissionPlacePackage> getMissionPlacePackage(Integer missionPlacePackageId);

    public List<MissionChallenge> getMissionChallenges(Integer challengeId);

    public List<Mission> getMissionsByPlanId(Integer planId);

    public void createMission(Mission mission);
}
