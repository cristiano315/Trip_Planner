package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.controller.graphic_controller.GuiGraphicCreateTripController;
import pera.trip_planner.controller.graphic_controller.TextGraphicCreateTripController;
import pera.trip_planner.exception.DAOException;
import pera.trip_planner.model.DAO.GetCountriesProcedureDAO;
import pera.trip_planner.model.domain.CountryList;

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
