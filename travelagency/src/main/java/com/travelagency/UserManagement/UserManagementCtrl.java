package com.travelagency.UserManagement;

import java.util.ArrayList;

import com.travelagency.NotificationModule.EmailNotificationManager;
import com.travelagency.NotificationModule.ManagerBaseDecorator;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.NotificationRequest;
import com.travelagency.NotificationModule.RegisterTemplate;
import com.travelagency.NotificationModule.ResetPasswordTemplate;
import com.travelagency.NotificationModule.SMSNotificationManager;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.Model;
import com.travelagency.model.StandardUser;
import com.travelagency.model.User;

public class UserManagementCtrl {

    private IValidate validationMethod;
    private Model model;
    private ManagerBaseDecorator notificationManagerDecorator;

    public UserManagementCtrl(IValidate validationMethod, Model model, ManagerBaseDecorator manager) {
        this.validationMethod = validationMethod;
        this.model = model;
        this.notificationManagerDecorator = manager;
    }

    public User login(String userName, String password) {
        User user = validationMethod.validateCredentials(userName, password, model.getUsers());
        if (user != null) {
            user.setLoggedIn(true);
            return user;
        }
        return user;
    }

    public User logout(String userID) {
        User user = model.getUserWithID(userID);
        if (user != null) {
            user.setLoggedIn(false);
            return user;
        }
        return null;
    }

    public User Register(String userName, String password, String mail, String phoneNumber) {

        ArrayList<User> allUsers = model.getUsers();
        boolean available = true;

        for (int i = 0; i < allUsers.size(); i++) {
            String name = allUsers.get(i).getUsername();
            String number = allUsers.get(i).getPhoneNumber();
            String email = allUsers.get(i).getMail();

            if (userName.equals(name) || mail.equals(email) || phoneNumber.equals(number)) {
                available = false;
            }
        }

        if (available) {
            User user = new StandardUser(userName, password, mail, phoneNumber, false);
            model.addUser(user);
            TemplateText template = new RegisterTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            NotificationRequest request1 = new NotificationRequest(user,template, placeholders);
            NotificationRequest request2 = new NotificationRequest(user, template,placeholders);
            notificationManagerDecorator.setNotificationManager(new EmailNotificationManager(model));
            notificationManagerDecorator.requestNotification(request1);
            notificationManagerDecorator.setNotificationManager(new SMSNotificationManager(model));
            notificationManagerDecorator.requestNotification(request2);
            return user;
        } else
            return null;

    }

    public User updatePassword(String userID, String newPassword) {
        User user = model.getUserWithID(userID);
        if (user == null)
            return null;
        String userName = user.getUsername();
        String password = user.getPassword();
        if (validationMethod.validateCredentials(userName, password, model.getUsers()) != null) {
            if (user.getIsLoggedIn()) {
                user.setPassword(newPassword);
                TemplateText template = new ResetPasswordTemplate();
                ArrayList<String> placeholders = new ArrayList<>();
                placeholders.add(user.getUsername());
                NotificationRequest request1 = new NotificationRequest(user,template, placeholders);
                NotificationRequest request2 = new NotificationRequest(user, template,placeholders);
                notificationManagerDecorator.setNotificationManager(new EmailNotificationManager(model));
                notificationManagerDecorator.requestNotification(request1);
                notificationManagerDecorator.setNotificationManager(new SMSNotificationManager(model));
                notificationManagerDecorator.requestNotification(request2);
                return user;
            }
        }
        return null;
    }

    public boolean checkMail(String mail) {
        boolean found = false;
        ArrayList<User> users = model.getUsers();
        for (int i = 0; i < users.size(); i++) {
            String userMail = users.get(i).getMail();
            if (mail.equals(userMail)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean checkPhoneNumber(String number) {
        boolean found = false;
        ArrayList<User> users = model.getUsers();
        for (int i = 0; i < users.size(); i++) {
            String userNumber = users.get(i).getPhoneNumber();
            if (number.equals(userNumber)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public boolean checkID(String ID) {
        boolean found = false;
        ArrayList<User> users = model.getUsers();
        for (int i = 0; i < users.size(); i++) {
            String userID = users.get(i).getUserID();
            if (ID.equals(userID)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
