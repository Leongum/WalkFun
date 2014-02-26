package com.walkfun.common.lib;


import com.walkfun.common.logService.LogHelper;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.AppleNotificationServerBasicImpl;
import javapns.notification.PushNotificationManager;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-26
 * Time: 上午10:24
 * To change this template use File | Settings | File Templates.
 */
public class IOSMessageSend {

    private static LogHelper log = new LogHelper(IOSMessageSend.class.getName());

    //这里是一个.p12格式的文件路径，需要去apple官网申请一个
    private Resource path;


    //@param password  p12的密码 此处注意导出的证书密码不能为空因为空密码会报错
    private String password;
    // @param count     应用图标上小红圈上的数值
    private static Integer count = 1;
    // @param sound 推送消息的声音
    private static String sound = "default";
    // @param production true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
    private boolean production;

    public Resource getPath() {
        return path;
    }

    public void setPath(Resource path) {
        this.path = path;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isProduction() {
        return production;
    }

    public void setProduction(boolean production) {
        this.production = production;
    }

    /************************************************

     需要javaPNS_2.2.jar包

     ***************************************************/
    /**
     * 这是一个比较简单的推送方法，
     * <p/>
     * apple的推送方法
     *
     * @param tokens    iphone手机获取的token
     * @param message   推送消息的内容
     * @param sendGroup 单发还是群发  true：单发 false：群发
     */

    public void sendpush(List<String> tokens, String message, boolean sendGroup) {
        try {
            PushNotificationPayload payLoad = new PushNotificationPayload();
            payLoad.addAlert(message);
            payLoad.addBadge(count);
            payLoad.addSound(sound);

            PushNotificationManager pushManager = new PushNotificationManager();
            //true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
            pushManager.initializeConnection(new AppleNotificationServerBasicImpl(path.getInputStream(), password, production));
            List<PushedNotification> notifications = new ArrayList<PushedNotification>();

            // 发送push消息
            if (!sendGroup) {
                log.logInfo("----------apple notification send for personal-------");
                Device device = new BasicDevice();
                if (tokens != null && tokens.size() > 0 && tokens.get(0).length() == 64) {
                    device.setToken(tokens.get(0));
                    PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
                    notifications.add(notification);
                }
            } else {
                log.logInfo("-----------apple notification send for group-------");
                List<Device> device = new ArrayList<Device>();
                for (String token : tokens) {
                    if (token != null && token.length() == 64) {
                        device.add(new BasicDevice(token));
                    }
                }
                notifications = pushManager.sendNotifications(payLoad, device);
            }

            List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
            List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
            int failed = failedNotifications.size();
            int successful = successfulNotifications.size();

            if (successful > 0 && failed == 0) {
                log.logInfo("-----All notifications pushed success (" + successfulNotifications.size() + "):");
            } else if (successful == 0 && failed > 0) {
                log.logInfo("-----All notifications fail (" + failedNotifications.size() + "):");
            } else if (successful == 0 && failed == 0) {
                System.out.println("No notifications could be sent, probably because of a critical error");
            } else {
                log.logInfo("------Some notifications success (" + failedNotifications.size() + "):");
                log.logInfo("------Others fail (" + successfulNotifications.size() + "):");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
