package com.travelagency.NotificationModule;
public class EventBookingTemplate extends TemplateText {
    EventBookingTemplate(){
        super("Event booking" ,"Dear {x}, a reservation for event {x} has been confirmed\n");
        super.setPlaceholdersNum(2);
    }
}