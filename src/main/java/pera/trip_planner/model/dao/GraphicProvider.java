package pera.trip_planner.model.dao;

public enum GraphicProvider {
    TEXT(1, TextGraphicControllerFactory.class),
    GUI(2, GUIGraphicControllerFactory.class);

    private final int id;
    private final Class<? extends GraphicControllerFactory> GraphicControllerFactoryClass;

    private GraphicProvider(int id, Class<? extends GraphicControllerFactory> GraphicControllerFactoryClass) {
        this.id = id;
        this.GraphicControllerFactoryClass = GraphicControllerFactoryClass;
    }

    public int getId() {
        return id;
    }

    public Class<? extends GraphicControllerFactory> getGraphicControllerFactoryClass() {
        return GraphicControllerFactoryClass;
    }

}
