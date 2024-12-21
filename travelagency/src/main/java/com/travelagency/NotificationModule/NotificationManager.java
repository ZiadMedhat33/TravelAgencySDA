package com.travelagency.NotificationModule;
import java.util.ArrayList;

import com.travelagency.model.Model;

public abstract class NotificationManager {
    protected QueueHandler queueHandler;
    protected NotificationMaker maker;
    protected NotificationStatistics statistics;
    protected NotificationSender sender;
    protected Notifications notificationsData;
    public NotificationManager(Model userModel) {
        this.queueHandler = QueueHandler.getInstance(userModel);
        this.notificationsData = Notifications.getInstance();
    }
    public abstract void requestNotification(NotificationRequest request);

    public void requestBulkNotification(ArrayList<BulkRequest> requests) {
        for (BulkRequest request : requests) {
            request.getManager().requestNotification(request);
        }
    }
    public Notifications getNotificationsData() {
        return notificationsData;
    }
}
