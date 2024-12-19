package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class MakerInitializer{
    private Map<String, NotificationMaker> makers = new HashMap<>();
    MakerInitializer(QueueHandler queueHandler,TemplateMaker templateMaker){
        makers.put("email", new EmailMaker(queueHandler, templateMaker));
        makers.put("sms", new SMSMaker(queueHandler, templateMaker));
        makers.put("dashboard", new DashboardMaker(queueHandler, templateMaker));
    }
    public NotificationMaker getMaker(String type){
        return makers.get(type);
    }
}
