package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

public interface GraphicCreateTripController {
    void createTrip();
    void addActivityInstanceList(Trip trip, TripDay day);
    void done(Trip trip);
    void addDays(Trip trip, long duration);
}
