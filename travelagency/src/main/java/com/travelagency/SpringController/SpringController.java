package com.travelagency.SpringController;

import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("travelagency")
public class SpringController {
    Model model = new NormelModel();

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

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }
}
