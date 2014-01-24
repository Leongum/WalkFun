package com.walkfun.rest.running;

import com.walkfun.entity.running.*;
import com.walkfun.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/running")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface RunningRestDef extends RestDef {

    @GET
    @Path("/history/get/{" + PARAM_USER_ID + "}")
    List<RunningHistory> getRunningHistories(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);


    @POST
    @Path("/history/post/{" + PARAM_USER_ID + "}")
    void createRunningHistory( @PathParam(PARAM_USER_ID) String userId,
                            List<RunningHistory> runningHistoryList);


    @GET
    @Path("/history/mission/get/{" + PARAM_USER_ID + "}")
    List<MissionHistory> getMissionHistoriesByDate(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/history/mission/using/get/{" + PARAM_USER_ID + "}")
    List<MissionHistory> getUsingMissionHistories(
            @PathParam(PARAM_USER_ID) String userId);

    @POST
    @Path("/history/mission/put/{" + PARAM_USER_ID + "}")
    void createOrUpdateMissionHistory( @PathParam(PARAM_USER_ID) String userId,
                               List<MissionHistory> missionHistoryList);
}
