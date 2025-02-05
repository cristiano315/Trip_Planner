package pera.trip_planner.model.DAO;

import pera.trip_planner.controller.graphic_controller.GraphicController;
import pera.trip_planner.controller.graphic_controller.GraphicCreateTripController;

import java.lang.reflect.InvocationTargetException;

public abstract class GraphicControllerFactory {
    private static GraphicControllerFactory instance = null;
    private static GraphicProvider graphicProvider = null;

    public static void setGraphicProvider(GraphicProvider provider){
        graphicProvider = provider;
    }

    public static GraphicControllerFactory getGraphicControllerFactory(){
        if(instance == null){
            try{
                instance = graphicProvider.getGraphicControllerFactoryClass().getConstructor().newInstance();
            } catch(InstantiationException | IllegalAccessException | IllegalArgumentException |
                    InvocationTargetException | NoSuchMethodException | SecurityException e){
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

    public abstract GraphicController getGraphicApplicationController();
    public abstract GraphicCreateTripController getGraphicCreateTripController();
}
