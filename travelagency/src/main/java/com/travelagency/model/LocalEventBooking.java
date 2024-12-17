package com.travelagency.model;

public class LocalEventBooking extends AbstractLocalEventBooking{
    public LocalEventBooking(String bookingID, String userID, String localEventID, double fees) {
        super(bookingID, userID, localEventID, fees);
    }
}
