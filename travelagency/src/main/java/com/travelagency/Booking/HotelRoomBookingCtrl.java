package com.travelagency.Booking;

import java.util.ArrayList;
import java.util.UUID;

import com.travelagency.model.AbstractHotelRoomBooking;
import com.travelagency.model.HotelRoom;
import com.travelagency.model.HotelRoomBooking;
import com.travelagency.model.Model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.travelagency.NotificationModule.*;
import com.travelagency.model.User;

public class HotelRoomBookingCtrl {

    private Model model;
    private NotificationManager notificationManager;
    IHotelFeesCalculator feesCalculator;

    public HotelRoomBookingCtrl(Model model, NotificationManager notificationManager) {
        this.model = model;
        feesCalculator = new HotelFeesCalculator();
    }

    public boolean checkAvailability(HotelRoom hotelRoom) {
        return hotelRoom.getAvailable();
    }

    public AbstractHotelRoomBooking createBooking(HotelRoom hotelRoom, LocalDate checkInDate, LocalDate checkOutDate,
            String userID) {
        if (checkAvailability(hotelRoom)) {
            String uuid = UUID.randomUUID().toString();
            String bookingID = uuid.substring(0, 8);

            int diffInDays = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);

            double fees = feesCalculator.calculateFees(hotelRoom.getPrice(), diffInDays);
            hotelRoom.setAvailable(false);
            User user = model.getUserWithID(userID);
            TemplateText template = new HotelBookingTemplate();
            ArrayList<String> placeholders = new ArrayList<>();
            placeholders.add(user.getUsername());
            placeholders.add(hotelRoom.getName());
            NotificationRequest request = new NotificationRequest("email", user, template, placeholders);
            notificationManager.requestNotification(request);
            AbstractHotelRoomBooking temp = new HotelRoomBooking(bookingID, checkInDate, checkOutDate, userID,
                    hotelRoom.getHotelRoomID(), hotelRoom.getHotel(), fees);
            model.addHotelRoomBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean cancelBooking(String bookingID) {
        ArrayList<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
        for (int i = 0; i < bookings.size(); i++) {
            String ID = bookings.get(i).getBookingID();
            HotelRoom room = model.getHotelRoomWithID(bookings.get(i).getHotelRoomID());
            if (ID.equals(bookingID)) {
                room.setAvailable(true);
                return model.removeHotelRoomBooking(bookings.get(i));
            }
        }
        return false;
    }

    public void setFeesCalculator(IHotelFeesCalculator feesCalculator) {
        this.feesCalculator = feesCalculator;
    }

    public IHotelFeesCalculator getFeesCalculator() {
        return feesCalculator;
    }
}
