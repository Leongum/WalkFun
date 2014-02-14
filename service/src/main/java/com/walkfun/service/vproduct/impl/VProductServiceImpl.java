package com.walkfun.service.vproduct.impl;

import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.db.vproduct.dao.def.VProductDAO;
import com.walkfun.entity.vproduct.*;
import com.walkfun.service.backend.BackendJobCache;
import com.walkfun.service.vproduct.def.VProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class VProductServiceImpl implements VProductService {

    @Autowired
    private VProductDAO vProductDAO;

    @Override
    public List<VProduct> getVProductForRest(Date lastUpdateTime) {
        try {
            if (lastUpdateTime.before(BackendJobCache.productFirstTime)) {
                return BackendJobCache.allProducts;
            }
            if (lastUpdateTime.after(BackendJobCache.productLastTime)) {
                return new ArrayList<VProduct>();
            }
            return getVProduct(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<VProduct> getVProduct(Date lastUpdateTime) {
        try {
            return vProductDAO.getVProductByDate(lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createVProductHistory(VProductHistory vProductHistory) {
        try {
            vProductDAO.createVProductHistory(vProductHistory);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }
}
