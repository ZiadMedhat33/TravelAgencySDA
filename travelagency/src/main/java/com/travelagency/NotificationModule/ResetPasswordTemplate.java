package com.travelagency.NotificationModule;
public class ResetPasswordTemplate extends TemplateText{
    ResetPasswordTemplate(){
        super("reset password","Dear {x}, this is regarding your password reset request\n");
        super.setPlaceholdersNum(1);
    }
}