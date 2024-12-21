package com.travelagency.Dashboard;
import com.travelagency.model.*;
import java.util.ArrayList;
import com.travelagency.NotificationModule.*;
public class DisplayNotifications implements DisplayStrategy {
  @Override
  public void display(String userid,Model model, Notifications notificationGetter){
    ArrayList<Notification> notifications;
    notifications = notificationGetter.getTypeSuccessfulNotifications("dashboard");
    for (int i = 0; i < notifications.size(); i++) {
      System.out.println(notifications.get(i).getContent());
    }
  }
  public void displayFilteredNotifications(String keyword,Model model, Notifications notificationGetter){
    ArrayList<Notification> notifications;
    notifications = notificationGetter.getTypeSuccessfulNotifications("dashboard");
    for (int i = 0; i < notifications.size(); i++) {
      if (notifications.get(i).getContent().contains(keyword)) {
        System.out.println(notifications.get(i).getContent());
      }
    }
  }
}
