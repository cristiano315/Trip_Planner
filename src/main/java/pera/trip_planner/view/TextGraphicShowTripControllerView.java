package pera.trip_planner.view;

import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.*;
import pera.trip_planner.model.domain.entity_lists.TripList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextGraphicShowTripControllerView {

    public void showAvailableTrips(GeneralUser user){
        TripList list = DaoFactory.getInstance().getTripDao().tripList();
        TripList availableList = new TripList();
        for(Trip trip : list.getList()){
            if (!trip.isRegistered()){
                availableList.addEntity(trip);
            }
        }
        if(user != null){
            for(Trip trip : (ArrayList<Trip>) user.getUserList().getList()){
                availableList.addEntity(trip);
            }
        }
        System.out.println("Showing available trips:");
        System.out.println(availableList);
    }

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

    public void showTripInfo(Trip trip){
        System.out.println("Visualizing trip: " + trip.getName());
        System.out.println("Name: " + trip.getName());
        System.out.println("Country: " + trip.getCountry().countryName());
        System.out.println("Start date: " + trip.getStartDate().toString());
        System.out.println("End date: " + trip.getEndDate().toString());
    }

    public void showDayInfo(TripDay day){
        System.out.println("Visualizing day: " + day.getDate().toString());
        System.out.println("Day: " + day.getDayType().toString());
        System.out.println("City: " + day.getCity().getName());
        System.out.println("Activities:");
    }

    public void showActivityInstance(ActivityInstance activityInstance){
        System.out.println("Activity name: " + activityInstance.getActivity().getName() + ", time: " + activityInstance.getDateTime().toLocalTime().toString());
    }

    public int getChoice(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter choice(next/previous/quit): ");
            try{
                String choice = br.readLine();
                if(choice.equals("next") || choice.equals("Next")){
                    return 1;
                } else if(choice.equals("previous") || choice.equals("Previous")){
                    return -1;
                } else if(choice.equals("quit") || choice.equals("Quit")){
                    return 0;
                } else{
                    System.out.println("Enter a valid choice");
                }
            } catch (IOException e) {
                System.out.println("Error reading value, try again");
            }
        }
    }

    public boolean getBooleanChoice(String message){
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
