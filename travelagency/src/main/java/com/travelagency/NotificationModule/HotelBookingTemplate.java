package com.travelagency.NotificationModule;
public class HotelBookingTemplate extends TemplateText {
    HotelBookingTemplate(){
        super("Hotel booking","Dear {x}, a reservation for hotel {x} has been confirmed \n");
        super.setPlaceholdersNum(2);
    }
}