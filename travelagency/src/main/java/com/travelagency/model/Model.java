package com.travelagency.model;

import java.util.ArrayList;

public abstract class Model {
    protected ArrayList<HotelRoom> HotelRooms;
    protected ArrayList<LocalEvent> LocalEvents;
    protected ArrayList<User> Users;
    protected ArrayList<AbstractHotelRoomBooking> hotelRoomBookings;
    protected ArrayList<AbstractLocalEventBooking> localEventBookings;

    public Model() {
        HotelRooms = new ArrayList<>();
        LocalEvents = new ArrayList<>();
        Users = new ArrayList<>();
        hotelRoomBookings = new ArrayList<>();
        localEventBookings = new ArrayList<>();
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
        return hotelRoomBookings.add(booking);
    }

    public boolean removeHotelRoomBooking(AbstractHotelRoomBooking booking) {
        return hotelRoomBookings.remove(booking);
    }

    public boolean addLocalEventBooking(AbstractLocalEventBooking booking) {
        return localEventBookings.add(booking);
    }

    public boolean removeLocalEventBooking(AbstractLocalEventBooking booking) {
        return localEventBookings.remove(booking);
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
        return hotelRoomBookings;
    }

    public ArrayList<AbstractLocalEventBooking> getLocalEventBookings() {
        return localEventBookings;
    }

    public User getUserWithID(String id) {
        User user = null;
        for (int i = 0; i < Users.size(); i++) {
            String userID = Users.get(i).getUserID();
            if (id.equals(userID)) {
                user = Users.get(i);
                break;
            }
        }
        return user;
    }

    public HotelRoom getHotelRoomWithID(String id) {
        HotelRoom room = null;
        for (int i = 0; i < HotelRooms.size(); i++) {
            String roomID = HotelRooms.get(i).getHotelRoomID();
            if (id.equals(roomID)) {
                room = HotelRooms.get(i);
                break;
            }
        }
        return room;
    }

    public LocalEvent getLocalEventWithID(String id) {
        LocalEvent event = null;
        for (int i = 0; i < LocalEvents.size(); i++) {
            String eventID = LocalEvents.get(i).getLocalEventID();
            if (id.equals(eventID)) {
                event = LocalEvents.get(i);
                break;
            }
        }
        return event;
    }

    public AbstractHotelRoomBooking getHotelRoomBookingWithId(String id) {
        AbstractHotelRoomBooking booking = null;
        for (int i = 0; i < hotelRoomBookings.size(); i++) {
            String bookingID = hotelRoomBookings.get(i).getBookingID();
            if (id.equals(bookingID)) {
                booking = hotelRoomBookings.get(i);
                break;
            }
        }
        return booking;
    }

    public AbstractLocalEventBooking getLocalEventBookingWithId(String id) {
        AbstractLocalEventBooking booking = null;
        for (int i = 0; i < localEventBookings.size(); i++) {
            String bookingID = localEventBookings.get(i).getBookingID();
            if (id.equals(bookingID)) {
                booking = localEventBookings.get(i);
                break;
            }
        }
        return booking;
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
