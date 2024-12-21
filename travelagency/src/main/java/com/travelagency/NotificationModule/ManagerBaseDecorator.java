package com.travelagency.NotificationModule;

import com.travelagency.model.Model;

public class ManagerBaseDecorator extends NotificationManager {
    private NotificationManager notificationManager;

    public ManagerBaseDecorator(Notifications notificationsData, Model userModel) {
        super(notificationsData, userModel);
    }
    public void requestNotification(NotificationRequest request){
        notificationManager.requestNotification(request);
    }
    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    public NotificationManager getNotificationManager() {
        return notificationManager;
    }
}