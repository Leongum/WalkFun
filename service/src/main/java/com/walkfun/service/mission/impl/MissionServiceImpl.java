package com.walkfun.service.mission.impl;

import com.walkfun.db.mission.dao.def.MissionDAO;
import com.walkfun.entity.mission.*;
import com.walkfun.service.backend.BackendJobCache;
import com.walkfun.service.mission.def.MissionService;
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

        return missionList;
    }
}
