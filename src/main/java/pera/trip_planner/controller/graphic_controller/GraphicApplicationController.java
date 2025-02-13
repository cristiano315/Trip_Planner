package pera.trip_planner.controller.graphic_controller;

import pera.trip_planner.controller.logic_controller.*;

public interface GraphicApplicationController {
    void showMenu();
    default void selectCase(int choice){
    String errorMessage = "Not yet implemented";
    Controller controller;
        switch (choice) {
            case 1:
                controller = CreateTripController.getInstance();
                controller.start();
                break;
            case 2:
                controller = ModifyTripController.getInstance();
                controller.start();
                break;
            case 3:
                controller = ShowTripController.getInstance();
                controller.start();
                break;
            case 4:
                controller = LoginController.getInstance();
                controller.start();
//                System.out.println("Add Review");
//                throw new RuntimeException(errorMessage);
                //break;
            case 5:
                System.out.println("View city/country info");
                throw new RuntimeException(errorMessage);
                //break;
            case 6:
                System.out.println("Modify city's info");
                throw new RuntimeException(errorMessage);
                //break;
            case 7:
                System.out.println("Add activity to a city's list");
                throw new RuntimeException(errorMessage);
            case 8:
                System.out.println("Add announcement to activity");
                throw new RuntimeException(errorMessage);
            case 9:
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
    void runApplication();
}

