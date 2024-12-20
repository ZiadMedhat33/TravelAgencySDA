package com.travelagency.UserManagement;

import java.util.ArrayList;
import java.util.UUID;

import com.travelagency.NotificationModule.EventBookingTemplate;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.NotificationRequest;
import com.travelagency.NotificationModule.RegisterTemplate;
import com.travelagency.NotificationModule.ResetPasswordTemplate;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.Model;
import com.travelagency.model.StandardUser;
import com.travelagency.model.User;

public class UserManagementCtrl {

    private IValidate validationMethod;
    private Model model;
    private NotificationManager notificationManager;

    public UserManagementCtrl(IValidate validationMethod, Model model, NotificationManager manager) {
        this.validationMethod = validationMethod;
        this.model = model;
        this.notificationManager = manager;
    }

    public boolean login(String userName, String password) {
        User user = validationMethod.validateCredentials(userName, password, model.getUsers());
        if (user != null) {
            user.setLoggedIn(true);
            return true;
        }
        return false;
    }

    public boolean logout(String userID) {
        User user = model.getUserWithID(userID);
        if (user != null) {
            user.setLoggedIn(false);
            return true;
        }
        return false;
    }

    public boolean register(String userName, String password, String mail, String phoneNumber) {

        String uuid = UUID.randomUUID().toString();
        String userID = uuid.substring(0, 9);

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
            User user = new StandardUser(userName, password, userID, mail, phoneNumber, false);
            TemplateText template = new RegisterTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            NotificationRequest request1 = new NotificationRequest("email", user, template, placeholders);
            NotificationRequest request2 = new NotificationRequest("sms", user, template, placeholders);

            notificationManager.requestNotification(request1);
            notificationManager.requestNotification(request2);
            model.addUser(user);
            return true;
        } else
            return false;

    }

    public boolean updatePassword(String userID, String newPassword) {
        User user = model.getUserWithID(userID);
        String userName = user.getUsername();
        String password = user.getPassword();
        if (validationMethod.validateCredentials(userName, password, model.getUsers()) != null) {
            if (user.getIsLoggedIn()) {
                user.setPassword(password);
                TemplateText template = new ResetPasswordTemplate();
                ArrayList<String> placeholders = new ArrayList<>();
                placeholders.add(user.getUsername());
                NotificationRequest request1 = new NotificationRequest("email", user, template, placeholders);
                NotificationRequest request2 = new NotificationRequest("sms", user, template, placeholders);
                notificationManager.requestNotification(request1);
                notificationManager.requestNotification(request2);
                return true;
            }
        }
        return false;
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
