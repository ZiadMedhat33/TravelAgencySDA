package com.travelagency.NotificationModule;
import com.travelagency.model.Model;
import com.travelagency.model.Notifications;
import com.travelagency.model.User;
public class EmailSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification, Notifications notificationsData, Model usersModel) {
        if (notification instanceof Email) {
            Email mail = (Email) notification;
            String mailText = mail.getEmail();
            String id = notification.getUserid();
            boolean isValid = isValidReciever(id, mailText, usersModel);
            notification.setStatus(isValid);
        } else {
            notification.setStatus(false);
        }
        notificationsData.addNotification(notification);
    }
    @SuppressWarnings("null")
    public boolean isValidReciever(String id, String email, Model usersModel){
        User user = usersModel.getUserWithID(id);
        boolean isValid = (user != null);
        if(isValid)isValid &= email.equals(user.getMail());
        return isValid;
    }
}