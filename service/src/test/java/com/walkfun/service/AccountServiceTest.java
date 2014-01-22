package com.walkfun.service;

import com.walkfun.db.account.dao.def.AccountDAO;
import com.walkfun.entity.account.*;
import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 3/6/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountServiceTest extends com.walkfun.service.TestBase {

    @Autowired
    private AccountDAO accountDAO;

    @Test
    public void testGetAccount() {
        UserInfo accountInfo = accountDAO.getAccountInfo("leon@qq.com", "123456");
        Assert.assertNotNull(accountInfo);
    }

    @Test
    public void testCreateAccount() {
        UserBase userBase = new UserBase();
        userBase.setUserName("test@test.test");
        userBase.setPassword("testfortest");
        userBase.setNickName("testAccount");
        UserInfo accountInfo = accountDAO.createAccountInfo(userBase);
        Assert.assertNotNull(accountInfo.getUserId());
    }

}
