package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;
import pera.trip_planner.exception.DAOException;
import pera.trip_planner.model.DAO.GetCountriesProcedureDAO;
import pera.trip_planner.model.DAO.GraphicControllerFactory;
import pera.trip_planner.model.domain.CountryList;

public class CreateTripController implements Controller {
    GraphicCreateTripController graphicController;

    @Override
    public void start(){
        graphicController = GraphicControllerFactory.getGraphicControllerFactory().getGraphicCreateTripController();

        CountryList countries;
        try{
            countries = new GetCountriesProcedureDAO().execute();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
        //choose country sos
        System.out.println(countries.toString());

    }


}
