package pera.trip_planner.model.DAO;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.TextGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.TextGraphicCreateTripController;

public class TextGraphicControllerFactory extends GraphicControllerFactory {
    public GraphicController getGraphicApplicationController() {
        return new TextGraphicApplicationController();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return new TextGraphicCreateTripController();
    }
}
