package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.model.domain.GeneralUser;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

public interface GraphicModifyTripController {
    void login();

    void showTripList(GeneralUser user);

    void modifyTripInfo(Trip trip);

    void done(Trip trip);

    void selectTripDay(Trip trip, TripDay day);

    void modifyTripDay(Trip trip, TripDay day);
}
