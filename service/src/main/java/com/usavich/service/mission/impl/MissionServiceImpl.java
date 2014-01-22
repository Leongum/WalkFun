package com.usavich.service.mission.impl;

import com.usavich.db.mission.dao.def.MissionDAO;
import com.usavich.entity.enums.MissionType;
import com.usavich.entity.mission.*;
import com.usavich.service.backend.BackendJobCache;
import com.usavich.service.mission.def.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionDAO missionDAO;

    @Override
    @Transactional
    public List<Mission> getMissionsForRest(Integer missionId, Date lastUpdateTime, Integer missionTypeId) {
        if (missionId == null && missionTypeId == -1) {
            if (lastUpdateTime.before(BackendJobCache.missionFirstTime)) {
                return BackendJobCache.allMissions;
            }
            if (lastUpdateTime.after(BackendJobCache.missionLastTime)) {
                return new ArrayList<Mission>();
            }
        }
        return getMissions(missionId, lastUpdateTime, missionTypeId);
    }

    @Override
    public List<Mission> getMissions(Integer missionId, Date lastUpdateTime, Integer missionTypeId) {
        List<Mission> missionList = new ArrayList<Mission>();

        missionList = missionDAO.getMissions(missionId, lastUpdateTime, missionTypeId);

        for (Mission mission : missionList) {
            if (mission.getMissionPlacePackageId() != null) {
                List<MissionPlacePackage> missionPlacePackageList = missionDAO.getMissionPlacePackage(mission.getMissionPlacePackageId());
                mission.setMissionPlacePackages(missionPlacePackageList);
            }
            if (mission.getChallengeId() != null) {
                List<MissionChallenge> missionChallengeList = missionDAO.getMissionChallenges(mission.getChallengeId());
                mission.setMissionChallenges(missionChallengeList);
            }
        }

        return missionList;
    }

    @Override
    public List<MissionPlacePackage> getMissionPlacePackage(Integer missionPlacePackageId) {
        return missionDAO.getMissionPlacePackage(missionPlacePackageId);
    }

    @Override
    public List<MissionChallenge> getMissionChallenge(Integer challengeId) {
        return missionDAO.getMissionChallenges(challengeId);
    }

    @Override
    public List<Mission> getMissionsByPlanId(Integer planId) {
        return missionDAO.getMissionsByPlanId(planId);
    }

    @Override
    public void createMission(Mission mission) {
        missionDAO.createMission(mission);
    }
}
