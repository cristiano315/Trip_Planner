package pera.trip_planner.model.dao.inmemory;

import pera.trip_planner.model.dao.DAO;

import java.util.HashMap;
import java.util.Map;


public abstract class InMemoryDao<K, V> implements DAO<K, V> {
    protected Map<K, V> memory = new HashMap<K, V>();

    protected void store(K key, V value) {
        memory.put(key, value);
    }

    @Override
    public V load(K ID){
        return memory.get(ID);
    }

    @Override
    public void store(V entity) {
        K key = getKey(entity);
        store(key, entity);
    }

    @Override
    public void delete(K ID) {
        memory.remove(ID);
    }

    @Override
    public boolean exists(K ID){
        return memory.containsKey(ID);
    }

    /**
     * Returns the key used to identify the entity from its
     * attributes.
     * @param value
     * @return
     */
    protected abstract K getKey(V value);
}
