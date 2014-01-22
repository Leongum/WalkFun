package com.usavich.rest.plan;

import com.usavich.entity.plan.*;
import com.usavich.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-12
 * Time: 上午9:40
 * To change this template use File | Settings | File Templates.
 */
@Path("/plans")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface PlanRestDef extends RestDef {

    @GET
    @Path("/plan/{" + PARAM_PLAN_ID + "}")
    Plan getPlan(
            @PathParam(PARAM_PLAN_ID) String planId,
            @QueryParam("PARAM_LAST_UPDATE_TIME") String lastUpdateTime);

    @GET
    @Path("/list")
    List<Plan> getPlans(
            @QueryParam(PARAM_PAGE_NUMBER) String pageNo);//default page = 1

    @POST
    @Path("/plan/post/{" + PARAM_USER_ID + "}")
    Plan createPlan(
            @PathParam(PARAM_USER_ID) String userId,
            Plan newPlan
    );

    @GET
    @Path("/collect/{" + PARAM_USER_ID + "}")
    List<PlanCollect> getPlanCollection(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @PUT
    @Path("/collect/put/{" + PARAM_USER_ID + "}")
    void updateUserCollects(
            @PathParam(PARAM_USER_ID) String userId,
            List<PlanCollect> planCollects);

    @GET
    @Path("/history/{" + PARAM_USER_ID + "}")
    List<PlanRunHistory> getPlanRunHistory(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/history/lastupdate/{" + PARAM_USER_ID + "}")
    PlanRunHistory getUserLastUpdatePlan(
            @PathParam(PARAM_USER_ID) String userId);

    @PUT
    @Path("/history/put/{" + PARAM_USER_ID + "}")
    void updateRunningHistory(
            @PathParam(PARAM_USER_ID) String userId,
            List<PlanRunHistory> planHistory);

    @GET
    @Path("/history/running/plan/{" + PARAM_PLAN_ID + "}")
    List<PlanRunHistory> getPlanRunningByPlanId(
            @PathParam(PARAM_PLAN_ID) String planId,
            @QueryParam(PARAM_PAGE_NUMBER) String pageNo);

    @GET
    @Path("/history/running/user/{" + PARAM_USER_ID + "}")
    List<PlanRunHistory> getPlanRunningByUserId(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_PAGE_NUMBER) String pageNo);

    @GET
    @Path("/follow/{" + PARAM_USER_ID + "}")
    List<PlanUserFollow> getPlanFollower(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @PUT
    @Path("/follow/put/{" + PARAM_USER_ID + "}")
    void updatePlanFollower(
            @PathParam(PARAM_USER_ID) String userId,
            List<PlanUserFollow> planFollow);
}
