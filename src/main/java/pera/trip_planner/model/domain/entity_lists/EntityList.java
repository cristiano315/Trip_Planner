package pera.trip_planner.model.domain.entity_lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class EntityList<E> implements Serializable {
    private final ArrayList<E> itemsList = new ArrayList<>();

    protected abstract String getName(E entity);

    public void addEntity(E entity) {
        itemsList.add(entity);
    }

    public void removeEntity(String name) {
        for(E entity : itemsList){
            if(getName(entity).equals(name)){
                itemsList.remove(entity);
            }
        }
    }

    public List<E> getList() {
        return itemsList;
    }

    public void sort(){
        itemsList.sort(new Comparator<E>() {
            public int compare(E o1, E o2) {
                return getName(o1).compareTo(getName(o2));
            }
        });
    }

    public E getEntityByName(String name) {
        for(E entity : itemsList){
            if(getName(entity).equals(name)){
                return entity;
            }
        }
        return null;
    }

    public boolean contains(String name) {
        for(E entity : itemsList){
            if(getName(entity).equals(name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E e : itemsList) {
            sb.append(getName(e)).append("\n");
        }
        return sb.toString();
    }
}
