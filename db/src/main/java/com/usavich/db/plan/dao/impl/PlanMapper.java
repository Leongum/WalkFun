package com.usavich.db.plan.dao.impl;

import com.usavich.entity.plan.Plan;
import com.usavich.entity.plan.PlanCollect;
import com.usavich.entity.plan.PlanRunHistory;
import com.usavich.entity.plan.PlanUserFollow;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-8
 * Time: 下午5:44
 * To change this template use File | Settings | File Templates.
 */
public interface PlanMapper {

    public List<Plan> getPlansByPage(@Param("from") Integer from, @Param("pageSize") Integer pageSize);

    public Plan getPlan(@Param("planId") Integer planId, @Param("lastUpdateTime") Date lastUpdateTime);

    public List<PlanCollect> getPlanCollection(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public void createUserCollect(@Param("userId") Integer userId, @Param("planCollect") PlanCollect planCollect);

    public List<PlanRunHistory> getPlanRunHistory(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public PlanRunHistory getPlanRunning(@Param("userId") Integer userId);

    public void createPlanRunning(@Param("userId") Integer userId, @Param("planHistory") PlanRunHistory planHistory);

    public void updatePlanRunning(@Param("userId") Integer userId, @Param("planHistory") PlanRunHistory planHistory);

    public List<PlanRunHistory> getPlanRunningByPlanId(@Param("planId") Integer planId, @Param("from") Integer from, @Param("pageSize") Integer pageSize);

    public List<PlanRunHistory> getPlanRunningByUserId(@Param("userId") Integer userId, @Param("from") Integer from, @Param("pageSize") Integer pageSize);

    public void createPlanFollower(@Param("userId") Integer userId, @Param("planUserFollow") PlanUserFollow planUserFollow);

    public List<PlanUserFollow> getPlanFollower(@Param("userId") Integer userId, @Param("lastUpdateTime") Date lastUpdateTime);

    public void createPlan(@Param("entity")Plan newPlan);

    public PlanRunHistory getUserLastUpdatePlan(@Param("userId")Integer userId);
}
