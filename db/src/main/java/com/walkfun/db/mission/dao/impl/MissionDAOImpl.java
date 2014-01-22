package com.walkfun.db.mission.dao.impl;

import com.walkfun.db.mission.dao.def.MissionDAO;
import com.walkfun.entity.mission.*;
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
}
