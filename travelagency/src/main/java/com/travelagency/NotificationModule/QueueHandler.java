package com.travelagency.NotificationModule;

import java.util.ArrayList;
import java.util.Queue;
import com.travelagency.model.Model;
import java.util.ArrayDeque;
public class QueueHandler {
    private Queue<Notification> notificationQueue;
    private static QueueHandler instance = null;
    private SenderInitializer setter;
    private Notifications notificationsData;
    private Model usersModel;

    private QueueHandler(Notifications notificationsData, Model usersModel) {
        notificationQueue = new ArrayDeque<>();
        setter = new SenderInitializer();
        this.notificationsData = notificationsData;
        this.usersModel = usersModel;
    }

    public void pushNotification(Notification notification) {
        this.notificationQueue.add(notification);
    }

    public void pushBulkNotification(ArrayList<Notification> notifications) {
        for (Notification notification : notifications) {
            pushNotification(notification);
        }
    }

    public Notification pullNotification() {
        return this.notificationQueue.poll();
    }

    public void handleNotifications() {
        while (!notificationQueue.isEmpty()) {
            Notification toBeSent = notificationQueue.poll();
            NotificationSender sender = setter.getSender(toBeSent.getType());
            if (sender != null) {
                sender.sendNotification(toBeSent, notificationsData, usersModel);
            } else {
                toBeSent.setStatus(false);
            }
        }
    }

    public static QueueHandler getInstance(Notifications notificationsData, Model usersModel) {
        if (instance == null)
            instance = new QueueHandler(notificationsData, usersModel);

        return instance;
    }
}
