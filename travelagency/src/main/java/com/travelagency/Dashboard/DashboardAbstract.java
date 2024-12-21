package com.travelagency.Dashboard;
import com.travelagency.NotificationModule.Notifications;
import com.travelagency.model.*;
public class DashboardAbstract{
  protected DisplayStrategy display;
  protected Model model;
  protected String userid;
  protected Notifications notificationGetter;
  public DashboardAbstract(Model model, String userid, Notifications notificationGetter){
    this.model = model;
    this.userid = userid;
    this.notificationGetter = notificationGetter;
  }
  public void setDisplay(DisplayStrategy _display){
    display = _display;
  }
  public void display(){
    display.display(userid,model,notificationGetter);
  }
}