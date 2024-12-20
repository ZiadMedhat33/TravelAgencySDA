package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.User;

public abstract class BaseDecorator extends NotificationMaker {
    private NotificationMaker notificationMaker;

    public BaseDecorator(NotificationMaker notificationMaker) {
        super(notificationMaker.queueHanlder, notificationMaker.templateMaker);
        this.notificationMaker = notificationMaker;
    }

    public Notification makeNotification(User user, ArrayList<String> placeholders) {
        Notification notification = this.notificationMaker.makeNotification(user, placeholders);
        return notification;
    }

    public void setNotificationMaker(NotificationMaker notificationMaker) {
        this.notificationMaker = notificationMaker;
    }

    public NotificationMaker getNotificationMaker() {
        return notificationMaker;
    }
}