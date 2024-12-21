package com.travelagency.NotificationModule;

import com.travelagency.model.User;
import java.util.ArrayList;

public class NotificationRequest {
    private User user;
    private TemplateText template;
    private ArrayList<String> placeholders;

    public NotificationRequest(User user, TemplateText template,
            ArrayList<String> placeholders) {
        this.user = user;
        this.template = template;
        this.placeholders = placeholders;
    }

    public void setPlaceholders(ArrayList<String> placeholders) {
        this.placeholders = placeholders;
    }

    public ArrayList<String> getPlaceholders() {
        return placeholders;
    }

    public void setTemplate(TemplateText template) {
        this.template = template;
    }

    public TemplateText getTemplate() {
        return template;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

}
