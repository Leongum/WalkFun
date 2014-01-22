package com.usavich.db.plan.dao.def;

import com.usavich.entity.plan.Plan;
import com.usavich.entity.plan.PlanCollect;
import com.usavich.entity.plan.PlanRunHistory;
import com.usavich.entity.plan.PlanUserFollow;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-8
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */
public interface PlanDAO {
    public List<Plan> getPlansByPage(Integer from, Integer pageSize);

    public Plan getPlan(Integer planId, Date lastUpdateTime);

    public List<PlanCollect> getPlanCollection(Integer userId, Date lastUpdateTime);

    public void createUserCollect(Integer userId, PlanCollect planCollect);

    public List<PlanRunHistory> getPlanRunHistory(Integer userId, Date lastUpdateTime);

    public PlanRunHistory getPlanRunning(Integer userId);

    public void updatePlanRunning(Integer userId, PlanRunHistory planHistory);

    public List<PlanRunHistory> getPlanRunningByPlanId(Integer planId, Integer from, Integer pageSize);

    public List<PlanRunHistory> getPlanRunningByUserId(Integer userId, Integer from, Integer pageSize);

    public void createPlanFollower(Integer userId, PlanUserFollow planUserFollow);

    public List<PlanUserFollow> getPlanFollower(Integer userId, Date lastUpdateTime);

    public void createPlanRunning(Integer userId, PlanRunHistory planHistory);

    public void createPlan(Plan newPlan);

    public PlanRunHistory getUserLastUpdatePlan(Integer userId);
}
