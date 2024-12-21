package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
public class SMSNotificationManager extends NotificationManager {
    public SMSNotificationManager( Model userModel) {
        super(userModel);
    }
    @Override
    public void requestNotification(NotificationRequest request) {
        maker = new SMSMaker(request.getTemplate());
        statistics = SMSNotificationStatistics.getInstance();
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new SMSSender());
        queueHandler.reset();
    }
}
