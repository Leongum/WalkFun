package com.walkfun.service;

import com.walkfun.common.lib.CommonUtils;
import com.walkfun.entity.account.*;
import com.walkfun.entity.vproduct.VProduct;
import com.walkfun.service.backend.BackendJobCache;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-21
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
public class BaseService {

    public static String Drop_Down = "D";
    public static String Fatness = "F";
    public static String Fight_Win = "FW";
    public static String Fight_Loose = "FL";
    public static String Flower_Pot = "FP";
    public static String Fight_Add = "FA";
    public static String Fight_Percent = "FPE";
    public static String Physical_Power_Add = "PPA";
    public static String Physical_Power_Percent = "PPP";
    public static String Prop_Yes = "PY";
    public static String Prop_No = "PN";
    public static String Show_Position = "SP";
    public static String Money = "M";
    public static String Type_Action = "TA";
    public static String Type_Fight = "TF";

    public Map<Integer, Integer> explainActionRule(String actionRule) {
        Map<Integer, Integer> vProductIds = new HashMap<Integer, Integer>();
        //9,1,PY|6,1,PN
        if (actionRule != null) {
            String[] ruleArray = actionRule.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length >= 3) {
                    Integer productId = CommonUtils.parseIntegerToNull(ruleDetails[0]);
                    Integer numb = CommonUtils.parseIntegerToNull(ruleDetails[1]);
                    String propFlag = ruleDetails[2];
                    if (propFlag.equalsIgnoreCase(Prop_Yes)) {
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

    public Map<String, Integer> explainActionEffectiveRule(String effectiveRule) {
        Map<String, Integer> userStatusMap = new HashMap<String, Integer>();
        //B,1|H,-1
        if (effectiveRule != null) {
            String[] ruleArray = effectiveRule.split("\\|");
            for (int i = 0; i < ruleArray.length; i++) {
                String[] ruleDetails = ruleArray[i].split(",");
                if (ruleDetails != null && ruleDetails.length >= 2) {
                    String effectiveName = ruleDetails[0];
                    Integer numb = CommonUtils.parseIntegerToNull(ruleDetails[1]);
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
            if (key.equalsIgnoreCase(Fight_Percent)) {
                updateUser.setFightPlus((userStatusMap.get(key) * updateUser.getFight()) / 100);
            } else if (key.equalsIgnoreCase(Fight_Add)) {
                updateUser.setFight(userStatusMap.get(key) * 1.0);
            } else if (key.equalsIgnoreCase(Physical_Power_Percent)) {
                updateUser.setPowerPlus((userStatusMap.get(key) * updateUser.getPower()) / 100);
            } else if (key.equalsIgnoreCase(Physical_Power_Add)) {
                updateUser.setPowerPlus(userStatusMap.get(key) * 1.0);
            } else if (key.equalsIgnoreCase(Fatness)) {
                updateUser.setFatness(updateUser.getFatness() + userStatusMap.get(key));
                //todo:: need add calculate.
                updateUser.setPower(100 - updateUser.getFatness());
            } else if (key.equalsIgnoreCase(Money)) {
                updateUser.setGoldCoin(updateUser.getGoldCoin() + userStatusMap.get(key));
            }
        }
        return updateUser;
    }

    //effective other users with userstatusMap and productsId
    public UserInfo calculateUserInfo(UserInfo toUser, Map<String, Integer> userStatusMap, Map<Integer, Integer> vProductIds) {
        UserInfo updateUser = toUser;
        for (String key : userStatusMap.keySet()) {
            if (key.equalsIgnoreCase(Fight_Percent)) {
                updateUser.setFightPlus((userStatusMap.get(key) * updateUser.getFight()) / 100);
            } else if (key.equalsIgnoreCase(Fight_Add)) {
                updateUser.setFatness(userStatusMap.get(key) * 1.0);
            } else if (key.equalsIgnoreCase(Physical_Power_Percent)) {
                updateUser.setPowerPlus((userStatusMap.get(key) * updateUser.getPower()) / 100);
            } else if (key.equalsIgnoreCase(Physical_Power_Add)) {
                updateUser.setPowerPlus(userStatusMap.get(key) * 1.0);
            } else if (key.equalsIgnoreCase(Fatness)) {
                updateUser.setFatness(updateUser.getFatness() + userStatusMap.get(key));
                //todo:: need add calculate.
                updateUser.setPower(100 - updateUser.getFatness());
            } else if (key.equalsIgnoreCase(Money)) {
                updateUser.setGoldCoin(updateUser.getGoldCoin() + userStatusMap.get(key));
            }
        }
        String propHaving = toUser.getPropHaving();
        Map<Integer, Integer> propMap = explainPropHaveRule(propHaving);
        for (Integer key : vProductIds.keySet()) {
            if (propMap.containsKey(key)) {
                propMap.put(key, propMap.get(key) + (-vProductIds.get(key)));
            }
            propMap.put(key, -vProductIds.get(key));
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
                if (ruleDetails != null && ruleDetails.length >= 2) {
                    Integer productId = CommonUtils.parseIntegerToNull(ruleDetails[0]);
                    Integer numb = CommonUtils.parseIntegerToNull(ruleDetails[1]);
                    vProductIds.put(productId, numb);
                }
            }
        }
        return vProductIds;
    }

//    public List<Integer> explainActionList(String actionList) {
//        List<Integer> actions = new ArrayList<Integer>();
//        if (actionList != null) {
//            String[] ruleArray = actionList.split("\\|");
//            for (int i = 0; i < ruleArray.length; i++) {
//                String[] ruleDetails = ruleArray[i].split(",");
//                if (ruleDetails != null && ruleDetails.length >= 3) {
//                    if (ruleDetails[0].equalsIgnoreCase(Type_Action)) {
//                        actions.add(CommonUtils.parseIntegerToNull(ruleDetails[1]));
//                    }
//                }
//            }
//        }
//        return actions;
//    }

//    public List<Integer> explainFightList(String actionList) {
//        List<Integer> fights = new ArrayList<Integer>();
//        if (actionList != null) {
//            String[] ruleArray = actionList.split("\\|");
//            for (int i = 0; i < ruleArray.length; i++) {
//                String[] ruleDetails = ruleArray[i].split(",");
//                if (ruleDetails != null && ruleDetails.length >= 3) {
//                    if (ruleDetails[0].equalsIgnoreCase(Type_Fight) && CommonUtils.parseIntegerToNull(ruleDetails[2]) == 1) {
//                        fights.add(CommonUtils.parseIntegerToNull(ruleDetails[1]));
//                    }
//                }
//            }
//        }
//        return fights;
//    }

    public List<Integer> explainActionList(String actionList) {
        List<Integer> actions = new ArrayList<Integer>();
        try {
            JSONArray jsonArray = new JSONArray(actionList);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if (String.valueOf(jsonObject.get("eType")).equalsIgnoreCase(Type_Action)) {
                    actions.add(CommonUtils.parseIntegerToNull(String.valueOf(jsonObject.get("eId"))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actions;
    }

    public List<Integer> explainFightList(String actionList) {
        List<Integer> fights = new ArrayList<Integer>();
        try {
            JSONArray jsonArray = new JSONArray(actionList);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                if (String.valueOf(jsonObject.get("eType")).equalsIgnoreCase(Type_Fight)
                        && CommonUtils.parseIntegerToNull(String.valueOf(jsonObject.get("eWin"))) == 1) {
                    fights.add(CommonUtils.parseIntegerToNull(String.valueOf(jsonObject.get("eId"))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fights;
    }

    public <K, V> String transMapToString(Map<K, V> mapList) {
        String str = "";
        for (K key : mapList.keySet()) {
            str = str + key.toString() + "," + mapList.get(key).toString() + "|";
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
