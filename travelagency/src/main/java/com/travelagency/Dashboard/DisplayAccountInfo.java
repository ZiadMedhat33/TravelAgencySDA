package com.travelagency.Dashboard;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.travelagency.NotificationModule.Notifications;
import com.travelagency.model.*;
public class DisplayAccountInfo implements DisplayStrategy {
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
  @Override
  public void display(String userid,Model model, Notifications notificationGetter){
    Map<String, String> userData = setUserData(userid, model);
    System.out.println("User id: "+userid);
    System.out.println("Username: "+userData.get("username"));
    System.out.println("User Email: "+userData.get("email"));
    System.out.println("User Phone Number: "+userData.get("phoneNumber"));
  }
}
