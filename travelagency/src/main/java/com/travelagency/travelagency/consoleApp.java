package com.travelagency.travelagency;

import java.util.Scanner;
import java.util.ArrayList;
import com.travelagency.model.*;
import com.travelagency.HotelManagment.*;
import com.travelagency.LocalEventManagment.*;

public class consoleApp {
    public static void main(String[] args) {
        Model model = new NormelModel();
        System.out.println("press 1 to search/view hotel rooms");
        System.out.println("press 2 to search/view local events");
        System.out.println("press -1 to exit");
        Scanner input = new Scanner(System.in);
        while (true) {
            Integer number = input.nextInt();
            switch (number) {
                case 1:
                    SearchHotelRooms search = new SearchHotelRoomsByName();
                    AbstractHotelManagment hotelManagment = new HotelManagment(model, search);
                    input.nextLine();
                    System.out
                            .println(
                                    "enter a name of a hotel room or part of it or enter nothing to get all hotel rooms");
                    String name = input.nextLine();
                    ArrayList<HotelRoom> hotelRooms = hotelManagment.searchHotelRooms(name);
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        HotelRoom room = hotelRooms.get(i);
                        System.out.println("Hotel:" + room.getHotel() + " " + "City:" + room.getCity() + " "
                                + "Address:" + room.getAddress() + " " + "ID:" + room.getHotelRoomID() + " "
                                + "Avalible:" + room.getAvailable() + " " + "Name:" + room.getName());
                    }
                    search = new SearchHotelRoomsByID();
                    hotelManagment.setSearch(search);
                    System.out
                            .println("enter a id of hotel room");
                    String id = input.next();
                    hotelRooms = hotelManagment.searchHotelRooms(id);
                    for (int i = 0; i < hotelRooms.size(); i++) {
                        HotelRoom room = hotelRooms.get(i);
                        System.out.println("Hotel:" + room.getHotel() + " " + "City:" + room.getCity() + " "
                                + "Address:" + room.getAddress() + " " + "ID:" + room.getHotelRoomID() + " "
                                + "Avalible:" + room.getAvailable() + " " + "Name:" + room.getName());
                    }
                    break;
                case 2:
                    SearchLocalEvents searchEvents = new SearchLocalEventsByName();
                    AbstractLocalEventManagment localEventManagment = new LocalEventManagment(model, searchEvents);
                    input.nextLine();
                    System.out
                            .println(
                                    "enter a name of a local event room or part of it or enter nothing to get all local events");
                    String nameEvent = input.nextLine();
                    ArrayList<LocalEvent> localEvents = localEventManagment.searchLocalEvents(nameEvent);
                    for (int i = 0; i < localEvents.size(); i++) {
                        LocalEvent event = localEvents.get(i);
                        System.out.println("Address:" + event.getAddress() + " " + "City:" + event.getCity() + " "
                                + "ID:" + event.getLocalEventID() + " " + "Organizer:" + event.getOrganizer() + " "
                                + "name:" + event.getName());
                    }
                    System.out
                            .println("enter a id of a local event");
                    String idEvent = input.next();
                    searchEvents = new SearchLocalEventsByID();
                    localEventManagment.setSearch(searchEvents);
                    localEvents = localEventManagment.searchLocalEvents(idEvent);
                    for (int i = 0; i < localEvents.size(); i++) {
                        LocalEvent event = localEvents.get(i);
                        System.out.println("Address:" + event.getAddress() + " " + "City:" + event.getCity() + " "
                                + "ID:" + event.getLocalEventID() + " " + "Organizer:" + event.getOrganizer() + " "
                                + "name:" + event.getName());
                    }
                default:
                    break;
            }
            if (number == -1)
                break;
        }
        input.close();
    }
}
