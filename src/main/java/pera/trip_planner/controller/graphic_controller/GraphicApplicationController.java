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
                throw new UnsupportedOperationException("Add Review: " + errorMessage);
            case 5:
                throw new UnsupportedOperationException("View city/country info: " + errorMessage);
            case 6:
                throw new UnsupportedOperationException("Modify city's info: " + errorMessage);
            case 7:
                throw new UnsupportedOperationException("Add activity to a city's list: " + errorMessage);
            case 8:
                throw new UnsupportedOperationException("Add announcement to activity: " + errorMessage);
            case 9:
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }
    void runApplication();
}

