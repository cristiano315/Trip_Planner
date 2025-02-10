package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.*;
import pera.trip_planner.controller.graphic_controller.text_graphic_controller.*;

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

    @Override
    public GraphicModifyTripController getGraphicModifyTripController() {
        return new TextGraphicModifyTripController();
    }
}
