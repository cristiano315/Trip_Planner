package pera.trip_planner.model.DAO;

import pera.trip_planner.model.DAO.file_system.FileSystemDaoFactory;
import pera.trip_planner.model.DAO.inmemory.InMemoryDaoFactory;

public enum PersistenceProvider {
    IN_MEMORY("In Memory", InMemoryDaoFactory.class),
    FILE_SYSTEM("File System", FileSystemDaoFactory.class);

    private final String name;
    private final Class<? extends DaoFactory> daoFactoryClass;

    private PersistenceProvider(String name, Class<? extends DaoFactory> daoFactoryClass) {
        this.name = name;
        this.daoFactoryClass = daoFactoryClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends DaoFactory> getDaoFactoryClass() {
        return daoFactoryClass;
    }
}
