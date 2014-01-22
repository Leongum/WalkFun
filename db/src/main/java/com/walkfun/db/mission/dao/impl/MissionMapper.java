package com.walkfun.db.mission.dao.impl;

import com.walkfun.entity.mission.*;
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

    public List<Mission> getMissions(@Param("missionId") Integer missionId, @Param("lastUpdateTime") Date lastUpdateTime, @Param("missionTypeId") Integer missionTypeId);
}
