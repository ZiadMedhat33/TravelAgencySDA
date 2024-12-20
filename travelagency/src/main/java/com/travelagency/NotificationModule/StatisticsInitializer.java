package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class StatisticsInitializer {
    private Map<String, NotificationStatistics> statisticsTypes = new HashMap<>();

    public StatisticsInitializer(Notifications notificationsData) {
        statisticsTypes.put("email", EmailNotificationStatistics.getInstance(notificationsData));
        statisticsTypes.put("sms", SMSNotificationStatistics.getInstance(notificationsData));
        statisticsTypes.put("dashboard", DashboardNotificationStatistics.getInstance(notificationsData));
    }

    public NotificationStatistics getStatisticsType(String type) {
        return statisticsTypes.get(type);
    }
}