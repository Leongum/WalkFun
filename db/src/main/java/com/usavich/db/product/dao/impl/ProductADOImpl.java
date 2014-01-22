package com.usavich.db.product.dao.impl;

import com.usavich.db.product.dao.def.ProductDAO;
import com.usavich.entity.product.Product;
import com.usavich.entity.product.ProductHistory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/20/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductADOImpl implements ProductDAO{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductById(Integer productId) {
        return productMapper.getProductById(productId);
    }

    @Override
    public List<Product> getProductListByTime(Date lastUpdateTime) {
        return productMapper.getProductListByTime(lastUpdateTime);
    }

    @Override
    public List<ProductHistory> getProductHistoryList(Integer userId) {
        return productMapper.getProductHistoryList(userId);
    }

    @Override
    public List<ProductHistory> getProductHistoryById(Integer userId, Integer productId) {
        return productMapper.getProductHistoryById(userId, productId);
    }

    @Override
    public void createProductHistory(ProductHistory productHistory) {
        productMapper.createProductHistory(productHistory);
    }
}
