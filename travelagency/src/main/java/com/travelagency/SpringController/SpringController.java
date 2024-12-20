package com.travelagency.SpringController;

import java.time.LocalDate;
import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.Booking.HotelRoomBookingCtrl;
import com.travelagency.Booking.LocalEventBookingCtrl;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;
import com.travelagency.NotificationModule.*;
import com.travelagency.UserManagement.UserManagementCtrl;
import com.travelagency.UserManagement.matchingValidation;
import com.travelagency.IDsearcher.*;
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
    IDsearcher searchID = new IDsearcher(model);
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

    @PostMapping("login/{username}/{password}")
    public User login(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.login(username, password);
    }

    @PostMapping("logout/{id}")
    public User logout(@PathVariable("id") String id) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.logout(id);
    }

    @PostMapping("updatepassword/{id}/{newpass}")
    public User updatePassword(@PathVariable("id") String id, @PathVariable("newpass") String newpass) {
        UserManagementCtrl ctrl = new UserManagementCtrl(new matchingValidation(),
                model, manager);
        return ctrl.updatePassword(id, newpass);
    }

    @PostMapping("addHotelRoomBooking/{hotelRoomID}/{checkInDate}/{checkOutDate}/{userID}")
    public AbstractHotelRoomBooking addRoomBooking(@PathVariable("hotelRoomID") String hotelRoomID,
            @PathVariable("checkInDate") String checkInDate, @PathVariable("checkOutDate") String checkoutDate,
            @PathVariable("userID") String userID) {
        HotelRoom hotelRoom = searchID.getHotelRoomWithID(hotelRoomID);
        if (hotelRoom == null)
            return null;
        HotelRoomBookingCtrl ctrl = new HotelRoomBookingCtrl(model, manager);
        LocalDate firstDate = LocalDate.parse(checkInDate);
        LocalDate secondDate = LocalDate.parse(checkoutDate);
        AbstractHotelRoomBooking booking = ctrl.createBooking(hotelRoom, firstDate, secondDate,
                userID);
        return booking;
    }

    @PostMapping("cancelHotelRoomBooking/{id}")
    public boolean cancelHotelRoomBooking(@PathVariable("id") String id) {
        HotelRoomBookingCtrl ctrl = new HotelRoomBookingCtrl(model, manager);
        return ctrl.cancelBooking(id);
    }

    @PostMapping("addLocalEventBooking/{userid}/{localEventid}")
    public AbstractLocalEventBooking addLocalEventBooking(@PathVariable("userid") String userid,
            @PathVariable("localEventid") String localEventid) {
        LocalEventBookingCtrl ctrl = new LocalEventBookingCtrl(model, manager);
        LocalEvent event = searchID.getLocalEventWithID(localEventid);
        if (event == null)
            return null;
        AbstractLocalEventBooking booking = ctrl.createBooking(userid, event);
        return booking;
    }

    @PostMapping("cancelLocalEventBooking/{id}")
    public boolean cancelLocalEventBooking(@PathVariable("id") String id) {
        LocalEventBookingCtrl ctrl = new LocalEventBookingCtrl(model, manager);
        return ctrl.removeBooking(id);
    }

}
