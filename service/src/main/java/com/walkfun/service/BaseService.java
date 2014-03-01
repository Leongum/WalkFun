package com.walkfun.service;

import com.walkfun.entity.account.*;
import com.walkfun.entity.vproduct.VProduct;
import com.walkfun.service.backend.BackendJobCache;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-21
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
public class BaseService {

    public static String PROP_YES = "PY";
    public static String PROP_NO = "PN";
    public static String HEALTH = "H";
    public static String FAT = "F";
    public static String RANDOM = "R";
    public static String MONEY = "M";
    public static String SHOW_DROP = "D";
    public static String HEAD_BAG = "B";

    public Map<Integer, Integer> explainActionRule(String actionRule) {
        Map<Integer, Integer> vProductIds = new HashMap<Integer, Integer>();
        //9,圆润的石头,1,PY|6,1个金币,1,PN
        if (actionRule != null) {
            String[] ruleArray = actionRule.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length == 4) {
                    Integer productId = Integer.parseInt(ruleDetails[0]);
                    Integer numb = Integer.parseInt(ruleDetails[2]);
                    String propFlag = ruleDetails[3];
                    if (propFlag.equalsIgnoreCase(PROP_YES)) {
                        vProductIds.put(productId, numb);
                    }
                }
            }
        }
        return vProductIds;
    }

    //calculate user props
    public List<UserProp> calculateUserProp(Integer userId, List<UserProp> userProps, Map<Integer, Integer> vProductIds) {
        List<UserProp> updateProps = new ArrayList<UserProp>();
        for (Integer key : vProductIds.keySet()) {
            int i = 0;
            for (; i < userProps.size(); i++) {
                if (userProps.get(i).getProductId() == key) {
                    UserProp userProp = userProps.get(i);
                    userProp.setOwnNumber(userProp.getOwnNumber() + vProductIds.get(key));
                    updateProps.add(userProp);
                    break;
                }
            }
            if (i == userProps.size()) {
                UserProp userProp = new UserProp();
                userProp.setUserId(userId);
                userProp.setProductId(key);
                for (VProduct vProduct : BackendJobCache.allProducts) {
                    if (vProduct.getProductId() == key) {
                        userProp.setProductName(vProduct.getProductName());
                    }
                }
                userProp.setOwnNumber(vProductIds.get(key));
                updateProps.add(userProp);
            }
        }
        return updateProps;
    }

    public Map<String, Integer> explainActionEffetiveRule(String effectiveRule) {
        Map<String, Integer> userStatusMap = new HashMap<String, Integer>();
        //B,1|H,-1
        if (effectiveRule != null) {
            String[] ruleArray = effectiveRule.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length == 2) {
                    String effectiveName = ruleDetails[0];
                    Integer numb = Integer.parseInt(ruleDetails[1]);
                    userStatusMap.put(effectiveName, numb);
                }
            }
        }
        return userStatusMap;
    }

    //effective only self status.
    public UserInfo calculateUserInfo(UserInfo toUser, Map<String, Integer> userStatusMap) {
        UserInfo updateUser = toUser;
        for (String key : userStatusMap.keySet()) {
            if (key.equalsIgnoreCase(HEALTH)) {
                updateUser.setHealth(updateUser.getHealth() + userStatusMap.get(key));
            } else if (key.equalsIgnoreCase(FAT)) {
                updateUser.setFatness(updateUser.getFatness() + userStatusMap.get(key));
            } else if (key.equalsIgnoreCase(MONEY)) {
                updateUser.setGoldCoin(updateUser.getGoldCoin() + userStatusMap.get(key));
            }
        }
        return updateUser;
    }

    //effective other users with userstatusMap and productsId
    public UserInfo calculateUserInfo(UserInfo toUser, Map<String, Integer> userStatusMap, Map<Integer, Integer> vProductIds) {
        UserInfo updateUser = toUser;
        for (String key : userStatusMap.keySet()) {
            if (key.equalsIgnoreCase(HEALTH)) {
                updateUser.setHealth(updateUser.getHealth() + userStatusMap.get(key));
            } else if (key.equalsIgnoreCase(FAT)) {
                updateUser.setFatness(updateUser.getFatness() + userStatusMap.get(key));
            } else if (key.equalsIgnoreCase(MONEY)) {
                updateUser.setGoldCoin(updateUser.getGoldCoin() + userStatusMap.get(key));
            }
        }
        String propHaving = toUser.getPropHaving();
        Map<Integer, Integer> propMap = explainPropHaveRule(propHaving);
        for (Integer key : vProductIds.keySet()) {
            if (propMap.containsKey(key)) {
                propMap.put(key, propMap.get(key) + (-vProductIds.get(key)));
            }
            propMap.put(key, vProductIds.get(key));
        }
        updateUser.setPropHaving(transMapToString(propMap));
        return updateUser;
    }

    public Map<Integer, Integer> explainPropHaveRule(String propHaving) {
        Map<Integer, Integer> vProductIds = new HashMap<Integer, Integer>();
        //9,1|6,1
        if (propHaving != null) {
            String[] ruleArray = propHaving.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length == 2) {
                    Integer productId = Integer.parseInt(ruleDetails[0]);
                    Integer numb = Integer.parseInt(ruleDetails[1]);
                    vProductIds.put(productId, numb);
                }
            }
        }
        return vProductIds;
    }

    public List<Integer> explainActionList(String actionList) {
        List<Integer> actions = new ArrayList<Integer>();
        //9,1|6,1
        if (actionList != null) {
            String[] ruleArray = actionList.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length >= 2) {
                    actions.add(Integer.parseInt(ruleDetails[1]));
                }
            }
        }
        return actions;
    }

    public <K, V> String transMapToString(Map<K, V> mapList) {
        String str = "";
        for (K key : mapList.keySet()) {
            str = key.toString() + "," + mapList.get(key).toString() + "|";
        }
        return str;
    }

    public Integer plus(Integer a, Integer b) {
        if (a != null && b != null) {
            return a + b;
        } else if (a == null) {
            return b;
        } else {
            return a;
        }
    }

    public Double plus(Double a, Double b) {
        if (a != null && b != null) {
            return a + b;
        } else if (a == null) {
            return b;
        } else {
            return a;
        }
    }
}
