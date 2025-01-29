package pera.Trip_Planner.controller.logic_controller;

import pera.Trip_Planner.controller.graphic_controller.GraphicController;
import pera.Trip_Planner.controller.graphic_controller.GuiGraphicCreateTripController;
import pera.Trip_Planner.controller.graphic_controller.TextGraphicCreateTripController;
import pera.Trip_Planner.exception.DAOException;
import pera.Trip_Planner.model.DAO.GetCountriesProcedureDAO;
import pera.Trip_Planner.model.domain.CountryList;

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
