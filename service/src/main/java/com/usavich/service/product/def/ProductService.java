package com.usavich.service.product.def;

import com.usavich.entity.product.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    List<Product> getProducts(Integer productId,Date lastUpdateTime);

    void createProductHistory(ProductHistory productHistory);

    List<ProductHistory> getProductHistoryList(Integer userId, Integer productId);
}
