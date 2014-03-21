package com.walkfun.service.running.impl;

import com.walkfun.common.exception.ServerRequestException;
import com.walkfun.db.running.dao.def.RunningDAO;
import com.walkfun.entity.account.*;
import com.walkfun.entity.common.*;
import com.walkfun.entity.enums.MissionStatusEnum;
import com.walkfun.entity.running.*;
import com.walkfun.service.BaseService;
import com.walkfun.service.account.def.AccountService;
import com.walkfun.service.common.def.CommonService;
import com.walkfun.service.running.def.RunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/24/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunningServiceImpl extends BaseService implements RunningService {

    @Autowired
    private RunningDAO runningDAO;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CommonService commonService;

    @Override
    public List<RunningHistory> getRunningHistoriesByDate(Integer userId, Date lastUpdateTime) {
        try {
            return runningDAO.getRunningHistoriesByDate(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createRunningHistory(Integer userId, List<RunningHistory> runningHistoryList) {
        try {
            //1. fetch user info
            UserInfo userInfo = accountService.getAccountInfoByID(userId, null);
            //2. fetch user props
            List<UserProp> userProps = accountService.getUserProps(userId, null);
            Map<Integer, Integer> updateHash = new HashMap<Integer, Integer>();
            for (RunningHistory runningHistory : runningHistoryList) {
                if (runningHistory.getValid() == 1) {
                    //1. split action list
                    List<Integer> actions = explainActionList(runningHistory.getActionIds());
                    List<Integer> fights = explainFightList(runningHistory.getActionIds());
                    //2. chang action into props and effective.
                    userInfo = updateUserInfoByActions(userInfo, actions);
                    updateHash = updateUserPropsByActions(actions, updateHash);
                    updateHash = updateUserPropsByFights(fights, updateHash);
                    userInfo.setFatness(plus(userInfo.getFatness(), runningHistory.getFatness()));
                    //todo:: need update calculate.
                    userInfo.setPower(100 - userInfo.getFatness());
                    userInfo.setGoldCoin(plus(userInfo.getGoldCoin(), runningHistory.getGoldCoin()));
                    userInfo.setExperience(plus(userInfo.getExperience(), plus(runningHistory.getExperience(), runningHistory.getExtraExperience())));
                    //todo:: need update calculate.
                    userInfo.setFight(userInfo.getExperience() / 100);
                    userInfo.setTotalActiveTimes(plus(userInfo.getTotalWalkingTimes(), 1));
                    userInfo.setTotalWalkingTimes(plus(userInfo.getTotalWalkingTimes(), runningHistory.getDuration()));
                    userInfo.setTotalCarlorie(plus(userInfo.getTotalCarlorie(), runningHistory.getSpendCarlorie()));
                    userInfo.setTotalDistance(plus(userInfo.getTotalDistance(), runningHistory.getDistance()));
                    userInfo.setTotalSteps(plus(userInfo.getTotalSteps(), runningHistory.getSteps()));
                }
                runningDAO.createRunningHistory(runningHistory);
            }
            // 3. update user info and user props
            userInfo = accountService.checkUserLevel(userInfo);
            accountService.updateAccountInfo(userInfo);
            List<UserProp> updateProps = calculateUserProp(userId, userProps, updateHash);
            accountService.createOrUpdateUserProp(updateProps);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    private Map<Integer, Integer> updateUserPropsByFights(List<Integer> fights, Map<Integer, Integer> updateHash) {
        for (Integer fightId : fights) {
            FightDefinition actionDefinition = commonService.getFightDefineById(fightId);
            Map<Integer, Integer> actionRule = explainActionRule(actionDefinition.getWinRule());
            for (Integer propId : actionRule.keySet()) {
                if (updateHash.get(propId) != null) {
                    updateHash.put(propId, updateHash.get(propId) + actionRule.get(propId));
                } else {
                    updateHash.put(propId, actionRule.get(propId));
                }
            }
        }
        return updateHash;
    }

    private Map<Integer, Integer> updateUserPropsByActions(List<Integer> actions, Map<Integer, Integer> updateHash) {
        for (Integer actionId : actions) {
            ActionDefinition actionDefinition = commonService.getActionDefineById(actionId);
            Map<Integer, Integer> actionRule = explainActionRule(actionDefinition.getActionRule());
            for (Integer propId : actionRule.keySet()) {
                if (updateHash.get(propId) != null) {
                    updateHash.put(propId, updateHash.get(propId) + actionRule.get(propId));
                } else {
                    updateHash.put(propId, actionRule.get(propId));
                }
            }
        }
        return updateHash;
    }

    private UserInfo updateUserInfoByActions(UserInfo userInfo, List<Integer> actions) {
        UserInfo newUser = userInfo;
        for (Integer actionId : actions) {
            ActionDefinition actionDefinition = commonService.getActionDefineById(actionId);
            Map<String, Integer> effectiveRule = explainActionEffectiveRule(actionDefinition.getEffectiveRule());
            newUser = calculateUserInfo(newUser, effectiveRule);
        }
        return newUser;
    }

    @Override
    public List<SimpleRunningHistory> getSimpleRunningHistoriesByDate(Integer userId) {
        try {
            return runningDAO.getSimpleRunningHistoriesByDate(userId);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    public List<MissionHistory> getMissionHistoriesByDate(Integer userId, Date lastUpdateTime) {
        try {
            return runningDAO.getMissionHistoriesByDate(userId, lastUpdateTime);
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }

    @Override
    @Transactional
    public void createOrUpdateMissionHistory(Integer userId, List<MissionHistory> missionHistories) {
        try {
            UserInfo userInfo = accountService.getAccountInfoByID(userId, null);
            boolean update = false;
            for (MissionHistory missionHistory : missionHistories) {
                if (missionHistory.getMissionStatus() == MissionStatusEnum.SUCCESS.ordinal()) {
                    userInfo.setMissionCombo(plus(userInfo.getMissionCombo(), 1));
                    update = true;
                }
                runningDAO.createOrUpdateMissionHistory(missionHistory);
            }
            if (update) {
                accountService.updateAccountInfo(userInfo);
            }
        } catch (Exception ex) {
            throw new ServerRequestException(ex.getMessage());
        }
    }
}
