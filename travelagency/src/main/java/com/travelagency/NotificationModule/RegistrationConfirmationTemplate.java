package com.travelagency.NotificationModule;
public class RegistrationConfirmationTemplate extends TemplateText{
    RegistrationConfirmationTemplate(){
        super("registration confirmation","Dear {x}, your account with username {x} has been created successfully\n");
        super.setPlaceholdersNum(2);
    }
}