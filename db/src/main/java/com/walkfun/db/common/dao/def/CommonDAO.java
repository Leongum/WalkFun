package com.walkfun.db.common.dao.def;

import com.walkfun.entity.common.*;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-9-14
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public interface CommonDAO {

    public VersionControl getVersionControl(String platform);

    public List<RecommendApp> getRecommendApp(Date lastUpdateTime);

    public List<ActionDefinition> getActionDefine(Date lastUpdateTime);

    public List<FightDefinition> getFightDefine(Date lastUpdateTime);

    public List<ExperienceDefinition> getExperienceDefine();
}
