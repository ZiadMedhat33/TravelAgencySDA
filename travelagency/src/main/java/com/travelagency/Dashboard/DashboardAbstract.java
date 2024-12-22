package com.travelagency.Dashboard;
import com.travelagency.model.*;
import com.travelagency.NotificationModule.*;
import java.util.ArrayList;
public class DashboardAbstract{
  protected Model model;
  protected String userid;
  protected Notifications notificationGetter;
  protected User user;
  protected boolean isLoggedIn;
  protected GetFromDatabase getFromDatabase;
  protected ArrayList<LocalEvent> recommendedEvents;
  public DashboardAbstract(Model model, String userid){
    this.getFromDatabase = new GetFromDatabase();
    this.model = model;
    this.userid = userid;
    this.notificationGetter = Notifications.getInstance();
    this.user = getUserById(userid);
    this.isLoggedIn = isLoggedIn();
  }
  private User getUserById(String userid){
    return getFromDatabase.getUserByUserid(userid, model);
  }
  private boolean isLoggedIn(){
    return user.getIsLoggedIn();
  }
  public ArrayList<Notification> getNotifications(){
    if (isLoggedIn == false) {
      return null;
    }
    return getFromDatabase.getNotifications(notificationGetter,userid);
  }
  public ArrayList<Notification> displayFilteredNotifications(String keyword){
    if (isLoggedIn == false) {
      return null;
    }
    return getFromDatabase.getFilteredNotifications(keyword,notificationGetter,userid);
  }
  public ArrayList<AbstractHotelRoomBooking> display(){
    if (isLoggedIn == false) {
      return null;
    }
    return getFromDatabase.getHotelBookings(userid,model,notificationGetter);
  }
  public ArrayList<LocalEvent> getRecommendedEvents() {
    if (isLoggedIn == false) {
      return null;
    }
    return getFromDatabase.getRecommendedEvents(model, userid);
  }
}