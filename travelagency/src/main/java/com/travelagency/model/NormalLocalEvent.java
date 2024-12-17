package com.travelagency.model;

public class NormalLocalEvent extends LocalEvent {
    public NormalLocalEvent(String address, String city, String localEventID, String organizer, String name,
            Double price) {
        super(address, city, localEventID, organizer, name, price);
    }
}
