package com.travelagency.Dashboard;
import com.travelagency.NotificationModule.Notifications;
import com.travelagency.model.*;
public interface DisplayStrategy {
  public void display(String userid,Model model, Notifications notificationGetter);
}
