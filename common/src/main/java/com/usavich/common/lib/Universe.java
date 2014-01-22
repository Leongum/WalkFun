package com.usavich.common.lib;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 7/22/13
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Universe {
    private static ThreadLocal<Universe> current = new ThreadLocal<Universe>();

    private int userId;
    private String uuid;
    private Date systemTime;

    private Universe() {
        //set default value for userId and deviceId.
        userId = -1;
        uuid = "X";
        systemTime = new Date();
    }

    // introduce thread local stacking if necessary
    public static Universe current() {
        Universe universe = current.get();
        if (universe == null) {
            universe = new Universe();
            current.set(universe);
        }

        return universe;
    }

    public static void clear() {
        current.set(null);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
}
