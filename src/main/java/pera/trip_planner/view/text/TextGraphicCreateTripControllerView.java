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

public class TextGraphicCreateTripControllerView {

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
