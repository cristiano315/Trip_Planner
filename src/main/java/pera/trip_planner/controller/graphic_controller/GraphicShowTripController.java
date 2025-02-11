package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.User;

public interface GraphicShowTripController {
    void showTripList(User user);

    void showTripInfo(Trip trip);

    void showTripDayInfo(Trip trip, TripDay day);

    void login();
}
