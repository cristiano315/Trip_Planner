package pera.trip_planner.model.DAO;

import java.lang.reflect.InvocationTargetException;

public abstract class DaoFactory {
    private static DaoFactory instance = null;
    private static PersistenceProvider persistenceProvider = null;

    public static void setPersistenceProvider(PersistenceProvider provider) {
        DaoFactory.persistenceProvider = provider;
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            try{
                instance = persistenceProvider.getDaoFactoryClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                     InvocationTargetException | NoSuchMethodException | SecurityException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }
}
