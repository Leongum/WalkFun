package com.usavich.service.plan.def;

import com.usavich.entity.plan.Plan;
import com.usavich.entity.plan.PlanCollect;
import com.usavich.entity.plan.PlanRunHistory;
import com.usavich.entity.plan.PlanUserFollow;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-12
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
public interface PlanService {

    List<Plan>  getPlansForRest(Integer pageNo);

    List<Plan> getPlanByPageNo(Integer pageNo,Integer pageSize);

    Plan getPlan(Integer planId, Date lastUpdateTime);

    List<PlanCollect> getPlanCollection(Integer userId, Date lastUpdateTime);

    void updateUserCollects(Integer userId, List<PlanCollect> planCollects);

    List<PlanRunHistory> getPlanRunHistory(Integer userId, Date lastUpdateTime);

    void updateRunningHistory(Integer userId, List<PlanRunHistory> planHistory);

    List<PlanRunHistory> getPlanRunningByPlanId(Integer planId, Integer pageNo);

    List<PlanRunHistory> getPlanRunningByUserId(Integer userId, Integer pageNo);

    List<PlanUserFollow> getPlanFollower(Integer userId, Date lastUpdateTime);

    void updatePlanFollower(Integer userId, List<PlanUserFollow> planFollow);

    Plan createPlan(Integer userId, Plan newPlan);

    PlanRunHistory getUserLastUpdatePlan(Integer userId);
}
