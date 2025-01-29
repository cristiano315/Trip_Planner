package pera.TripPlanner.controller.logic_controller;

import pera.TripPlanner.controller.graphic_controller.GraphicController;
import pera.TripPlanner.controller.graphic_controller.GuiGraphicCreateTripController;
import pera.TripPlanner.controller.graphic_controller.TextGraphicCreateTripController;
import pera.TripPlanner.exception.DAOException;
import pera.TripPlanner.model.DAO.GetCountriesProcedureDAO;
import pera.TripPlanner.model.domain.CountryList;

public class CreateTripController implements Controller {
    GraphicController graphicController;

    @Override
    public void start(){
        createGraphicController();
        CountryList countries;
        try{
            countries = new GetCountriesProcedureDAO().execute();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
        //choose country sos

    }

    public void createGraphicController() {
        if(ApplicationController.isTextMode()) {
            graphicController = new TextGraphicCreateTripController();
        }
        else {
            graphicController = new GuiGraphicCreateTripController();
        }
    }
}
