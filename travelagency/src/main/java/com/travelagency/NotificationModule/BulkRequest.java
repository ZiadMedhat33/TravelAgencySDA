package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public class BulkRequest extends NotificationRequest {
    private NotificationManager manager;
    public BulkRequest(NotificationManager manager, String typeOfNotification, User user, TemplateText template, ArrayList<String> placeholders){
        super(typeOfNotification, user, template,placeholders);
        this.manager = manager;
    }
    public NotificationManager getManager() {
        return manager;
    }
    public void setManager(NotificationManager manager) {
        this.manager = manager;
    }
}