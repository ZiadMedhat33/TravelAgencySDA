package com.travelagency.IDsearcher;

import com.travelagency.model.*;

public class IDsearcher {
    private Model model;

    public IDsearcher(Model model) {
        this.model = model;
    }

    public User getUserWithID(String id) {
        return model.getUserWithID(id);
    }

    public HotelRoom getHotelRoomWithID(String id) {
        return model.getHotelRoomWithID(id);
    }

    public LocalEvent getLocalEventWithID(String id) {
        return model.getLocalEventWithID(id);
    }

    public AbstractHotelRoomBooking getHotelRoomBookingWithId(String id) {
        return model.getHotelRoomBookingWithId(id);
    }

    public AbstractLocalEventBooking getLocalEventBookingWithId(String id) {
        return model.getLocalEventBookingWithId(id);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

}
