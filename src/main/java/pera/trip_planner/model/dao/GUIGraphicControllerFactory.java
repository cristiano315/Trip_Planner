package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.*;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;

public class GUIGraphicControllerFactory extends GraphicControllerFactory{
    public GraphicApplicationController getGraphicApplicationController() {
        return GuiGraphicApplicationController.getInstance();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return GuiGraphicCreateTripController.getInstance();
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
