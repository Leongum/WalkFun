package com.walkfun.db.vproduct.dao.impl;

import com.walkfun.db.vproduct.dao.def.VProductDAO;
import com.walkfun.entity.vproduct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:27
 * To change this template use File | Settings | File Templates.
 */
public class VProductDAOImpl implements VProductDAO{

    @Autowired
    private VProductMapper vProductMapper;

    @Override
    public List<VProduct> getVProductByDate(Date lastUpdateTime) {
        return vProductMapper.getVProductByDate(lastUpdateTime);
    }

    @Override
    public void createVProductHistory(VProductHistory vProductHistory) {
        vProductMapper.createVProductHistory(vProductHistory);
    }
}
