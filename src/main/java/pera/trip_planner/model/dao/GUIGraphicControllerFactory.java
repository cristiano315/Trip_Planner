package pera.trip_planner.model.dao;

import pera.trip_planner.controller.graphic_controller.*;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicLoginController;
import pera.trip_planner.controller.graphic_controller.gui_graphic_controller.GuiGraphicShowTripController;

public class GUIGraphicControllerFactory extends GraphicControllerFactory{
    public GraphicApplicationController getGraphicApplicationController() {
        return GuiGraphicApplicationController.getInstance();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return GuiGraphicCreateTripController.getInstance();
    }

    @Override
    public GraphicShowTripController getGraphicShowTripController() {
        return GuiGraphicShowTripController.getInstance();
    }

    @Override
    public GraphicLoginController getGraphicLoginController() {
        return GuiGraphicLoginController.getInstance();
    }

    @Override
    public GraphicModifyTripController getGraphicModifyTripController() {
        return null;
    }
}
