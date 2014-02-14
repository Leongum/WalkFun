package com.walkfun.rest.vproduct;

import com.walkfun.entity.vproduct.*;
import com.walkfun.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:56
 * To change this template use File | Settings | File Templates.
 */
@Path("/vproduct")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface VProductRestDef extends RestDef{

    //获取现有的product
    @GET
    @Path("/product/get")
    List<VProduct> getVProduct(@QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    //创建道具消费记录
    @POST
    @Path("/history/create/{" + PARAM_USER_ID + "}")
    void createVProductHistory(@PathParam(PARAM_USER_ID) String userId,
                               VProductHistory vProductHistory);
}
