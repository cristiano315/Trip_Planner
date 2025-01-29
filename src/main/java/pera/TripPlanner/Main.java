package pera.TripPlanner;

import pera.TripPlanner.controller.logic_controller.ApplicationController;

public class Main{

    public static void main(String[] args) {
        ApplicationController applicationController = new ApplicationController();
        applicationController.start();
    }
}