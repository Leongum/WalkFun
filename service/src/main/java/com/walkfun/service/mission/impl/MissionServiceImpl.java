package com.walkfun.service.mission.impl;

import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.db.mission.dao.def.MissionDAO;
import com.walkfun.entity.mission.*;
import com.walkfun.service.backend.BackendJobCache;
import com.walkfun.service.mission.def.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<Mission> getMissionsForRest(Integer missionId, Date lastUpdateTime) {
        try {
            if (missionId == null) {
                if (lastUpdateTime.before(BackendJobCache.missionFirstTime)) {
                    return BackendJobCache.allMissions;
                }
                if (lastUpdateTime.after(BackendJobCache.missionLastTime)) {
                    return new ArrayList<Mission>();
                }
            }
            return getMissions(missionId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public Mission getDailyMission(Integer userId) {
        try {
            Calendar cal = Calendar.getInstance();
            int day = cal.get(Calendar.DATE);
            if (userId == null) {
                userId = 1;
            }
            Random random = new Random(userId * day);
            int index = random.nextInt(BackendJobCache.allMissions.size());
            return BackendJobCache.allMissions.get(index);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<Mission> getMissions(Integer missionId, Date lastUpdateTime) {
        try {
            List<Mission> missionList = new ArrayList<Mission>();

            missionList = missionDAO.getMissions(missionId, lastUpdateTime);

            return missionList;
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }
}
