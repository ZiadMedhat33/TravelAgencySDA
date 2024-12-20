package com.travelagency.SpringController;

import java.time.LocalDate;
import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.Booking.HotelRoomBookingCtrl;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;
import com.travelagency.NotificationModule.*;
import com.travelagency.UserManagement.UserManagementCtrl;
import com.travelagency.UserManagement.matchingValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("travelagency")
public class SpringController {
    Model model = new NormalModel();
    Notifications notifications = new Notifications();
    NotificationManager manager = new NotificationManager(notifications, model);

    @GetMapping("searchHotelRoomWithName/{name}")
    public ArrayList<HotelRoom> searchHotelRooms(@PathVariable("name") String name) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName());
        return hotelManagment.searchHotelRooms(name);
    }

    @GetMapping("searchHotelRoomWithName")
    public ArrayList<HotelRoom> viewHotelRooms() {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByName());
        return hotelManagment.searchHotelRooms("");
    }

    @GetMapping("searchHotelRoomWithID/{id}")
    public ArrayList<HotelRoom> searchHotelRoomsWithID(@PathVariable("id") String id) {
        AbstractHotelManagment hotelManagment = new HotelManagment(model, new SearchHotelRoomsByID());
        return hotelManagment.searchHotelRooms(id);
    }

    @GetMapping("searchLocalEventWithName/{name}")
    public ArrayList<LocalEvent> searchLocalEvent(@PathVariable("name") String name) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName());
        return localEventManagment.searchLocalEvents(name);
    }

    @GetMapping("searchLocalEventWithName")
    public ArrayList<LocalEvent> viewLocalEvent() {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByName());
        return localEventManagment.searchLocalEvents("");
    }

    @GetMapping("searchLocalEventWithID/{id}")
    public ArrayList<LocalEvent> searchLocalEventWithID(@PathVariable("id") String id) {
        AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, new SearchLocalEventsByID());
        return localEventManagment.searchLocalEvents(id);
    }

    @PostMapping("createAccount/{username}/{password}/{mail}/{phonenumber}")
    public User createAccount(@PathVariable("username") String userName, @PathVariable("password") String password,
            @PathVariable("mail") String mail, @PathVariable("phonenumber") String phoneNumber) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.Register(userName, password, mail, phoneNumber);
    }

    @PostMapping("addHotelRoomBooking/{hotelRoomID}/{checkInDate}/{checkOutDate}/{userID}")
    public AbstractHotelRoomBooking addRoomBooking(@PathVariable("hotelRoomID") String hotelRoomID,
            @PathVariable("checkInDate") String checkInDate, @PathVariable("checkOutDate") String checkoutate,
            @PathVariable("userID") String userID) {
        HotelRoom hotelRoom = model.getHotelRoomWithID(hotelRoomID);
        HotelRoomBookingCtrl ctrl = new HotelRoomBookingCtrl(model, manager);
        LocalDate firstDate = LocalDate.parse(checkInDate);
        LocalDate secondDate = LocalDate.parse(checkInDate);
        AbstractHotelRoomBooking booking = ctrl.createBooking(hotelRoom, firstDate, secondDate,
                userID);
        return booking;
    }
}
