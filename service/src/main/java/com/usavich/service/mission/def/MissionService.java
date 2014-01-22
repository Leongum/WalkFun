package com.usavich.service.mission.def;

import com.usavich.entity.mission.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MissionService {

    List<Mission> getMissionsForRest(Integer missionId, Date lastUpdateTime, Integer missionTypeId);

    List<Mission> getMissions(Integer missionId, Date lastUpdateTime, Integer missionTypeId);

    List<MissionPlacePackage> getMissionPlacePackage(Integer missionPlacePackageId);

    List<MissionChallenge> getMissionChallenge(Integer challengeId);

    List<Mission> getMissionsByPlanId(Integer planId);

    void createMission(Mission mission);
}
