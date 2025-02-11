package pera.trip_planner.model.dao;

public interface DAO<I, E> {
    E load(I id);
    void store(E entity);
    void delete(I id);
    boolean exists(I id);

    //factory method to create new instance
    E create(I id);
}
