package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class MakerInitializer {
    private Map<String, NotificationMaker> makers = new HashMap<>();

    public MakerInitializer(QueueHandler queueHandler, TemplateMaker templateMaker) {
        makers.put("email", new EmailMaker(queueHandler, templateMaker));
        makers.put("sms", new SMSMaker(queueHandler, templateMaker));
        makers.put("dashboard", new DashboardMaker(queueHandler, templateMaker));
    }

    public NotificationMaker getMaker(String type) {
        if(makers.get(type) == null){
            System.out.println("The invalid type is" + type);
            return makers.get("email");
        }
        return makers.get(type);
    }
}
