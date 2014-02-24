package com.walkfun.service.vproduct.def;

import com.walkfun.entity.vproduct.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public interface VProductService {

    public List<VProduct> getVProductForRest(Date lastUpdateTime);

    public List<VProduct> getVProduct(Date lastUpdateTime);

    public void createVProductHistory(VProductHistory vProductHistory);

    public VProduct getVProductById(Integer vProductId);
}
