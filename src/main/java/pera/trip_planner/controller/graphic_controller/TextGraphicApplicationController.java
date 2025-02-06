package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.controller.logic_controller.ApplicationController;
import pera.trip_planner.controller.logic_controller.Controller;
import pera.trip_planner.controller.logic_controller.CreateTripController;
import pera.trip_planner.view.TextGraphicApplicationControllerView;

import java.io.IOException;

public class TextGraphicApplicationController implements GraphicController {

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
        // aggiungere else con eccezione in realtà no, handled dalla view
        runApplication();
    }

    public void runApplication() {
        int choice;
        while(true){ //application loop
            choice = TextGraphicApplicationControllerView.selectUseCaseView();
            switch (choice) {
                case 1:
                    Controller controller = new CreateTripController();
                    controller.start();
                    break;
                case 2:
                    System.out.println("Modify Trip");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 3:
                    System.out.println("View Trip");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 4:
                    System.out.println("Add Review");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 5:
                    System.out.println("View city/country info");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 6:
                    System.out.println("Modify city's info");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 7:
                    System.out.println("Add activity to a city's list");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 8:
                    System.out.println("Add announcement to activity");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 9:
                    System.exit(0);
                default:
                    throw new RuntimeException("Invalid choice");
            }
        }
    }

}

