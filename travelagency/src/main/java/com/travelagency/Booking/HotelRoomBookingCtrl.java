package com.travelagency.Booking;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.travelagency.model.AbstractHotelRoomBooking;
import com.travelagency.model.HotelRoom;
import com.travelagency.model.HotelRoomBooking;
import com.travelagency.model.Model;

public class HotelRoomBookingCtrl {

    protected Model model;

    HotelRoomBookingCtrl(Model model) {
        this.model = model;
    }

    public boolean checkAvailability(HotelRoom hotelRoom) {
        return hotelRoom.getAvailable();
    }

    public HotelRoomBooking createBooking(HotelRoom hotelRoom, Date checkInDate, Date checkOutDate, String userID) {
        if(checkAvailability(hotelRoom)) {
            String uuid = UUID.randomUUID().toString();
            String bookingID = uuid.substring(0, 8);

            long diffInMillis = checkOutDate.getTime() - checkInDate.getTime();
            int diffInDays = (int) TimeUnit.MILLISECONDS.toDays(diffInMillis);

            IHotelFeesCalculator feesCalculator = new HotelFeesCalculator();
            double fees = feesCalculator.calculateFees(hotelRoom.getPrice(),diffInDays);

            //notify()

            HotelRoomBooking temp = new HotelRoomBooking(bookingID, checkInDate, checkOutDate, userID, hotelRoom.getHotelRoomID(), hotelRoom.getHotel(), fees);
            model.addHotelRoomBooking(temp);
            return temp;
        }
        return null;
    }

    public boolean cancelBooking(String bookingID) {
        ArrayList<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
        for(int i = 0; i<bookings.size(); i++) {
            String ID = bookings.get(i).getBookingID();
            if(ID.equals(bookingID)) {
                return model.removeHotelRoomBooking(bookings.get(i));
            }
        }
        return false;
    }

}
