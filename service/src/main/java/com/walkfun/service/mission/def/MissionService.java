package com.walkfun.service.mission.def;

import com.walkfun.entity.mission.*;

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

    List<Mission> getMissionsForRest(Integer missionId, Date lastUpdateTime);

    List<Mission> getMissions(Integer missionId, Date lastUpdateTime);
}
