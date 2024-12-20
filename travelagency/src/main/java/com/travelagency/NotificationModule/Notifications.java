package com.travelagency.NotificationModule;

import java.util.ArrayList;

public class Notifications {
    public ArrayList<Notification> notifications;
    private static Notifications instance = null;
    private Notifications() {
        this.notifications = new ArrayList<>();
    }
    public static Notifications getInstance() {
        if (instance == null)
            instance = new Notifications();
        return instance;
    }
    public ArrayList<Notification> getStatusNotifications(boolean status) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() == status)
                chosenNotifications.add(notification);
        }
        return chosenNotifications;
    }
    public ArrayList<Notification> getUserSuccessfulNotifications(String userid) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getUserid() == userid)
                chosenNotifications.add(notification);
        }
        return chosenNotifications;
    }
    public ArrayList<Notification> getUserTypeSuccessfulNotifications(String type, String userid) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getType() == type && notification.getUserid() == userid)
                chosenNotifications.add(notification);
        }
        return chosenNotifications;
    }
    public ArrayList<Notification> getTypeSuccessfulNotifications(String type) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getOverallStatus() && notification.getType() == type)
                chosenNotifications.add(notification);
        }
        return chosenNotifications;
    }
    public void addNotification(Notification newNotification) {
        notifications.add(newNotification);
        updateDatabaseInNotifications("adds notification");
    }

    public void updateDatabaseInNotifications(String query) {
        // mimics that it updates the notifications in the database
    }
}