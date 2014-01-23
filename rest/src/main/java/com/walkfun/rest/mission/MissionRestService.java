package com.walkfun.rest.mission;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.mission.*;
import com.walkfun.service.mission.def.MissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class MissionRestService implements MissionRestDef {

    @Autowired
    private MissionService missionService;

    @Override
    public List<Mission> getMissions(String missionId, String lastUpdateTime) {
        return missionService.getMissionsForRest(CommonUtils.parseIntegerToNull(missionId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }
}
