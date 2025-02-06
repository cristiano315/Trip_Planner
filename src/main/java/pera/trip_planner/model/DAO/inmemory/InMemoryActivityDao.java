package pera.trip_planner.model.DAO.inmemory;

import pera.trip_planner.model.DAO.ActivityDao;
import pera.trip_planner.model.domain.Activity;
import pera.trip_planner.model.domain.City;

public class InMemoryActivityDao  implements ActivityDao {
    private static InMemoryActivityDao instance;

    private InMemoryActivityDao() {}

    public static InMemoryActivityDao getInstance() {
        if (instance == null) {
            instance = new InMemoryActivityDao();
        }
        return instance;
    }

    @Override
    public Activity load(String name, String city, String country) {
        return InMemoryCityDao.getInstance().load(city, country).getActivities().getEntityByName(name);
    }

    @Override
    public void store(Activity activity, String city, String country) {
        InMemoryCityDao.getInstance().load(city, country).addActivity(activity);
    }

    @Override
    public void delete(String activity, String city, String country) {
        InMemoryCityDao.getInstance().load(city, country).removeActivity(activity);
    }

    @Override
    public boolean exists(String activity, String city, String country) {
        return InMemoryCityDao.getInstance().load(city, country).getActivities().contains(activity);
    }
}
