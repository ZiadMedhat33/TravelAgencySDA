package com.travelagency.model;

public abstract class AbstractLocalEventBooking {
    protected String bookingID;
    protected String userID;
    protected String localEventID;
    protected double fees;
    static private long counter = 1000;

    protected AbstractLocalEventBooking(String userID, String localEventID, double fees) {
        this.bookingID = "" + counter++;
        this.userID = userID;
        this.localEventID = localEventID;
        this.fees = fees;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public String getLocalEventID() {
        return localEventID;
    }

    public double getFees() {
        return fees;
    }

}
