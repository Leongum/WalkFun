package com.usavich.db.mission.dao.impl;

import com.usavich.entity.mission.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MissionMapper {

    public List<MissionPlacePackage> getMissionPlacePackage(@Param("missionPlacePackageId") Integer missionPlacePackageId);

    public List<Mission> getMissions(@Param("missionId") Integer missionId, @Param("lastUpdateTime") Date lastUpdateTime, @Param("missionTypeId") Integer missionTypeId);

    public List<MissionChallenge> getMissionChallenges(@Param("challengeId") Integer challengeId);

    public List<Mission> getMissionsByPlanId(@Param("planId")Integer planId);

    public void createMission(@Param("entity")Mission mission);
}
