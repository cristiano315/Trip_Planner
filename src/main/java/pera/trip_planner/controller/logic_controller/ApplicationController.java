package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.controller.graphic_controller.GuiGraphicApplicationController;
import pera.trip_planner.controller.graphic_controller.TextGraphicApplicationController;
import pera.trip_planner.view.ApplicationControllerView;

import java.io.IOException;

public class ApplicationController implements Controller {
    static private boolean demoMode = true; //parameter to decide usage mode
    static private boolean textMode = true; //parameter to decide graphic mode

    @Override
    public void start(){
        GraphicController controller;
        int choice;
        try{
            choice = ApplicationControllerView.showMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (choice == 1) { //soluzione polimorfica per controller grafico
            setTextMode();
            controller = new TextGraphicApplicationController();
        } else {
            setGuiMode();
            controller = new GuiGraphicApplicationController();
        }

        controller.showMenu();
    }

    static public void setDemoMode() {
        demoMode = true;
    }

    static public void setFullMode(){
        demoMode = false;
    }

    static public boolean isDemoMode() {
        return demoMode;
    }

    static public void setTextMode() {
        textMode = true;
    }

    static public void setGuiMode(){
        textMode = false;
    }

    static public boolean isTextMode(){
        return textMode;
    }
}
