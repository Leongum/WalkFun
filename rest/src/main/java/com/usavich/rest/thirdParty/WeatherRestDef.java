package com.usavich.rest.thirdParty;

import com.usavich.entity.common.PM25DetailInfo;
import com.usavich.rest.common.RestDef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-8-26
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
@Path("/weather")
@Consumes({"*/xml", MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface WeatherRestDef extends RestDef {

    @GET
    @Path("/pm25")
    PM25DetailInfo getPM25Info(
            @QueryParam(PARAM_CITY_NAME) String cityName,
            @QueryParam(PARAM_PROVINCE_NAME) String provinceName);
}
