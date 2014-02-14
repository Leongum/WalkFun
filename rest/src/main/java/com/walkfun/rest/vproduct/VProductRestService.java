package com.walkfun.rest.vproduct;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.vproduct.*;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.vproduct.def.VProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-14
 * Time: 上午11:56
 * To change this template use File | Settings | File Templates.
 */
public class VProductRestService implements VProductRestDef {

    @Autowired
    private VProductService vProductService;

    @Autowired
    private AccountService accountService;

    @Override
    public List<VProduct> getVProduct(String lastUpdateTime) {
        return vProductService.getVProduct(CommonUtils.parseDateDefaultToNull(lastUpdateTime));
    }

    @Override
    public void createVProductHistory(String userId, VProductHistory vProductHistory) {
        accountService.checkUserLoginStatus(CommonUtils.parseIntegerToNull(userId));
        vProductHistory.setUserId(CommonUtils.parseIntegerToNull(userId));
        vProductService.createVProductHistory(vProductHistory);
    }
}
