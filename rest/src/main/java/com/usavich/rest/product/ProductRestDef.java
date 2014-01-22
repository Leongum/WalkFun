package com.usavich.rest.product;

import com.usavich.entity.product.*;
import com.usavich.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/products")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ProductRestDef extends RestDef{

    @GET
    @Path("/product")
    List<Product> getProducts(
            @QueryParam(PARAM_PRODUCT_ID) String productId,
            @QueryParam(PARAM_LAST_UPDATE_TIME) String lastUpdateTime);

    @GET
    @Path("/history/{" + PARAM_USER_ID + "}")
    List<ProductHistory> getProductHistoryList(
            @PathParam(PARAM_USER_ID) String userId,
            @QueryParam(PARAM_PRODUCT_ID) String productId);

    @POST
    @Path("/history/{" + PARAM_USER_ID + "}")
    void createProductHistory( @PathParam(PARAM_USER_ID) String userId,
                            ProductHistory productHistory);
}
