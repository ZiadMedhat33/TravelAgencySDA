package com.travelagency.NotificationModule;

import java.util.HashMap;
import java.util.Map;

public class SenderInitializer {
    private Map<String, NotificationSender> senders = new HashMap<>();

    public SenderInitializer() {
        senders.put("email", new EmailSender());
        senders.put("sms", new SMSSender());
        senders.put("dashboard", new DashboardSender());
    }

    public NotificationSender getSender(String type) {
        return senders.get(type);
    }
}
