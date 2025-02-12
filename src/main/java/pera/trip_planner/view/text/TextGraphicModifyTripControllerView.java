package pera.trip_planner.view.text;

import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.City;
import pera.trip_planner.model.domain.Country;
import pera.trip_planner.model.domain.entity_lists.CountryList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public LocalDate getDate(String message){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println(message + " (YYYY MM DD): ");
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
                return LocalDate.of(year, month, day);
            } catch (InputMismatchException e){
                System.out.println("Error reading date, make sure to use the correct format and try again");
                sc = new Scanner(System.in);
            }  catch (DateTimeException e){
                System.out.println("Error reading date, insert a valid date");
                sc = new Scanner(System.in);
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

    public void showActivities(City city){
        System.out.println("Available activities:");
        System.out.println(city.getActivities());
    }

    public LocalDateTime getDateTime(LocalDate date, String message){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println(message + " (HH MM): ");
                int hour = sc.nextInt();
                int minute = sc.nextInt();
                return date.atTime(hour, minute);
            } catch (InputMismatchException e){
                System.out.println("Error reading time, make sure to use the correct format and try again");
                sc = new Scanner(System.in);
            } catch (DateTimeException e){
                System.out.println("Error reading time, insert a valid time");
                sc = new Scanner(System.in);
            }
        }
    }

    public void showCities(Country country){
        System.out.println("Available cities:");
        System.out.println(country.getCities());
    }

    public void showCountries(){
        CountryList countries = DaoFactory.getInstance().getCountryDao().countryList();
        System.out.println("Available countries:");
        System.out.println(countries);
    }
}
