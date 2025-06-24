package io.github.mike_brown.nms_elements.serialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.github.mike_brown.nms_elements.models.ElementOverview;

import java.io.IOException;

public class ElementOverviewSerializer extends StdSerializer<ElementOverview> {

    public ElementOverviewSerializer() {
        this(null);
    }

    public ElementOverviewSerializer(Class<ElementOverview> t) {
        super(t);
    }

    @Override
    public void serialize(
            ElementOverview value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        if(value.isMissing()) {
            jgen.writeStringField("Not Found", value.getNotFound());
        } else {

            jgen.writeFieldName("element");
            jgen.writeObject(value.getElement());

            jgen.writeFieldName("refiner_recipies");
            jgen.writeStartObject();
                jgen.writeFieldName("small");
                jgen.writeObject(value.getSmallRefinerRecipes());

                jgen.writeFieldName("medium");
                jgen.writeObject(value.getMediumRefinerRecipes());

                jgen.writeFieldName("large");
                jgen.writeObject(value.getLargeRefinerRecipes());
            jgen.writeEndObject();

        }
        jgen.writeEndObject();
    }
}
