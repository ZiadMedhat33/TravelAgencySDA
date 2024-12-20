package com.travelagency.NotificationModule;

import java.util.ArrayList;

import com.travelagency.model.Model;

public class NotificationManager {
    private QueueHandler queueHandler;
    private BaseDecorator maker;
    private MakerInitializer makerSetter;
    private StatisticsInitializer statisticsSetter;
    private NotificationStatistics statistics;

    public NotificationManager(Notifications notificationsData, Model userModel) {
        this.queueHandler = QueueHandler.getInstance(notificationsData, userModel);
        statisticsSetter = new StatisticsInitializer(notificationsData);
    }

    public void setVariables(TemplateText template, String typeOfNotification) {
        TemplateMaker templateMaker = new TemplateMaker(template);
        this.makerSetter = new MakerInitializer(queueHandler, templateMaker);
        if(maker == null){
            maker = new BaseDecorator(makerSetter.getMaker(typeOfNotification));
        }else{
            maker.setNotificationMaker(makerSetter.getMaker(typeOfNotification));
        }
        statistics = statisticsSetter.getStatisticsType(typeOfNotification);
        if (maker == null || statistics == null) {
            throw new IllegalArgumentException("Invalid notification type: " + typeOfNotification);
        }
    }

    public void requestNotification(NotificationRequest request) {
        setVariables(request.getTemplate(), request.getTypeOfNotification());
        Notification newNotification = maker.makeNotification(request.getUser(), request.getPlaceholders());
        statistics.addNotification(newNotification);
        queueHandler.pushNotification(newNotification);
        queueHandler.handleNotifications();
    }

    public void requestBulkNotification(ArrayList<NotificationRequest> requests) {
        ArrayList<Notification> notifications = new ArrayList<>();
        for (NotificationRequest request : requests) {
            setVariables(request.getTemplate(), request.getTypeOfNotification());
            notifications.add(maker.makeNotification(request.getUser(), request.getPlaceholders()));
        }
        storeBulkStatistics(notifications);
        queueHandler.pushBulkNotification(notifications);
        queueHandler.handleNotifications();
    }

    public void storeBulkStatistics(ArrayList<Notification> notifications) {
        for (Notification notification : notifications) {
            statistics.addNotification(notification);
        }
    }

    public NotificationStatistics getStatistics(String type) {
        return statisticsSetter.getStatisticsType(type);
    }
}
