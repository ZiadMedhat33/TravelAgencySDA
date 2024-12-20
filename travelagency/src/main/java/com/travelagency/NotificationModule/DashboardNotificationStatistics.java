package com.travelagency.NotificationModule;

import java.util.Map;
import java.util.HashMap;

public class DashboardNotificationStatistics extends NotificationStatistics {
    private Map<String, Integer> dashboardTemplates;
    private static DashboardNotificationStatistics instance = null;

    private DashboardNotificationStatistics(Notifications notificationsData) {
        super(notificationsData);
        dashboardTemplates = new HashMap<>();
    }

    public void addNotification(Notification notification) {
        templateMap.put(notification.getTemplateName(),
                templateMap.getOrDefault(notification.getTemplateName(), 0) + 1);
        if (notification instanceof DashboardNotification) {
            DashboardNotification dash = (DashboardNotification) notification;
            dashboardTemplates.put(dash.getTemplateName(),
                    dashboardTemplates.getOrDefault(dash.getTemplateName(), 0) + 1);
        }
        notificationsData.addNotification(notification);
    }

    @Override
    public String getMostNotified() {
        String dash = getMostUsedFromMap(dashboardTemplates);
        return dash;
    }

    public static DashboardNotificationStatistics getInstance(Notifications notificationsData) {
        if (instance == null)
            instance = new DashboardNotificationStatistics(notificationsData);

        return instance;
    }
}