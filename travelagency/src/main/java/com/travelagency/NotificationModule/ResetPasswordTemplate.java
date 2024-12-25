package com.travelagency.NotificationModule;

public class ResetPasswordTemplate extends TemplateText {
    public ResetPasswordTemplate() {
        super("Dear {x}, this is regarding updating of your password\n", "Update Password");
        super.setPlaceholdersNum(1);
    }
}