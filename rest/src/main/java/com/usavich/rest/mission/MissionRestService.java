package com.usavich.rest.mission;

import com.usavich.common.lib.CommonUtils;
import com.usavich.entity.enums.MissionType;
import com.usavich.entity.mission.*;
import com.usavich.service.mission.def.MissionService;
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
    public List<Mission> getMissions(String missionId, String lastUpdateTime, String missionType) {
        CommonUtils.newMethodCall("MissionRestService.getMissions");
        int missionTypeId = -1;
        if (missionType != null) {
            missionTypeId = MissionType.valueOf(missionType).ordinal();
        }
        return missionService.getMissionsForRest(CommonUtils.parseIntegerToNull(missionId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime), missionTypeId);
    }
}
