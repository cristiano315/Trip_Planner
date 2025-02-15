package pera.trip_planner.model.dao.file_system.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pera.trip_planner.model.domain.Country;

import java.io.IOException;

public class CountrySerializer extends StdSerializer<Country> {

    public CountrySerializer() {
        this(null);
    }

    protected CountrySerializer(Class<Country> t) {
        super(t);
    }

    @Override
    public void serialize(Country value, JsonGenerator gen, SerializerProvider arg2) throws IOException {
        gen.writeString(value.getName());
    }
}
