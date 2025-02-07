package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.model.dao.CountryDao;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.domain.entity_lists.CountryList;

public class CreateTripController implements Controller {
    GraphicCreateTripController graphicController;

    @Override
    public void start(){
        graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();
        //step: creazione nuovo trip, lista paesi(controller grafico), paese scelto, aggiunta al trip, si ripassa al controller grafico etc
        CountryList countries;
        DaoFactory factory = DaoFactory.getInstance();
        CountryDao countryDao = factory.getCountryDao();
        countries = countryDao.countryList();
        countries.sort();
        //choose country sos
        System.out.println(countries.toString());
        System.out.println(countryDao.load("Italy").getCities().toString());
    }


}
