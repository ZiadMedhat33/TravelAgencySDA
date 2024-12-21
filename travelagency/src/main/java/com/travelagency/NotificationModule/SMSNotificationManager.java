package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
public class SMSNotificationManager extends ManagerBaseDecorator {
    public SMSNotificationManager(Notifications notificationsData, Model userModel) {
        super(notificationsData,userModel);
    }
    @Override
    public void requestNotification(NotificationRequest request) {
        maker = new SMSMaker(request.getTemplate());
        statistics = SMSNotificationStatistics.getInstance(notificationsData);
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new SMSSender());
        queueHandler.reset();
    }
}
