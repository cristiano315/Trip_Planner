package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.GraphicLoginController;
import pera.trip_planner.controller.graphic_controller.GraphicShowTripController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicLoginController;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.TextGraphicShowTripController;

public class TextGraphicControllerFactory extends GraphicControllerFactory {
    public GraphicApplicationController getGraphicApplicationController() {
        return new TextGraphicApplicationController();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return new TextGraphicCreateTripController();
    }

    @Override
    public GraphicShowTripController getGraphicShowTripController() {
        return new TextGraphicShowTripController();
    }

    @Override
    public GraphicLoginController getGraphicLoginController() {
        return new TextGraphicLoginController();
    }
}
