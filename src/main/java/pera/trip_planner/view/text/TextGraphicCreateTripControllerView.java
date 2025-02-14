package pera.trip_planner.view.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextGraphicCreateTripControllerView extends GenericTextGraphicView {

    public boolean getChoice(String message){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.println(message + " (y/n): ");
                String choice = br.readLine();
                if(choice.equals("y") || choice.equals("Y")){
                    return true;
                } else if(choice.equals("n") || choice.equals("N")){
                    return false;
                } else {
                    System.out.println("Insert a valid choice");
                }
            } catch (IOException e){
                System.out.println("Error reading value, try again");
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
    }

}
