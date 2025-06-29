package io.github.mike_brown.nms_elements.serialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.github.mike_brown.nms_elements.models.ElementOverview;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ElementOverviewJson {

    public static class Serializer extends StdSerializer<ElementOverview> {
        protected Serializer() {
            super(ElementOverview.class);
        }

        @Override
        public void serialize(ElementOverview value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {

            jgen.writeStartObject();
            if(value.isMissing()) {
                jgen.writeStringField("unknown_element", value.getNotFound());
            } else {
                jgen.writeFieldName("element");
                jgen.writeObject(value.getElement());

                jgen.writeFieldName("refinerRecipes");
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


}
