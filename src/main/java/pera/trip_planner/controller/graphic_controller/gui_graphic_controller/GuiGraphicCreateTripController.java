package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;

public class GuiGraphicCreateTripController implements GraphicCreateTripController {
    private String unsupportedMessage = "Not supported yet.";

    @Override
    public void createTrip() {
        throw new UnsupportedOperationException(unsupportedMessage);
    }

    @Override
    public void addDay(Trip trip, int dayNumber){
        throw new UnsupportedOperationException(unsupportedMessage);
    }

    @Override
    public void addActivityInstanceList(TripDay day) {
        throw new UnsupportedOperationException(unsupportedMessage);
    }

    @Override
    public void done(Trip trip) {
        throw new UnsupportedOperationException(unsupportedMessage);
    }

}
