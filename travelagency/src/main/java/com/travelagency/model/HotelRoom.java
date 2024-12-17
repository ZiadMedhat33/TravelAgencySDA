package com.travelagency.model;

public abstract class HotelRoom {
    protected String Hotel;
    protected String City;
    protected String Address;
    protected String HotelRoomID;
    protected boolean Available;
    protected String name;
    protected Double price;

    public HotelRoom(String Hotel, String City, String Address, String HotelRoomID, boolean Available, String name,
            Double price) {
        this.Hotel = Hotel;
        this.City = City;
        this.Address = Address;
        this.HotelRoomID = HotelRoomID;
        this.Available = Available;
        this.name = name;
        this.price = price;
    }

    public String getHotel() {
        return Hotel;
    }

    public void setHotel(String hotel) {
        Hotel = hotel;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCity() {
        return City;
    }

    public void setHotelRoomID(String hotelRoomID) {
        HotelRoomID = hotelRoomID;
    }

    public String getHotelRoomID() {
        return HotelRoomID;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public boolean getAvailable() {
        return Available;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
