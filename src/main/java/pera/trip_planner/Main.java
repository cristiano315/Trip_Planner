package pera.trip_planner;

import pera.trip_planner.controller.logic_controller.ApplicationController;

public class Main{

    public static void main(String[] args) {
        ApplicationController applicationController = new ApplicationController();
        applicationController.start();
    }
}