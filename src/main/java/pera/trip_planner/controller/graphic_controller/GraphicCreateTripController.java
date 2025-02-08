package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

public interface GraphicCreateTripController {
    void createTrip();
    void addDay(Trip trip, int dayNumber);
    void addActivityInstanceList(TripDay day);
    void done(Trip trip);
}
