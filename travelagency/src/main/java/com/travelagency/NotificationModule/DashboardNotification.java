package com.travelagency.NotificationModule;

public class DashboardNotification extends Notification {
    DashboardNotification(String content, String userid, String templateName){
        super( content,  userid,  templateName);
        super.setType("dashboard");
    }
}