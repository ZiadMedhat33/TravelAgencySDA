package com.travelagency.model;

import java.util.Date;

public class HotelRoomBooking extends AbstractHotelRoomBooking{
    public HotelRoomBooking(String bookingID, Date checkInDate, Date checkOutDate, String userID, String hotelRoomID, String hotel, double fees) {
        super(bookingID, checkInDate, checkOutDate, userID, hotelRoomID, hotel, fees);
    }
}
