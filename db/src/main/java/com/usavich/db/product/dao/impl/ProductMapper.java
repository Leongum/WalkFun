package com.usavich.db.product.dao.impl;

import com.usavich.entity.product.Product;
import com.usavich.entity.product.ProductHistory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/20/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductMapper {
    public List<Product> getProductById(@Param("productId") Integer productId);

    public List<Product> getProductListByTime(@Param("lastUpdateTime") Date lastUpdateTime);

    public List<ProductHistory> getProductHistoryList(@Param("userId") Integer userId);

    public List<ProductHistory> getProductHistoryById(@Param("userId") Integer userId, @Param("productId") Integer productId);

    public void createProductHistory(@Param("entity") ProductHistory productHistory);
}
