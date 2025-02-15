package pera.trip_planner.model.dao.file_system;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import pera.trip_planner.exception.JsonException;
import pera.trip_planner.model.dao.DAO;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public abstract class FileSystemDao<K, V> implements DAO<K, V> {
    private final  String path = "./src/main/resources/pera/trip_planner/Json/" + getFileName() + ".json";
    protected HashMap<K, V> memory = new HashMap<>();
    private File memoryFile;
    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
    private final ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

    protected void store(K key, V value) {
        memory.put(key, value);
        writeToFile();
    }

    public void writeToFile(){
        try{
            writer.writeValue(memoryFile, memory);
        } catch (IOException e){
            throw new JsonException("Error writing to " + getFileName() + ".json file");
        }
    }

    protected void initialize(){
        memoryFile = new File(path);
        try{
            memory = mapper.readValue(memoryFile, getTypeReference());
        } catch (MismatchedInputException e) {
            memory = new HashMap<>();
        } catch (IOException e){
            throw new JsonException("Error reading " + getFileName() + ".json file");
        }

    }

    @Override
    public V load(K id){
        return memory.get(id);
    }

    @Override
    public void store(V entity) {
        K key = getKey(entity);
        store(key, entity);
    }

    @Override
    public void delete(K id) {
        memory.remove(id);
        writeToFile();
    }

    @Override
    public boolean exists(K id){
        return memory.containsKey(id);
    }


    protected abstract TypeReference<HashMap<K,V>> getTypeReference();
    protected abstract String getFileName();
    protected abstract K getKey(V value);
}
