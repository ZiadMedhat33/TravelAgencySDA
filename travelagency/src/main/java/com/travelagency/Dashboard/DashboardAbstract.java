package com.travelagency.Dashboard;

import com.travelagency.model.*;
import com.travelagency.NotificationModule.*;
import java.util.ArrayList;

public class DashboardAbstract {
  protected Model model;
  protected String userid;
  protected Notifications notificationGetter;
  protected User user;
  protected boolean isLoggedIn;
  protected ArrayList<LocalEvent> recommendedEvents;

  public DashboardAbstract(Model model, String userid) {
    this.model = model;
    this.userid = userid;
    this.notificationGetter = Notifications.getInstance();
    this.user = getUserById(userid);
  }

  private User getUserById(String userid) {
    return model.getUserWithID(userid);
  }

  public ArrayList<Notification> getNotifications() {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    return notificationGetter.getUserSuccessfulNotifications(userid);
  }

  public ArrayList<Notification> displayFilteredNotifications(String keyword) {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    return notificationGetter.getUserTypeSuccessfulNotifications(keyword, userid);
  }

  public ArrayList<AbstractHotelRoomBooking> display() {
    if (user == null || user.getIsLoggedIn() == false) {
      return null;
    }
    //
    return null;
  }

  public ArrayList<LocalEvent> getRecommendedEvents() {
    if (user == null || !user.getIsLoggedIn()) {
      return null;
    }
    return user.getRecommendedEvents();
  }
}