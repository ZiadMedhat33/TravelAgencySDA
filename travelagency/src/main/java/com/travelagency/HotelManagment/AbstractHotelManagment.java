package com.travelagency.HotelManagment;

import com.travelagency.model.*;

import java.util.ArrayList;

public abstract class AbstractHotelManagment {
    protected Model model;
    protected SearchHotelRooms search;

    AbstractHotelManagment(Model model, SearchHotelRooms search) {
        this.model = model;
        this.search = search;
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
}
