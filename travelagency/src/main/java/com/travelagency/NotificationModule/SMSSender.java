package com.travelagency.NotificationModule;

import com.travelagency.model.Model;
import com.travelagency.model.User;

public class SMSSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification, Notifications notificationsData, Model usersModel) {
        if (notification == null || usersModel == null) {
            throw new IllegalArgumentException("Notification or usersModel cannot be null");
        }
        if (notification instanceof SMS) {
            SMS sms = (SMS) notification;
            String number = sms.getNumber();
            String id = notification.getUserid();
            boolean isValid = isValidReciever(id, number, usersModel);
            notification.setStatus(isValid);
        } else {
            notification.setStatus(false);
        }
        notificationsData.addNotification(notification);
    }
    @SuppressWarnings("null")
    public boolean isValidReciever(String id, String number, Model usersModel) {
        User user = usersModel.getUserWithID(id);
        boolean isValid = (user != null);
        if (isValid)
            isValid &= number.equals(user.getPhoneNumber());
        return isValid;
    }
}
