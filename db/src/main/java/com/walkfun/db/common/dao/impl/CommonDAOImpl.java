package com.walkfun.db.common.dao.impl;

import com.walkfun.db.common.dao.def.CommonDAO;
import com.walkfun.entity.common.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public class CommonDAOImpl implements CommonDAO{

    @Autowired
    private CommonMapper commonMapper;

    @Override
    public List<SystemMessage> getSystemMessage(Date lastUpdateTime) {
        return commonMapper.getSystemMessageInfo(lastUpdateTime);
    }

    @Override
    public List<RecommendApp> getRecommendApp(Date lastUpdateTime) {
        return commonMapper.getRecommendApp(lastUpdateTime);
    }

    @Override
    public List<ActionDefinition> getActionDefine(Date lastUpdateTime) {
        return commonMapper.getActionDefine(lastUpdateTime);
    }

    @Override
    public List<ExperienceDefinition> getExperienceDefine() {
        return commonMapper.getExperienceDefinition();
    }

    @Override
    public VersionControl getVersionControl(String platform) {
        return commonMapper.getVersionControl(platform);
    }
}
