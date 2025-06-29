package io.github.mike_brown.nms_elements.models;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.LargeRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.MediumRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.SmallRefinerRecipe;
import io.github.mike_brown.nms_elements.serialisers.ElementOverviewJson;
import lombok.Getter;

@JsonSerialize(using=ElementOverviewJson.Serializer.class)
public class ElementOverview {
    @Getter
    private String notFound;

    @Getter
    private Element element;
    @Getter
    private RecipesForElement<SmallRefinerRecipe> smallRefinerRecipes;
    @Getter
    private RecipesForElement<MediumRefinerRecipe> mediumRefinerRecipes;
    @Getter
    private RecipesForElement<LargeRefinerRecipe> largeRefinerRecipes;

    public ElementOverview(Element element,
                           RecipesForElement<SmallRefinerRecipe> small,
                           RecipesForElement<MediumRefinerRecipe> medium,
                           RecipesForElement<LargeRefinerRecipe> large) {
        this.element = element;
        this.smallRefinerRecipes = small;
        this.mediumRefinerRecipes = medium;
        this.largeRefinerRecipes = large;
    }

    public ElementOverview(String name) {
        this.notFound = name;
    }

    public ElementOverview() {}

    public boolean isMissing() {
        return this.element == null;
    }
}
