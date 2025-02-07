package pera.trip_planner.controller.logic_controller;

import pera.trip_planner.controller.graphic_controller.GraphicApplicationController;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.GraphicControllerFactory;
import pera.trip_planner.model.dao.GraphicProvider;
import pera.trip_planner.model.dao.PersistenceProvider;
import pera.trip_planner.view.ApplicationControllerView;

public class ApplicationController implements Controller {

    @Override
    public void start(){
        GraphicApplicationController controller;
        int choice;
        choice = ApplicationControllerView.showMenu();

        for(GraphicProvider p : GraphicProvider.values()){
            if(p.getId() == choice){
                GraphicControllerFactory.setGraphicProvider(p);
            }
        }
        controller = GraphicControllerFactory.getGraphicControllerFactory().getGraphicApplicationController();
        controller.showMenu();
    }

    public static void setPersistencyMode(String mode) {
        for(PersistenceProvider p : PersistenceProvider.values()){
            if(p.getName().equals(mode)){
                DaoFactory.setPersistenceProvider(p);
            }
        }
    }

}
