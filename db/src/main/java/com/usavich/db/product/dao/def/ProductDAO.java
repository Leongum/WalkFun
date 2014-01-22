package com.usavich.db.product.dao.def;

import com.usavich.entity.product.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/20/13
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO {

    public List<Product> getProductById(Integer productId);

    public List<Product> getProductListByTime(Date lastUpdateTime);

    public List<ProductHistory> getProductHistoryList(Integer userId);

    public List<ProductHistory> getProductHistoryById(Integer userId, Integer productId);

    public void createProductHistory(ProductHistory productHistory);
}
