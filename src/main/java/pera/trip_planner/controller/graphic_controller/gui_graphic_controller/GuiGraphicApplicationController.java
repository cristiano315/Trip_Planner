package pera.trip_planner.controller.graphic_controller.gui_graphic_controller;


import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.exception.GuiException;
import pera.trip_planner.view.gui.GuiGraphicApplicationControllerView;

import java.io.IOException;

public class GuiGraphicApplicationController implements GraphicApplicationController {
    private GuiGraphicApplicationControllerView view;
    private static GuiGraphicApplicationController instance;

    public static GuiGraphicApplicationController getInstance() {
        if (instance == null) {
            instance = new GuiGraphicApplicationController();
        }
        return instance;
    }

    @Override
    public void showMenu() {
        view = new GuiGraphicApplicationControllerView();
        view.launchGui();
        try{
            GuiGraphicApplicationControllerView.setRoot("view/mainMenu");
        } catch (IOException e) {
            throw new GuiException("Error loading main menu GUI");
        }
    }

    public void runApplication(){
        try{
            GuiGraphicApplicationControllerView.setRoot("view/mainMenu");
        } catch (IOException e) {
            throw new GuiException("Error loading main menu GUI");
        }
    }

}
