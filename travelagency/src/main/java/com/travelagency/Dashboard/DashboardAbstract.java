package com.travelagency.Dashboard;
import com.travelagency.NotificationModule.Notifications;
import com.travelagency.model.*;
import java.util.Map;
import java.util.ArrayList;
public class DashboardAbstract{
  protected Model model;
  protected String userid;
  protected Notifications notificationGetter;
  protected GetFromDatabase getFromDatabase;
  protected ArrayList<LocalEvent> recommendedEvents;
  public DashboardAbstract(Model model, String userid,Notifications notificationGetter){
    this.model = model;
    this.userid = userid;
    this.notificationGetter = notificationGetter;
  }
  public Map<String,String> getUserById(String userid){
    return getFromDatabase.getUserByUserid(userid, model);
  }
  public ArrayList<String> getNotifications(){
    return getFromDatabase.getNotifications(notificationGetter);
  }
  public ArrayList<String> displayFilteredNotifications(String keyword){
    return getFromDatabase.displayFilteredNotifications(keyword,notificationGetter);
  }
  public ArrayList<AbstractHotelRoomBooking> display(){
    return getFromDatabase.display(userid,model,notificationGetter);
  }
  public ArrayList<LocalEvent> getRecommendedEvents() {
    return getFromDatabase.getRecommendedEvents(model, userid);
  }
}