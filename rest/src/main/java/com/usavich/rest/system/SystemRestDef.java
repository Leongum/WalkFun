package com.usavich.rest.system;

import com.usavich.entity.common.*;
import com.usavich.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午2:03
 * To change this template use File | Settings | File Templates.
 */
@Path("/system")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface SystemRestDef extends RestDef {

    @GET
    @Path("/version/{" + PARAM_PLATFORM + "}")
    VersionControl getVersionControl(
            @PathParam(PARAM_PLATFORM) String platform);

    @GET
    @Path("/message/{" + PARAM_LAST_UPDATE_TIME + "}")
    List<SystemMessage> getSystemMessage(
            @PathParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/recommend/{" + PARAM_LAST_UPDATE_TIME + "}")
    List<RecommendApp> getRecommendApp(
            @PathParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @POST
    @Path("/feedback")
    void createFeedbackInfo(Feedback feedback);

    @POST
    @Path("/download")
    void createDownLoadInfo(Statistics statistics);

    @GET
    @Path("/cache/evict/{" + PARAM_CACHE_ID + "}")
    void evictCache(
            @PathParam(PARAM_CACHE_ID) String cacheId);

    @GET
    @Path("/jobcache/evict/{" + PARAM_CACHE_ID + "}")
    void evictJobCache(
            @PathParam(PARAM_CACHE_ID) String jobCache);
}
