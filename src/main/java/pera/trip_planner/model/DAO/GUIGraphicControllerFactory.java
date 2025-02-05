package pera.trip_planner.model.DAO;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.GuiGraphicCreateTripController;

public class GUIGraphicControllerFactory extends GraphicControllerFactory{
    public GraphicController getGraphicApplicationController() {
        return new GuiGraphicApplicationController();
    }

    public GraphicCreateTripController getGraphicCreateTripController() {
        return new GuiGraphicCreateTripController();
    }
}
