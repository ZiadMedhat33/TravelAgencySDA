package com.travelagency.model;

public class NormalLocalEvent extends LocalEvent {
    public NormalLocalEvent(String address, String city, String localEventID, String organizer, String name,
            Double price, int numOftickets) {
        super(address, city, localEventID, organizer, name, price, numOftickets);
    }
}
