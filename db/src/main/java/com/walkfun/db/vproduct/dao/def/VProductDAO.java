package com.walkfun.db.vproduct.dao.def;

import com.walkfun.entity.vproduct.*;

import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
public interface VProductDAO {

    public List<VProduct> getVProductByDate(Date lastUpdateTime);

    public void createVProductHistory(VProductHistory vProductHistory);
}
