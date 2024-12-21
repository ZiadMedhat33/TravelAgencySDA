package com.travelagency.Dashboard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.travelagency.NotificationModule.*;
import com.travelagency.model.*;
public class GetFromDatabase{
  private Map<String,String> setUserData(String userid,Model model) {
    ArrayList<User> users = model.getUsers();
    Map<String, String> user = new HashMap<>();
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserID() == userid) {
        user.put("email", users.get(i).getMail());
        user.put("username", users.get(i).getUsername());
        user.put("phoneNumber", users.get(i).getPhoneNumber());
        return user;
      }
    }
    return null;
  }
  public Map<String,String> getUserByUserid(String userid,Model model){
    Map<String, String> userData = setUserData(userid, model);
    return userData;
  }
  public ArrayList<Notification> getNotifications(Notifications notificationGetter, String userid){
    ArrayList<Notification> notifications;
    notifications = notificationGetter.getUserTypeSuccessfulNotifications("dashboard",userid);
    ArrayList<Notification> notificationResults = new ArrayList<Notification>();
    for (int i = 0; i < notifications.size(); i++) {
      notificationResults.add(notifications.get(i));
    }
    return notificationResults;
  }
  public ArrayList<Notification> getFilteredNotifications(String keyword,Notifications notificationGetter,String userid){
    ArrayList<Notification> notifications;
    notifications = notificationGetter.getUserTypeSuccessfulNotifications("dashboard",userid);
    ArrayList<Notification> filteredNotifications = new ArrayList<Notification>();
    for (int i = 0; i < notifications.size(); i++) {
      if (notifications.get(i).getContent().contains(keyword)) {
        filteredNotifications.add(notifications.get(i));
      }
    }
    return filteredNotifications;
  }
  public ArrayList<AbstractHotelRoomBooking> getHotelBookings(String userid,Model model, Notifications notificationGetter) {
    ArrayList<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
    ArrayList<AbstractHotelRoomBooking> userBookings = new ArrayList<AbstractHotelRoomBooking>();
    for (int i = 0; i < bookings.size(); i++) {
      if (bookings.get(i).getUserID() == userid) {
        userBookings.add(bookings.get(i));
      }
    }
    return userBookings;
  };
  public ArrayList<LocalEvent> getRecommendedEvents(Model model, String userid) {
    User user = model.getUserWithID(userid);
    ArrayList<LocalEvent> recommendedEvents = user.getRecommendedEvents();
    return recommendedEvents;
  }
}
