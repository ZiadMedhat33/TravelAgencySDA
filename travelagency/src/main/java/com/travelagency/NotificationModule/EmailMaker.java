package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public class EmailMaker extends NotificationMaker{//needs modification
    EmailMaker(QueueHandler queueHandler, TemplateMaker maker){
        super(queueHandler, maker);
    }
    public Notification makeNotification(User user, ArrayList<String> placeholders){
        boolean isValid = templateMaker.isValid(placeholders);
        if (!isValid) {
            throw new IllegalArgumentException("Invalid placeholders for email template.");
        }
        String content = templateMaker.useTemplate(placeholders);
        Notification newNotification = new Email(content, user.getUserID(), user.getMail(), templateMaker.getTemplate().getTemplateName());
        newNotification.setStatus(isValid);
        return newNotification;
    }
}