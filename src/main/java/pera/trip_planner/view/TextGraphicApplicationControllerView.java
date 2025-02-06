package pera.trip_planner.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextGraphicApplicationControllerView {
    private static final String invalidChoiceMessage = "Invalid choice, try again";

    public static int selectUseCaseView() throws IOException{
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            try{
                System.out.println("Choose what you want to do");
                System.out.println("1: Create Trip");
                System.out.println("2: Modify Trip");
                System.out.println("3: View trip");
                System.out.println("4: Add review");
                System.out.println("5: View city/country info");
                System.out.println("6: Modify city's info");
                System.out.println("7: Add activity to a city's list");
                System.out.println("8: Add announcement to activity");
                System.out.println("9: Quit");
                choice = scanner.nextInt();
                if(choice >= 1 && choice <= 9){
                    return choice;
                }
                else{
                    System.out.println(invalidChoiceMessage);
                }
            } catch (InputMismatchException e){
                System.out.println(invalidChoiceMessage);
                scanner = new Scanner(System.in);
            }
        }
    }

    public static int selectModeView() throws IOException{
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            try{
                System.out.println("Select mode:\n1: Demo mode\n2: Full mode");
                choice = scanner.nextInt();
                if(choice == 1 || choice == 2){
                    return choice;
                }
                else{
                    System.out.println(invalidChoiceMessage);
                }
            } catch (InputMismatchException e){
                System.out.println(invalidChoiceMessage);
                scanner = new Scanner(System.in);
            }
        }
    }
}