package com.travelagency.LocalEventManagment;

import java.util.ArrayList;
import com.travelagency.model.*;

public abstract class AbstractLocalEventManagment {
    protected Model model;
    protected SearchLocalEvents search;
    protected AddLocalEvent add;

    public AbstractLocalEventManagment(Model model, SearchLocalEvents search, AddLocalEvent add) {
        this.model = model;
        this.search = search;
        this.add = add;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setSearch(SearchLocalEvents search) {
        this.search = search;
    }

    public SearchLocalEvents getSearch() {
        return search;
    }

    public ArrayList<LocalEvent> searchLocalEvents(String text) {
        return search.searchLocalEvents(text, this.model);
    }

    public boolean removeLocalEvent(String id) {
        LocalEvent event = model.getLocalEventWithID(id);
        if (event == null)
            return false;
        return model.removeLocalEvent(event);
    }

    public boolean add(String address, String city, String organizer, String name, Double price,
            int numOfTickets) {
        return add.addLocalEvent(address, city, organizer, name, price, numOfTickets, model);
    }
}
