package com.travelagency.model;

public abstract class LocalEvent {
    protected String Address;
    protected String City;
    protected String LocalEventID;
    protected String Organizer;
    protected String name;

    public LocalEvent(String address, String city, String localEventID, String organizer, String name) {
        this.Address = address;
        this.City = city;
        this.LocalEventID = localEventID;
        this.Organizer = organizer;
        this.name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCity() {
        return City;
    }

    public void setLocalEventID(String localEventID) {
        LocalEventID = localEventID;
    }

    public String getLocalEventID() {
        return LocalEventID;
    }

    public void setOrganizer(String organizer) {
        Organizer = organizer;
    }

    public String getOrganizer() {
        return Organizer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
