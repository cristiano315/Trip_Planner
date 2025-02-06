package pera.trip_planner.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class EntityList<E> implements Serializable {
    private List<E> list = new ArrayList<E>();

    protected abstract String getName(E entity);

    public void addEntity(E entity) {
        list.add(entity);
    }

    public void removeEntity(String name) {
        for(E entity : list){
            if(getName(entity).equals(name)){
                list.remove(entity);
            }
        }
    }

    public List<E> getList() {
        return list;
    }

    public void sort(){
        list.sort(new Comparator<E>() {
            public int compare(E o1, E o2) {
                return getName(o1).compareTo(getName(o2));
            }
        });
    }

    public E getEntityByName(String name) {
        for(E entity : list){
            if(getName(entity).equals(name)){
                return entity;
            }
        }
        return null;
    }

    public boolean contains(String name) {
        for(E entity : list){
            if(getName(entity).equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : list) {
            sb.append(getName(e)).append("\n");
        }
        return sb.toString();
    }
}
