package pera.trip_planner.view;

import pera.trip_planner.model.domain.Role;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextGraphicLoginControllerView {
    public String getString(String message){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                System.out.println(message);
                return br.readLine();
            } catch (IOException e){
                System.out.println("Error reading value, try again");
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
    }

    public int getChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter choice(login/register): ");
            try{
                String choice = br.readLine();
                if(choice.equals("login") || choice.equals("Login")){
                    return 1;
                } else if(choice.equals("register") || choice.equals("Register")){
                    return 2;
                } else{
                    System.out.println("Enter a valid choice");
                }
            } catch (IOException e) {
                System.out.println("Error reading value, try again");
            }
        }
    }

    public Role getRole(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter role (User/City council/Activity manager): ");
            try{
                String choice = br.readLine();
                if(choice.equals("User") || choice.equals("user")){
                    return Role.USER;
                } else if(choice.equals("City council") || choice.equals("city council")){
                    return Role.CITY_COUNCIL;
                } else if(choice.equals("Activity manager") || choice.equals("activity manager")){
                    return Role.ACTIVITY_MANAGER;
                } else {
                    System.out.println("Enter a valid choice");
                }
            } catch (IOException e) {
                System.out.println("Error reading value, try again");
            }
        }
    }
}

