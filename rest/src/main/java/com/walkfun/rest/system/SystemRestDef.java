package com.walkfun.rest.system;

import com.walkfun.entity.common.*;
import com.walkfun.rest.common.RestDef;

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
    @Path("/version/get/{" + PARAM_PLATFORM + "}")
    VersionControl getVersionControl(
            @PathParam(PARAM_PLATFORM) String platform);

    @GET
    @Path("/message/get/{" + PARAM_LAST_UPDATE_TIME + "}")
    List<SystemMessage> getSystemMessage(
            @PathParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/recommend/get/{" + PARAM_LAST_UPDATE_TIME + "}")
    List<RecommendApp> getRecommendApp(
            @PathParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/actionDefine/get/{" + PARAM_LAST_UPDATE_TIME + "}")
    List<ActionDefinition> getActionDefine(
            @PathParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/cache/evict/{" + PARAM_CACHE_ID + "}")
    void evictCache(
            @PathParam(PARAM_CACHE_ID) String cacheId);

    @GET
    @Path("/jobcache/evict/{" + PARAM_CACHE_ID + "}")
    void evictJobCache(
            @PathParam(PARAM_CACHE_ID) String jobCache);
}
