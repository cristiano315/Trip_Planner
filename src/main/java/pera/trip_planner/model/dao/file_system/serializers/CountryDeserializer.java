package pera.trip_planner.model.dao.file_system.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pera.trip_planner.model.dao.DaoFactory;
import pera.trip_planner.model.domain.Country;

import java.io.IOException;

public class CountryDeserializer extends StdDeserializer<Country> {

    public CountryDeserializer(Class<?> t) {
        super(t);
    }

    public CountryDeserializer() {
        this(null);
    }

    @Override
    public Country deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        String countryName = jsonparser.getText();
        return DaoFactory.getInstance().getCountryDao().load(countryName);
    }

}
