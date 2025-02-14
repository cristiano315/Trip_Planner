package pera.trip_planner.view.text;

import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

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

    public void showCountries(){
        CountryList countries = DaoFactory.getInstance().getCountryDao().countryList();
        System.out.println("Available countries:");
        System.out.println(countries);
    }

    public void showCities(Country country){
        System.out.println("Available cities:");
        System.out.println(country.getCities());
    }

    public void showActivities(City city){
        System.out.println("Available activities:");
        System.out.println(city.getActivities());
    }
}
