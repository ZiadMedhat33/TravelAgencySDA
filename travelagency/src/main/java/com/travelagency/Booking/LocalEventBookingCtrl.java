package com.travelagency.Booking;

import java.util.ArrayList;
import java.util.UUID;

import com.travelagency.model.AbstractLocalEventBooking;
import com.travelagency.model.LocalEvent;
import com.travelagency.model.LocalEventBooking;
import com.travelagency.model.Model;

public class LocalEventBookingCtrl {

    protected Model model;

    public LocalEventBookingCtrl(Model model) {
        this.model = model;
    }

    public boolean checkAvailability(LocalEvent localEvent) {
        if(localEvent.getNumOfTickets()>0) return true;
        return false;
    }

    public LocalEventBooking createBooking(String userID, LocalEvent localEvent) {
        if(checkAvailability(localEvent)) {

            String uuid = UUID.randomUUID().toString();
            String bookingID = uuid.substring(0, 5);

            double fees = localEvent.getPrice();
            LocalEventBooking temp = new LocalEventBooking(bookingID, userID, localEvent.getLocalEventID(), fees);
            model.addLocalEventBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean removeBooking(String bookingID) {
        ArrayList<AbstractLocalEventBooking> bookings = model.getLocalEventBookings();
        for(int i = 0; i<bookings.size(); i++) {
            String ID = bookings.get(i).getBookingID();
            if(ID.equals(bookingID)) {
                return model.removeLocalEventBooking(bookings.get(i));
            }
        }
        return false;
    }
}
