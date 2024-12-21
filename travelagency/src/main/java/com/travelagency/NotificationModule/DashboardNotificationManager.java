package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
public class DashboardNotificationManager extends ManagerBaseDecorator {
    public DashboardNotificationManager(Notifications notificationsData, Model userModel) {
        super(notificationsData,userModel);
    }
    @Override
    public void requestNotification(NotificationRequest request) {
        maker = new DashboardMaker(request.getTemplate());
        statistics = DashboardNotificationStatistics.getInstance(notificationsData);
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification, new DashboardSender());
        queueHandler.reset();
    }
}
