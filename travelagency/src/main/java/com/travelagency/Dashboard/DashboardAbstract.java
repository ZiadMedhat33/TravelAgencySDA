package com.travelagency.Dashboard;
import com.travelagency.model.*;
public class DashboardAbstract{
  protected DisplayStrategy display;
  protected User user;
  protected Model model;
  public DashboardAbstract(Model model, User user){
    this.model = model;
    this.user = user;
  }
  public void setDisplay(DisplayStrategy _display){
    display = _display;
  }
  public void display(){
    display.display(user,model);
  }
}