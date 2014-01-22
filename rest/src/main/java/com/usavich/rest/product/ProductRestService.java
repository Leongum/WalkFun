package com.usavich.rest.product;

import com.usavich.common.lib.CommonUtils;
import com.usavich.entity.product.*;
import com.usavich.service.product.def.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductRestService implements ProductRestDef {
    @Autowired
    private ProductService productService;

    @Override
    public List<Product> getProducts(String productId, String lastUpdateTime) {
        CommonUtils.newMethodCall("ProductRestService.getProducts");
        return productService.getProducts(CommonUtils.parseIntegerToNull(productId),
                CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public List<ProductHistory> getProductHistoryList(String userId, String productId) {
        CommonUtils.newMethodCall("ProductRestService.getProductHistoryList");
        return productService.getProductHistoryList(CommonUtils.parseIntegerToNull(userId),
                CommonUtils.parseIntegerToNull(productId));
    }

    @Override
    public void createProductHistory(String userId,ProductHistory productHistory) {
        CommonUtils.newMethodCall("ProductRestService.createProductHistory");
        productHistory.setUserId(CommonUtils.parseIntegerToNull(userId));
        productService.createProductHistory(productHistory);
    }
}
