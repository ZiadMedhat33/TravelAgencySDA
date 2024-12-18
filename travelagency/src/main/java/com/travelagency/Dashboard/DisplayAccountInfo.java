package com.travelagency.Dashboard;

import com.travelagency.model.*;
public class DisplayAccountInfo implements DisplayStrategy {
  @Override
  public void display(User user,Model model){
    System.out.println("User id: "+user.getUserID());
    System.out.println("Username: "+user.getUsername());
    System.out.println("User Email: "+user.getMail());
    System.out.println("User Phone Number: "+user.getPhoneNumber());
  }
}
