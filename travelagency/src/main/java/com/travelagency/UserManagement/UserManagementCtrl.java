package com.travelagency.UserManagement;
import java.util.ArrayList;
import java.util.UUID;

import com.travelagency.model.Model;
import com.travelagency.model.StandardUser;
import com.travelagency.model.User;

public class UserManagementCtrl {

    private IValidate validationMethod;
    private Model model;

    public UserManagementCtrl(IValidate validationMethod, Model model) {
        this.validationMethod = validationMethod;
        this.model = model;
    }

    public boolean login(String userName, String password){
        User user = validationMethod.validateCredentials(userName, password, model.getUsers());
        if(user!=null) {
            user.setLoggedIn(true);
            return true;
        }
        return false;
    }

    public boolean logout(String userID) {
        User user = model.getUserWithID(userID);
        if(user!=null) {
            user.setLoggedIn(false);
            return true;
        }
        return false;
    }

    public boolean register(String userName, String password, String mail, String phoneNumber){

        String uuid = UUID.randomUUID().toString();
        String userID = uuid.substring(0, 9);

        ArrayList<User> allUsers = model.getUsers();
        boolean available = true;

        for(int i = 0; i<allUsers.size(); i++) {
            String name = allUsers.get(i).getUsername();
            String number = allUsers.get(i).getPhoneNumber();
            String email = allUsers.get(i).getMail();

            if(userName.equals(name) || mail.equals(email) || phoneNumber.equals(number)) {
                available = false;
            }    
        }

        if(available) {
            User user = new StandardUser(userName, password, userID, mail, phoneNumber, false);
            model.addUser(user);
            return true;
        }
        else return false;

    }
    public boolean updatePassword(String userID, String newPassword){
        User user = model.getUserWithID(userID);
        String userName = user.getUsername();
        String password = user.getPassword();
        if(validationMethod.validateCredentials(userName,password,model.getUsers())!=null) {
            if(user.getIsLoggedIn()) {
                user.setPassword(password);
                return true;
            }
        }
        return false;
    }

}
