package com.travelagency.Dashboard;
import java.util.ArrayList;
import com.travelagency.NotificationModule.*;
import com.travelagency.model.*;
public class GetFromDatabase{
  private User setUserData(String userid,Model model) {
    ArrayList<User> users = model.getUsers();
    User user = null;
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUserID() == userid) {
        user = users.get(i);
        return user;
      }
    }
    return null;
  }
  public User getUserByUserid(String userid,Model model){
    User userData = setUserData(userid, model);
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
