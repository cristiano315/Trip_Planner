package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.*;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;

public class GUIGraphicControllerFactory extends GraphicControllerFactory{
    public GraphicApplicationController getGraphicApplicationController() {
        return new GuiGraphicApplicationController();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return new GuiGraphicCreateTripController();
    }

    @Override
    public GraphicShowTripController getGraphicShowTripController() {
        return null;
    }

    @Override
    public GraphicLoginController getGraphicLoginController() {
        return null;
    }

    @Override
    public GraphicModifyTripController getGraphicModifyTripController() {
        return null;
    }
}
