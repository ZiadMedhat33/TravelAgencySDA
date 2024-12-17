package com.travelagency.model;

public abstract class User {
    protected String username;
    protected String password;
    protected String userID;
    protected String Mail;
    protected String phoneNumber;

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getMail() {
        return Mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
