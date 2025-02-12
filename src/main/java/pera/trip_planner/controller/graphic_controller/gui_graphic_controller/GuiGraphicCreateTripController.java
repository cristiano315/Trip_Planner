package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.Trip;
import pera.trip_planner.model.domain.TripDay;
import pera.trip_planner.view.gui.GuiGraphicCreateTripControllerView;

import java.time.LocalDate;

public class GuiGraphicCreateTripController implements GraphicCreateTripController {
    private static final String UNSUPPORTED_MESSAGE = "Not supported yet.";
    private static GuiGraphicCreateTripController instance;
    private GuiGraphicCreateTripControllerView view;
    //params for logic controller
    private String tripName;
    private Country tripCountry;
    private LocalDate tripStartDate;
    private LocalDate tripEndDate;
    private long duration;

    public static GuiGraphicCreateTripController getInstance() {
        if (instance == null) {
            instance = new GuiGraphicCreateTripController();
        }
        return instance;
    }

    @Override
    public void createTrip() {
        view = new GuiGraphicCreateTripControllerView();
        view.start();
    }

    @Override
    public void addDay(Trip trip, int dayNumber){
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public void addActivityInstanceList(TripDay day) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override
    public void done(Trip trip) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void setTripName(String name) {
        this.tripName = name;
    }
}
