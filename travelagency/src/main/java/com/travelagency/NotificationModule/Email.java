package com.travelagency.NotificationModule;

public class Email extends Notification{
    private String email;
    Email(String content, String userid, String email, String templateName){
        super(content, userid,templateName);
        this.email = email;
        this.setType("email");
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}