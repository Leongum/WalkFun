package com.usavich.db.common.dao.impl;

import com.usavich.entity.common.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午1:40
 * To change this template use File | Settings | File Templates.
 */
public interface CommonMapper {

    public Experience getExperienceLevel(@Param("experience") double experience);

    public VersionControl getVersionControl(@Param("platform") String platform);

    public void updateVersionControl(@Param("entity") VersionControl versionControl);

    public List<SystemMessage> getSystemMessageInfo( @Param("lastUpdateTime") Date lastUpdateTime);

    public void createFeedback(@Param("entity")Feedback feedback);

    public void createDownLoadInfo(@Param("entity")Statistics statistics);

    public IDGeneration getIDGenerationInfo();

    public void updateIDGenerationFriend(@Param("entity")IDGeneration idGeneration);

    public void createMethodCollector(@Param("entity")MethodCollector methodCollector);

    public List<RecommendApp> getRecommendApp(@Param("lastUpdateTime")Date lastUpdateTime);
}
