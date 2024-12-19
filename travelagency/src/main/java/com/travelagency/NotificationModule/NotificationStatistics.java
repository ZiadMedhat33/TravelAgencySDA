package com.travelagency.NotificationModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.travelagency.model.Notifications;

public abstract class NotificationStatistics {
    protected Map<String, Integer> templateMap;
    protected Notifications notificationsData;
    NotificationStatistics(Notifications notificationsData){
        this.templateMap = new HashMap<>();
        this.notificationsData = notificationsData;
    }
    public abstract void addNotification(Notification notification);
    public int getNumberOfSuccessfull(){
        int counter = 0;
        ArrayList<Notification> notifications = notificationsData.getStatusNotifications(false);
        for (Notification notification : notifications) {
            if(notification.getStatus() == true)counter++;
        }
        return counter;
    }
    public int getNumberOfUnSuccessfull(){
        int counter = 0;
        ArrayList<Notification> notifications = notificationsData.getStatusNotifications(true);
        for (Notification notification : notifications) {
            if(notification.getStatus() == false)counter++;
        }
        return counter;
    }
    public String getMostUsedFromMap(Map<String, Integer> map){
        int max = 0;
        String maxText = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String text = entry.getKey();
            int value = entry.getValue();
            if(value > max){
                max = value;
                maxText = text;
            }
        }
        return maxText;
    }
    public abstract String getMostNotified();
    public String getMostSentTemplate(){
        String template = getMostUsedFromMap(templateMap);
        return template;
    }
}
