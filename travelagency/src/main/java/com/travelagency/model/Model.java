package com.travelagency.model;

import java.util.ArrayList;

public abstract class Model {
    protected ArrayList<HotelRoom> HotelRooms;
    protected ArrayList<LocalEvent> LocalEvents;
    protected ArrayList<User> Users;
    protected ArrayList<AbstractHotelRoomBooking> bookings;

    public Model() {
        HotelRooms = new ArrayList<>();
        LocalEvents = new ArrayList<>();
        Users = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public boolean addHotelRoom(HotelRoom room) {
        if (HotelRooms.add(room))
            return true;
        return false;
    }

    public boolean removeHotelRoom(HotelRoom room) {
        if (HotelRooms.remove(room))
            return true;
        return false;
    }

    public boolean addLocalEvent(LocalEvent event) {
        if (LocalEvents.add(event))
            return true;
        return false;
    }

    public boolean removeLocalEvent(LocalEvent event) {
        if (LocalEvents.remove(event))
            return true;
        return false;
    }

    public boolean removeUser(User user) {
        if (Users.remove(user))
            return true;
        return false;
    }

    public boolean addHotelRoomUser(User user) {
        if (Users.add(user))
            return true;
        return false;
    }

    public boolean addHotelRoomBooking(AbstractHotelRoomBooking booking) {
        return bookings.add(booking);
    }

    public boolean removeHotelRoomBooking(AbstractHotelRoomBooking booking) {
        return bookings.remove(booking);
    }

    public ArrayList<HotelRoom> getHotelRooms() {
        return HotelRooms;
    }

    public ArrayList<LocalEvent> getLocalEvents() {
        return LocalEvents;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public ArrayList<AbstractHotelRoomBooking> getHotelRoomBookings() {
        return bookings;
    }

    public void takeFromDatabaseHotelRooms(String query) {
        // mimicking that it worte a query to take from database and returned hotel
        // rooms
    }

    public void takeFromHotelProvider() {
        // will return hotel rooms from the hotel provider using API
    }

    public void takeFromDatabaseLocalEvents(String query) {
        // mimicking that it worte a query to take from database and returned local
        // events
    }

    public void takeFromLocalEventProvider() {
        // will return local events from the local event provider using API
    }

    public void takeFromDatabaseHotelBookings() {
        // mimicking that it worte a query to take from database hotel room bookings
    }
}
