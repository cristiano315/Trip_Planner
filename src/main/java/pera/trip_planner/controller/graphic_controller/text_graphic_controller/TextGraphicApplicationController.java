package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.logic_controller.*;
import pera.trip_planner.view.text.TextGraphicApplicationControllerView;

public class TextGraphicApplicationController implements GraphicApplicationController {

    @Override
    public void showMenu(){
        int choice;
        choice = TextGraphicApplicationControllerView.selectModeView();
        if(choice == 1){
            ApplicationController.setPersistencyMode("In Memory");
        }
        else if(choice == 2){
            ApplicationController.setPersistencyMode("File System");
        }
        runApplication();
    }

    public void runApplication() {
        int choice;
        while(true){ //application loop
            choice = TextGraphicApplicationControllerView.selectUseCaseView();
            selectCase(choice);
            if(choice == 9){
                System.exit(0);
                break;
            }
        }
    }
}

