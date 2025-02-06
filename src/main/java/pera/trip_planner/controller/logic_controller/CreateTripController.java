package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.DAO.GraphicControllerFactory;
import pera.trip_planner.model.DAO.inmemory.InMemoryCountryDao;
import pera.trip_planner.model.domain.CountryList;

public class CreateTripController implements Controller {
    GraphicCreateTripController graphicController;

    @Override
    public void start(){
        graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();

        CountryList countries;
        InMemoryCountryDao countryDao = InMemoryCountryDao.getInstance();
        countries = countryDao.countryList();
        countries.sort();
        //choose country sos
        System.out.println(countries.toString());
        System.out.println(countryDao.load("Italy").getCities().toString());
    }


}
