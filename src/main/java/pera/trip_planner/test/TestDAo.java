package pera.trip_planner.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import pera.trip_planner.exception.JsonException;
import pera.trip_planner.model.dao.CountryDao;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.dao.PersistenceProvider;
import pera.trip_planner.model.dao.dbms.DbmsActivityAnnouncementDao;
import pera.trip_planner.model.domain.ActivityAnnouncement;
import pera.trip_planner.model.domain.Country;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class TestDAo {
    private final String url = "./src/main/resources/pera/trip_planner/Json/" + Country.class.getSimpleName() + ".json";

    public void start(){
    }

    public void testJackson(){
        File memoryFile = new File(url);
        DaoFactory.setPersistenceProvider(PersistenceProvider.IN_MEMORY);
        CountryDao countryDao = DaoFactory.getInstance().getCountryDao();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();


//        try{
//            writer.writeValue(memoryFile, countryDao.getCountryMap());
//        } catch (IOException e){
//            throw new JsonException("error writing countries");
//        }

        HashMap<String, Country> map;
        TypeReference<HashMap<String, Country>> typeRef = new TypeReference<HashMap<String, Country>>() {};

        try{
            map = mapper.readValue(memoryFile, typeRef);
        } catch (IOException e) {
            throw new JsonException("error reading countries");
        }

        for(Country country1 : map.values()){
            System.out.println(country1.getName());
        }

    }

    public void testDbms(){
        DbmsActivityAnnouncementDao dao = DbmsActivityAnnouncementDao.getInstance();
        ActivityAnnouncement ciao = dao.create("ciao");
        ciao.addDescription("lol");
        ciao.setIssuingDate(LocalDate.of(2022, 2, 2));
        dao.store(ciao);
    }

    public void testDbmsRetrieval(){
        DbmsActivityAnnouncementDao dao = DbmsActivityAnnouncementDao.getInstance();
        ActivityAnnouncement ciao = dao.load("ciao");
        System.out.println(ciao.getName());
        dao.delete("ciao");
    }

}
