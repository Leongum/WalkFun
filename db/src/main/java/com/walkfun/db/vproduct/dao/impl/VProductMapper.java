package com.walkfun.db.vproduct.dao.impl;

import com.walkfun.entity.vproduct.VProduct;
import com.walkfun.entity.vproduct.VProductHistory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public interface VProductMapper {

    public List<VProduct> getVProductByDate(@Param("lastUpdateTime")Date lastUpdateTime);

    public void createVProductHistory(@Param("entity")VProductHistory vProductHistory);
}
