package com.travelagency.NotificationModule;
import com.travelagency.model.User;
import java.util.ArrayList;
public class NotificationRequest {
    public String typeOfNotification;
    public User user;
    public TemplateText template;
    public ArrayList<String> placeholders;
}
