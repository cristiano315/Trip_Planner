package pera.TripPlanner.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationControllerView {
    public static int showMenu() throws IOException{
        Scanner scanner = new Scanner(System.in);
        int choice;
        while(true){
            try{
                System.out.println("Application started, choose style:\n1 - Text\n2 - Gui");
                choice = scanner.nextInt();
                if(choice == 1 || choice == 2){
                    return choice;
                }
                else{
                    System.out.println("Invalid choice, enter 1 or 2: ");
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid choice, enter 1 or 2: ");
                scanner = new Scanner(System.in);
            }
        }
    }
}

