package com.travelagency.NotificationModule;

public abstract class Notification {
    private String content;
    private boolean status = true;
    private String userid;
    private String templateName;
    private String type;

    public Notification(String content, String userid, String templateName) {
        this.content = content;
        this.userid = userid;
        this.templateName = templateName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getContent() {
        return content;
    }

    public boolean getStatus() {
        return status;
    }

    public String getUserid() {
        return userid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
