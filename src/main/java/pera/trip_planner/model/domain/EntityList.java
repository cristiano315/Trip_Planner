package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class EntityList<E> implements Serializable {
    private final ArrayList<E> entityList = new ArrayList<>();

    protected abstract String getName(E entity);

    public void addEntity(E entity) {
        entityList.add(entity);
    }

    public void removeEntity(String name) {
        for(E entity : entityList){
            if(getName(entity).equals(name)){
                entityList.remove(entity);
            }
        }
    }

    public ArrayList<E> getList() {
        return entityList;
    }

    public void sort(){
        entityList.sort(new Comparator<E>() {
            public int compare(E o1, E o2) {
                return getName(o1).compareTo(getName(o2));
            }
        });
    }

    public E getEntityByName(String name) {
        for(E entity : entityList){
            if(getName(entity).equals(name)){
                return entity;
            }
        }
        return null;
    }

    public boolean contains(String name) {
        for(E entity : entityList){
            if(getName(entity).equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : entityList) {
            sb.append(getName(e)).append("\n");
        }
        return sb.toString();
    }
}
