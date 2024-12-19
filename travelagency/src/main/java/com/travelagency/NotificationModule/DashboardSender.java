package com.travelagency.NotificationModule;
import com.travelagency.model.Model;
import com.travelagency.model.Notifications;
import com.travelagency.model.User;
public class DashboardSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification, Notifications notificationsData, Model usersModel) {
        if (notification instanceof DashboardNotification) {
            DashboardNotification dash = (DashboardNotification) notification;
            String id = dash.getUserid();
            boolean isValid = isValidReciever(id, usersModel);
            notification.setStatus(isValid);
        } else {
            notification.setStatus(false);
        }
        notificationsData.addNotification(notification);
    }
    public boolean isValidReciever(String id, Model usersModel){
        User user = usersModel.getUserWithID(id);
        boolean isValid = (user != null);
        return isValid;
    }
}