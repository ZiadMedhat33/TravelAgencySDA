package com.travelagency.NotificationModule;

import com.travelagency.model.Notifications;
import com.travelagency.model.Model;
public interface NotificationSender {
    public abstract void sendNotification(Notification notification, Notifications notificationsData, Model usersModel);
}
