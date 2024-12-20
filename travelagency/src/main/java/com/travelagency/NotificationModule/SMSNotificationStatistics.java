package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class SMSNotificationStatistics extends NotificationStatistics {
    private Map<String, Integer> numberMap;
    private static SMSNotificationStatistics instance = null;

    private SMSNotificationStatistics(Notifications notificationsData) {
        super(notificationsData);
        numberMap = new HashMap<>();
    }

    public void addNotification(Notification notification) {
        templateMap.put(notification.getTemplateName(),
                templateMap.getOrDefault(notification.getTemplateName(), 0) + 1);
        if (notification instanceof SMS) {
            SMS sms = (SMS) notification;
            numberMap.put(sms.getNumber(), numberMap.getOrDefault(sms.getNumber(), 0) + 1);
        }
        notificationsData.addNotification(notification);
    }

    @Override
    public String getMostNotified() {
        String sms = getMostUsedFromMap(numberMap);
        return sms;
    }

    public static SMSNotificationStatistics getInstance(Notifications notificationsData) {
        if (instance == null)
            instance = new SMSNotificationStatistics(notificationsData);

        return instance;
    }
}
