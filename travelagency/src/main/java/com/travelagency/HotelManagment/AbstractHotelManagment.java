package com.travelagency.HotelManagment;

import com.travelagency.model.*;

import java.util.ArrayList;

public abstract class AbstractHotelManagment {
    protected Model model;
    protected SearchHotelRooms search;
    protected AddHotelRoom add;

    public AbstractHotelManagment(Model model, SearchHotelRooms search, AddHotelRoom add) {
        this.model = model;
        this.search = search;
        this.add = add;
    }

    public void setAdd(AddHotelRoom add) {
        this.add = add;
    }

    public AddHotelRoom getAdd() {
        return add;
    }

    public ArrayList<HotelRoom> searchHotelRooms(String text) {
        return search.searchHotelRooms(text, this.model);
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setSearch(SearchHotelRooms search) {
        this.search = search;
    }

    public SearchHotelRooms getSearch() {
        return search;
    }

    public boolean removeHotelRoom(String id) {
        HotelRoom room = model.getHotelRoomWithID(id);
        if (room == null)
            return false;
        return model.removeHotelRoom(room);
    }

    public boolean AddHotelRoom(String Hotel, String City, String Address, boolean Available, String name,
            Double price) {
        return add.addHotelRoom(Hotel, City, Address, Available, name, price, this.model);
    }
}
