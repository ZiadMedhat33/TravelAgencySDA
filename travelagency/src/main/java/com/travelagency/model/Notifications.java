package com.travelagency.model;
import java.util.ArrayList;
import com.travelagency.NotificationModule.Notification;
public class Notifications{
    public ArrayList<Notification> notifications;
    Notifications(){
        this.notifications = new ArrayList<>();
    }
    public ArrayList<Notification> getStatusNotifications(boolean status) {
        ArrayList<Notification> chosenNotifications = new ArrayList<>();
        for(Notification notification : chosenNotifications){
            if(notification.getStatus() == status)chosenNotifications.add(notification);
        }
        return chosenNotifications;
    }
    public void addNotification(Notification newNotification) {
        notifications.add(newNotification);
    }
}