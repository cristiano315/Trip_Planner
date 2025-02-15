package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.model.domain.User;

public interface GraphicModifyTripController {
    void login();

    void showTripList(User user);

    void modifyTripInfo(Trip trip);

    void done(Trip trip);

    void selectTripDay(Trip trip, TripDay day);
}
