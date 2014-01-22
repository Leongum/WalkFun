package com.usavich.db.plan.dao.impl;

import com.usavich.db.plan.dao.def.PlanDAO;
import com.usavich.entity.plan.Plan;
import com.usavich.entity.plan.PlanCollect;
import com.usavich.entity.plan.PlanRunHistory;
import com.usavich.entity.plan.PlanUserFollow;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 13-11-8
 * Time: 下午5:43
 * To change this template use File | Settings | File Templates.
 */
public class PlanDAOImpl implements PlanDAO {

    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<Plan> getPlansByPage(Integer from, Integer pageSize) {
        return planMapper.getPlansByPage(from, pageSize);
    }

    @Override
    public Plan getPlan(Integer planId, Date lastUpdateTime) {
        return planMapper.getPlan(planId, null);
    }

    @Override
    public List<PlanCollect> getPlanCollection(Integer userId, Date lastUpdateTime) {
        return planMapper.getPlanCollection(userId, lastUpdateTime);
    }

    @Override
    public void createUserCollect(Integer userId, PlanCollect planCollect) {
        planMapper.createUserCollect(userId, planCollect);
    }

    @Override
    public List<PlanRunHistory> getPlanRunHistory(Integer userId, Date lastUpdateTime) {
        return planMapper.getPlanRunHistory(userId, lastUpdateTime);
    }

    @Override
    public PlanRunHistory getPlanRunning(Integer userId) {
        return planMapper.getPlanRunning(userId);
    }

    @Override
    public void createPlanRunning(Integer userId, PlanRunHistory planHistory) {
        planMapper.createPlanRunning(userId, planHistory);
    }

    @Override
    public void createPlan(Plan newPlan) {
        planMapper.createPlan(newPlan);
    }

    @Override
    public PlanRunHistory getUserLastUpdatePlan(Integer userId) {
        return planMapper.getUserLastUpdatePlan(userId);
    }

    @Override
    public void updatePlanRunning(Integer userId, PlanRunHistory planHistory) {
        planMapper.updatePlanRunning(userId, planHistory);
    }

    @Override
    public List<PlanRunHistory> getPlanRunningByPlanId(Integer planId, Integer from, Integer pageSize) {
        return planMapper.getPlanRunningByPlanId(planId, from, pageSize);
    }

    @Override
    public List<PlanRunHistory> getPlanRunningByUserId(Integer userId, Integer from, Integer pageSize) {
        return planMapper.getPlanRunningByUserId(userId, from, pageSize);
    }

    @Override
    public void createPlanFollower(Integer userId, PlanUserFollow planUserFollow) {
        planMapper.createPlanFollower(userId, planUserFollow);
    }

    @Override
    public List<PlanUserFollow> getPlanFollower(Integer userId, Date lastUpdateTime) {
        return planMapper.getPlanFollower(userId, lastUpdateTime);
    }
}
