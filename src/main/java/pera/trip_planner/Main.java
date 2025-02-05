package pera.trip_planner;

import pera.trip_planner.controller.logic_controller.ApplicationController;
import pera.trip_planner.test.PopolazioneController;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        //test
        System.out.println("1: app, 2 popolazione\n");
        int choice = new Scanner(System.in).nextInt();
        if(choice == 1){
            ApplicationController applicationController = new ApplicationController();
            applicationController.start();
        }
        else{
            PopolazioneController controller = new PopolazioneController();
            controller.populate();
        }
    }
}