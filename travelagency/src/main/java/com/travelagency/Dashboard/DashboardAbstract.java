package com.travelagency.Dashboard;
import com.travelagency.model.*;
public class DashboardAbstract{
  protected DisplayStrategy display;
  protected String email;
  protected String username;
  protected Model model;
  public DashboardAbstract(Model model, String email, String username){
    this.model = model;
    this.email = email;
    this.username = username;
  }
  public String getUsername() {
    return username;
  }
  public String getEmail() {
    return email;
  }
  public void setDisplay(DisplayStrategy _display){
    display = _display;
  }
  public void display(){
    display.display(model);
  }
}