package com.travelagency.Dashboard;
import java.util.List;
import com.travelagency.model.*;
public class DisplayBookings implements DisplayStrategy{
  @Override
  public void display(User user,Model model) {
    String userId = user.getUserID();
    List<AbstractHotelRoomBooking> bookings = model.getHotelRoomBookings();
    for (int i = 0; i < bookings.size(); i++) {
      if (bookings.get(i).getUserID() == userId) {
        System.out.println("booking id: " + bookings.get(i).getBookingID() + "in:"+ bookings.get(i).getHotel());
        System.out.println("    "+"booking fees: " + bookings.get(i).getFees());
        System.out.println("    "+"Hotel room:"+ bookings.get(i).getHotelRoomID());
        System.out.println("    "+"CHeckin date: " + bookings.get(i).getCheckInDate());
        System.out.println("    "+"Checkout date: " + bookings.get(i).getCheckOutDate());
      }
    }
  };
}
