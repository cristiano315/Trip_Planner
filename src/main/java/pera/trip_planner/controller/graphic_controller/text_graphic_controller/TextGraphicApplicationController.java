package pera.trip_planner.controller.graphic_controller.text_graphic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.controller.logic_controller.*;
import pera.trip_planner.model.domain.GeneralUser;
import pera.trip_planner.view.TextGraphicApplicationControllerView;

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
        // aggiungere else con eccezione in realtà no, handled dalla view
        runApplication();
    }

    public void runApplication() {
        int choice;
        Controller controller;
        while(true){ //application loop
            choice = TextGraphicApplicationControllerView.selectUseCaseView();
            switch (choice) {
                case 1:
                    controller = CreateTripController.getInstance();
                    controller.start();
                    break;
                case 2:
                    System.out.println("Modify Trip");
                    throw new RuntimeException("Not yet implemented");
                    //break;
                case 3:
                    controller = ShowTripController.getInstance();
                    controller.start();
                    break;
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
                    LoginController lcontroller = LoginController.getInstance();
                    GeneralUser user = lcontroller.retrieveUser();
                    System.out.println("Login user: " + user.getUsername());
                    //System.out.println("Add activity to a city's list");
                    //throw new RuntimeException("Not yet implemented");
                    break;
                case 8:
                    controller = LoginController.getInstance();
                    controller.start();
                    //System.out.println("Add announcement to activity");
                    //throw new RuntimeException("Not yet implemented");
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    throw new RuntimeException("Invalid choice");
            }
        }
    }

}

