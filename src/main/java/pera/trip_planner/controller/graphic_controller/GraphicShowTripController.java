package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

public interface GraphicShowTripController {
    void showTripList();

    void showTripInfo(Trip trip);

    void showTripDayInfo(Trip trip, TripDay day);
}
