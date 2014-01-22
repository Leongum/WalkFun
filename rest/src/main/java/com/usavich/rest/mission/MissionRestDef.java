package com.usavich.rest.mission;

import com.usavich.entity.mission.*;
import com.usavich.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/19/13
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/missions")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface MissionRestDef extends RestDef {

    @GET
    @Path("/mission")
    List<Mission> getMissions(
            @QueryParam(PARAM_MISSION_ID) String missionId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime,
            @HeaderParam(HEADER_PARAM_MISSION_TYPE) String missionType);
}
