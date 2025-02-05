package pera.trip_planner.model.DAO;

public interface DAO<ID, E> {
    E load(ID id);
    void store(E entity);
    void delete(ID id);
    boolean exists(ID id);

    //factory method to create new instance
    E create(ID id);
}
