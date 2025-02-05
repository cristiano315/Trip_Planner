package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.model.DAO.DaoFactory;
import pera.trip_planner.model.DAO.GraphicControllerFactory;
import pera.trip_planner.model.DAO.GraphicProvider;
import pera.trip_planner.model.DAO.PersistenceProvider;
import pera.trip_planner.view.ApplicationControllerView;

import java.io.IOException;

public class ApplicationController implements Controller {
    static private boolean demoMode = true; //parameter to decide usage mode

    @Override
    public void start(){
        GraphicController controller;
        int choice;
        try{
            choice = ApplicationControllerView.showMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(GraphicProvider p : GraphicProvider.values()){
            if(p.getId() == choice){
                GraphicControllerFactory.setGraphicProvider(p);
            }
        }
        controller = GraphicControllerFactory.getGraphicControllerFactory().getGraphicApplicationController();
        controller.showMenu();
    }

    static public void setPersistencyMode(String mode) {
        for(PersistenceProvider p : PersistenceProvider.values()){
            if(p.getName() == mode){
                DaoFactory.setPersistenceProvider(p);
            }
        }
    }

}
