package pera.trip_planner.view.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TextGraphicModifyTripControllerView extends TextGraphicShowTripControllerView {
    private String invalidChoiceError = "Enter a valid choice";
    private String errorMessage = "Error reading value, try again";

    public int getTripInfoChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter the value that you want to modify(name/country/dates/days): ");
            try{
                String choice = br.readLine();
                if(choice.equals("name") || choice.equals("Name")){
                    return 1;
                } else if(choice.equals("country") || choice.equals("Country")){
                    return 2;
                } else if(choice.equals("dates") || choice.equals("Dates")){
                    return 3;
                } else if(choice.equals("days") || choice.equals("Days")){
                    return 4;
                } else{
                    System.out.println(invalidChoiceError);
                }
            } catch (IOException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public int getDayChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter choice(next/previous/modify/quit): ");
            try{
                String choice = br.readLine();
                if(choice.equals("next") || choice.equals("Next")){
                    return 1;
                } else if(choice.equals("previous") || choice.equals("Previous")){
                    return -1;
                } else if(choice.equals("quit") || choice.equals("Quit")){
                    return 0;
                } else if(choice.equals("modify") || choice.equals("Modify")){
                    return 2;
                } else{
                    System.out.println(invalidChoiceError);
                }
            } catch (IOException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public int getDayModificationChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter the value that you want to modify(city/activities): ");
            try{
                String choice = br.readLine();
                if(choice.equals("city") || choice.equals("City")){
                    return 1;
                } else if(choice.equals("activities") || choice.equals("Activities")){
                    return 2;
                } else{
                    System.out.println(invalidChoiceError);
                }
            } catch (IOException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public int getActivitiesChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter choice(delete/add/back): ");
            try{
                String choice = br.readLine();
                if(choice.equals("delete") || choice.equals("Delete")){
                    return 1;
                } else if(choice.equals("add") || choice.equals("Add")){
                    return 2;
                } else if(choice.equals("back") || choice.equals("Back")){
                    return 0;
                } else{
                    System.out.println(invalidChoiceError);
                }
            } catch (IOException e) {
                System.out.println(errorMessage);
            }
        }
    }

}
