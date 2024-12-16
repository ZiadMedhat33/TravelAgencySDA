package com.travelagency.model;

import java.util.ArrayList;

public abstract class Model {
    protected ArrayList<HotelRoom> HotelRooms;
    protected ArrayList<LocalEvent> LocalEvents;

    public Model() {
        HotelRooms = new ArrayList<>();
        LocalEvents = new ArrayList<>();
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

    public ArrayList<HotelRoom> getHotelRooms() {
        return HotelRooms;
    }

    public ArrayList<LocalEvent> getLocalEvents() {
        return LocalEvents;
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
}
