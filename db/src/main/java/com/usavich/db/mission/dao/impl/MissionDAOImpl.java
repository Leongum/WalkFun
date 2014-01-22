package com.usavich.db.mission.dao.impl;

import com.usavich.db.mission.dao.def.MissionDAO;
import com.usavich.entity.mission.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class MissionDAOImpl implements MissionDAO {

    @Autowired
    private MissionMapper missionMapper;

    @Override
    public List<Mission> getMissions(Integer missionId, Date lastUpdateTime, Integer missionTypeId) {
        return missionMapper.getMissions(missionId, lastUpdateTime, missionTypeId);
    }

    @Override
    public List<MissionPlacePackage> getMissionPlacePackage(Integer missionPlacePackageId) {
        return missionMapper.getMissionPlacePackage(missionPlacePackageId);
    }

    @Override
    public List<MissionChallenge> getMissionChallenges(Integer challengeId) {
        return missionMapper.getMissionChallenges(challengeId);
    }

    @Override
    public List<Mission> getMissionsByPlanId(Integer planId) {
        return missionMapper.getMissionsByPlanId(planId);
    }

    @Override
    public void createMission(Mission mission) {
        missionMapper.createMission(mission);
    }
}
