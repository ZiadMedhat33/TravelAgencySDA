package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
public class EmailNotificationManager extends NotificationManager {
    public EmailNotificationManager(Notifications notificationsData, Model userModel) {
        super(notificationsData, userModel);
    }
    @Override
    public void requestNotification(NotificationRequest request) {
        maker = new EmailMaker(request.getTemplate());
        statistics = EmailNotificationStatistics.getInstance(notificationsData);
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new EmailSender());
        queueHandler.reset();
    }
}
