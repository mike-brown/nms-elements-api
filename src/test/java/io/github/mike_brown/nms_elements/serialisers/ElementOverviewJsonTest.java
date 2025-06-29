package io.github.mike_brown.nms_elements.serialisers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.LargeRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.MediumRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.SmallRefinerRecipe;
import io.github.mike_brown.nms_elements.models.ElementOverview;
import io.github.mike_brown.nms_elements.models.RecipesForElement;
import io.github.mike_brown.nms_elements.testutils.CreationHelpers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(ElementOverviewJson.class)
@JsonTest
public class ElementOverviewJsonTest {

    @Autowired
    private JacksonTester<ElementOverview> jacksonTester;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testSerialisationOfNotFound() throws IOException {
        ElementOverview elementOverview = new ElementOverview("Missing");

        JsonContent<ElementOverview> json = jacksonTester.write(elementOverview);
        assertThat(json).extractingJsonPathStringValue("$.unknown_element").isEqualTo("Missing");
    }

    @Test
    void testSerialisationOfFoundElement() throws IOException {
        Element element = CreationHelpers.Elements.build("ElementName");

        RecipesForElement<SmallRefinerRecipe> small = CreationHelpers.RecipesForElements.Small.build();
        RecipesForElement<MediumRefinerRecipe> medium = CreationHelpers.RecipesForElements.Medium.build();
        RecipesForElement<LargeRefinerRecipe> large = CreationHelpers.RecipesForElements.Large.build();

        ElementOverview elementOverview = new ElementOverview(
                element, small, medium, large
        );

        String json = mapper.writeValueAsString(elementOverview);

        JsonNode node = mapper.readTree(json);

        JsonNode elementNode = node.get("element");
        assertEquals("ElementName", node.at("/element/name").asText());

        assertEquals("sourceSmall", node.at("/refinerRecipes/small/asSource/0/sourceElement/name").asText());
        assertEquals("10", node.at("/refinerRecipes/small/asSource/0/sourceAmount").asText());
        assertEquals("targetSmall", node.at("/refinerRecipes/small/asTarget/0/targetElement/name").asText());
        assertEquals("10", node.at("/refinerRecipes/small/asTarget/0/targetAmount").asText());

        assertEquals("sourceMedium1", node.at("/refinerRecipes/medium/asSource/0/source1Element/name").asText());
        assertEquals("10", node.at("/refinerRecipes/medium/asSource/0/source1Amount").asText());
        assertEquals("sourceMedium2", node.at("/refinerRecipes/medium/asSource/0/source2Element/name").asText());
        assertEquals("10", node.at("/refinerRecipes/medium/asSource/0/source2Amount").asText());
        assertEquals("targetMedium", node.at("/refinerRecipes/medium/asTarget/0/targetElement/name").asText());
        assertEquals("10", node.at("/refinerRecipes/medium/asTarget/0/targetAmount").asText());

        assertEquals("sourceLarge1", node.at("/refinerRecipes/large/asSource/0/source1Element/name").asText());
        assertEquals("10", node.at("/refinerRecipes/large/asSource/0/source1Amount").asText());
        assertEquals("sourceLarge2", node.at("/refinerRecipes/large/asSource/0/source2Element/name").asText());
        assertEquals("10", node.at("/refinerRecipes/medium/asSource/0/source2Amount").asText());
        assertEquals("sourceLarge3", node.at("/refinerRecipes/large/asSource/0/source3Element/name").asText());
        assertEquals("10", node.at("/refinerRecipes/large/asSource/0/source3Amount").asText());
        assertEquals("targetLarge", node.at("/refinerRecipes/large/asTarget/0/targetElement/name").asText());
        assertEquals("10", node.at("/refinerRecipes/large/asTarget/0/targetAmount").asText());
    }
}
