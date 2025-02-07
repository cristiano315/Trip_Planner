package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicCreateTripController;

public class TextGraphicControllerFactory extends GraphicControllerFactory {
    public GraphicApplicationController getGraphicApplicationController() {
        return new TextGraphicApplicationController();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return new TextGraphicCreateTripController();
    }
}
