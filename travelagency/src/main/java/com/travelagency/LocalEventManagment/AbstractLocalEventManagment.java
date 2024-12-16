package com.travelagency.LocalEventManagment;

import java.util.ArrayList;
import com.travelagency.model.*;

public abstract class AbstractLocalEventManagment {
    protected Model model;
    protected SearchLocalEvents search;

    public AbstractLocalEventManagment(Model model, SearchLocalEvents search) {
        this.model = model;
        this.search = search;
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
}
