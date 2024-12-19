package com.travelagency.NotificationModule;
import java.util.ArrayList;

import com.travelagency.model.User;
public abstract class NotificationMaker {
    protected TemplateMaker templateMaker;
    protected QueueHandler queueHanlder;
    protected NotificationStatistics statistics;
    NotificationMaker(QueueHandler queueHandler, TemplateMaker maker){
        this.templateMaker = maker;
        this.queueHanlder = queueHandler;
    }
    public QueueHandler getQueueHanlder() {
        return queueHanlder;
    }
    public TemplateMaker getTemplateMaker() {
        return templateMaker;
    }
    public void setQueueHanlder(QueueHandler queueHanlder) {
        this.queueHanlder = queueHanlder;
    }
    public void setTemplateMaker(TemplateMaker templateMaker) {
        this.templateMaker = templateMaker;
    }
    public void setTemplate(TemplateMaker maker) {
        this.templateMaker = maker;
    }
    public abstract Notification makeNotification(User user, ArrayList<String> placeholders);
}