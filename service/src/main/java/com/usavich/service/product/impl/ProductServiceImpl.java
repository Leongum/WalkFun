package com.usavich.service.product.impl;

import com.usavich.common.exception.ErrorMessageMapper;
import com.usavich.common.exception.ServerRequestException;
import com.usavich.db.account.dao.def.AccountDAO;
import com.usavich.db.product.dao.def.ProductDAO;
import com.usavich.entity.account.UserInfo;
import com.usavich.entity.product.Product;
import com.usavich.entity.product.ProductHistory;
import com.usavich.service.product.def.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AccountDAO accountDAO;

    private UserInfo checkUserExisting(Integer userId) {
        UserInfo userInfo = accountDAO.getAccountInfoByID(userId);
        if (userInfo == null || userInfo.getUserId() == null) {
            throw new ServerRequestException(ErrorMessageMapper.USER_NOT_FOUND.toString());
        }
        return userInfo;
    }

    @Override
    public List<Product> getProducts(Integer productId, Date lastUpdateTime) {
        List<Product> productList = new ArrayList<Product>();
        if (productId != null) {
            productList = productDAO.getProductById(productId);
        } else if (lastUpdateTime != null) {
            productList = productDAO.getProductListByTime(lastUpdateTime);
        }

        return productList;
    }

    @Override
    @Transactional
    public void createProductHistory(ProductHistory productHistory) {
        productDAO.createProductHistory(productHistory);
    }

    @Override
    public List<ProductHistory> getProductHistoryList(Integer userId, Integer productId) {
        checkUserExisting(userId);
        List<ProductHistory> productHistoryList = new ArrayList<ProductHistory>();
        if (productId == null) {
            productHistoryList = productDAO.getProductHistoryList(userId);
        } else {
            productHistoryList = productDAO.getProductHistoryById(userId, productId);
        }
        return productHistoryList;
    }
}
