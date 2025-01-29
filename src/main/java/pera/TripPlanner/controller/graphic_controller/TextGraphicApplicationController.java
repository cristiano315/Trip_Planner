package pera.TripPlanner.controller.graphic_controller;

import pera.TripPlanner.controller.logic_controller.ApplicationController;
import pera.TripPlanner.controller.logic_controller.Controller;
import pera.TripPlanner.controller.logic_controller.CreateTripController;
import pera.TripPlanner.view.TextGraphicApplicationControllerView;

import java.io.IOException;

public class TextGraphicApplicationController implements GraphicController {

    @Override
    public void showMenu(){
        int choice;
        try{
            choice = TextGraphicApplicationControllerView.selectModeView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(choice == 1){
            ApplicationController.setDemoMode();
        }
        else if(choice == 2){
            ApplicationController.setFullMode();
        }
        // aggiungere else con eccezione
        runApplication();
    }

    public void runApplication() {
        int choice;
        while(true){ //application loop
            try{
                choice = TextGraphicApplicationControllerView.selectUseCaseView();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

