package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
public class EmailNotificationManager extends NotificationManager {
    public EmailNotificationManager(Model userModel) {
        super(userModel);
    }
    @Override
    public void requestNotification(NotificationRequest request) {
        maker = new EmailMaker(request.getTemplate());
        statistics = EmailNotificationStatistics.getInstance();
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new EmailSender());
        queueHandler.reset();
    }
}
