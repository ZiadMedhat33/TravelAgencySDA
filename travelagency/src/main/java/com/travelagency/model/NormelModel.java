package com.travelagency.model;

public class NormelModel extends Model {
    public NormelModel() {
        super();
        takeFromDatabaseHotelRooms(null);
        takeFromHotelProvider();
        takeFromDatabaseLocalEvents(null);
        takeFromLocalEventProvider();
    }

    @Override
    public void takeFromDatabaseHotelRooms(String query) {
        // mimicking that it worte a query to take from database and returned hotel
        // rooms
        HotelRooms.add(new StandardRoom("Grand Hotel", "New York", "123 Main St", "HR001", true, "Suite"));
        HotelRooms.add(new StandardRoom("Beachside Resort", "Miami", "456 Ocean Dr", "HR002", false, "Deluxe"));
        HotelRooms.add(new StandardRoom("Mountain Retreat", "Denver", "789 Alpine Rd", "HR003", true, "Standard"));
        HotelRooms.add(new StandardRoom("City Inn", "Chicago", "1010 Lakeshore Blvd", "HR004", true, "Economy"));
        HotelRooms.add(new StandardRoom("Royal Palace", "Los Angeles", "1111 Sunset Blvd", "HR005", false,
                "Presidential Suite"));
        HotelRooms.add(new StandardRoom("Urban Stay", "San Francisco", "1212 Market St", "HR006", true, "Family Room"));
        HotelRooms.add(new StandardRoom("Luxury Suites", "Las Vegas", "1313 Strip Ave", "HR007", true, "Penthouse"));
        HotelRooms.add(new StandardRoom("Cozy Corner", "Seattle", "1414 Pine St", "HR008", false, "Single"));
        HotelRooms.add(new StandardRoom("Downtown Lodge", "Boston", "1515 Beacon St", "HR009", true, "Double"));
        HotelRooms.add(new StandardRoom("Country Escape", "Austin", "1616 Ranch Rd", "HR010", true, "Cottage"));

    }

    @Override
    public void takeFromHotelProvider() {
        // will return hotel rooms from the hotel provider using API
        HotelRooms.add(new StandardRoom("Paradise Hotel", "Orlando", "221 Magic St", "HR011", true, "Suite"));
        HotelRooms.add(new StandardRoom("Skyline Inn", "Dallas", "345 Elm Ave", "HR012", false, "Deluxe"));
        HotelRooms.add(new StandardRoom("Harbor Stay", "San Diego", "567 Shoreline Blvd", "HR013", true, "Standard"));
        HotelRooms.add(new StandardRoom("Metro Lodge", "Portland", "789 Bridge Rd", "HR014", true, "Economy"));
        HotelRooms.add(
                new StandardRoom("Imperial Suites", "Houston", "101 Tower Dr", "HR015", false, "Presidential Suite"));
        HotelRooms.add(new StandardRoom("Seaside Escape", "Honolulu", "111 Beach Ln", "HR016", true, "Family Room"));
        HotelRooms.add(new StandardRoom("Summit View", "Salt Lake City", "131 Peak Rd", "HR017", true, "Penthouse"));
        HotelRooms.add(new StandardRoom("Comfort Inn", "Phoenix", "141 Desert Dr", "HR018", false, "Single"));
        HotelRooms.add(new StandardRoom("Urban Retreat", "Atlanta", "151 Peach St", "HR019", true, "Double"));
        HotelRooms.add(new StandardRoom("Rustic Cabin", "Nashville", "161 Forest Ln", "HR020", true, "Cottage"));

    }

    @Override
    public void takeFromDatabaseLocalEvents(String query) {
        // mimicking that it worte a query to take from database and returned local
        // events
        LocalEvents.add(new NormalLocalEvent("123 Main St", "Springfield", "E001", "John Doe", "Tech Conference"));
        LocalEvents.add(new NormalLocalEvent("456 Oak Ave", "Shelbyville", "E002", "Jane Smith", "Food Festival"));
        LocalEvents.add(new NormalLocalEvent("789 Pine Rd", "Capital City", "E003", "Alice Johnson", "Music Concert"));
    }

    public void takeFromLocalEventProvider() {
        // will return local events from the local event provider using API
        LocalEvents.add(new NormalLocalEvent("111 Elm St", "Greenville", "E004", "Bob Brown", "Art Exhibition"));
        LocalEvents.add(new NormalLocalEvent("222 Maple Ave", "Riverside", "E005", "Karen White", "Book Fair"));
        LocalEvents.add(new NormalLocalEvent("333 Cedar Rd", "Hill Valley", "E006", "Tom Clark", "Charity Run"));
    }
}
