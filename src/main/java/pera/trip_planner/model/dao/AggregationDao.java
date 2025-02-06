package pera.trip_planner.model.dao;

public interface AggregationDao<ID, E, A> {
    E load(ID id, A aggregator);
    void store(E entity, A aggregator);
    void delete(ID id, A aggregator);
    boolean exists(ID id, A aggregator);

    //factory method to create new instance
    E create(ID id);
}
