package com.travelagency.model;

import java.time.LocalDate;

public class HotelRoomBooking extends AbstractHotelRoomBooking {
    public HotelRoomBooking(String bookingID, LocalDate checkInDate, LocalDate checkOutDate, String userID,
            String hotelRoomID, String hotel, double fees) {
        super(bookingID, checkInDate, checkOutDate, userID, hotelRoomID, hotel, fees);
    }
}
