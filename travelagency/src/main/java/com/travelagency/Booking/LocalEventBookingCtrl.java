package com.travelagency.Booking;

import java.util.ArrayList;
import java.util.UUID;

import com.travelagency.NotificationModule.EventBookingTemplate;
import com.travelagency.NotificationModule.NotificationManager;
import com.travelagency.NotificationModule.NotificationRequest;
import com.travelagency.NotificationModule.TemplateText;
import com.travelagency.model.AbstractLocalEventBooking;
import com.travelagency.model.LocalEvent;
import com.travelagency.model.LocalEventBooking;
import com.travelagency.model.Model;
import com.travelagency.model.User;

public class LocalEventBookingCtrl {

    protected Model model;
    private NotificationManager notificationManager;

    public LocalEventBookingCtrl(Model model, NotificationManager notificationManager) {
        this.model = model;
        this.notificationManager = notificationManager;
    }

    public boolean checkAvailability(LocalEvent localEvent) {
        if (localEvent.getNumOfTickets() > 0)
            return true;
        return false;
    }

    public LocalEventBooking createBooking(String userID, LocalEvent localEvent) {
        if (checkAvailability(localEvent)) {
            User user = model.getUserWithID(userID);
            if (user == null)
                return null;
            String uuid = UUID.randomUUID().toString();
            String bookingID = uuid.substring(0, 5);
            Integer numOfTickets = localEvent.getNumOfTickets();
            localEvent.setNumOfTickets(numOfTickets - 1);
            double fees = localEvent.getPrice();
            TemplateText template = new EventBookingTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            placeholders.add(localEvent.getName());
            NotificationRequest request = new NotificationRequest("email", user, template, placeholders);
            notificationManager.requestNotification(request);
            LocalEventBooking temp = new LocalEventBooking(bookingID, userID, localEvent.getLocalEventID(), fees);
            model.addLocalEventBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean removeBooking(String bookingID) {
        ArrayList<AbstractLocalEventBooking> bookings = model.getLocalEventBookings();
        for (int i = 0; i < bookings.size(); i++) {
            String ID = bookings.get(i).getBookingID();
            if (ID.equals(bookingID)) {
                return model.removeLocalEventBooking(bookings.get(i));
            }
        }
        return false;
    }
}
