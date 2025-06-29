package io.github.mike_brown.nms_elements.testutils;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.LargeRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.MediumRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.SmallRefinerRecipe;
import io.github.mike_brown.nms_elements.enums.RarityEnum;
import io.github.mike_brown.nms_elements.models.RecipesForElement;

import java.util.List;

public class CreationHelpers {
    public static class Elements {
        public static Element build() {
            return build("element", RarityEnum.common);
        }
        public static Element build(String name) { return new Element(1, name, RarityEnum.common); }
        public static Element build(String name, RarityEnum rarityEnum) {
            return new Element(1, name, rarityEnum);
        }
    }

    public static class RefinerRecipes {
        public static class Small {
            public static SmallRefinerRecipe build() {
                return new SmallRefinerRecipe(1,
                    Elements.build("sourceSmall"), 10,
                    Elements.build("targetSmall"), 10
                );
            }
        }
        public static class Medium {
            public static MediumRefinerRecipe build() {
                return new MediumRefinerRecipe(
                        1,
                        Elements.build("sourceMedium1"), 10,
                        Elements.build("sourceMedium2"), 10,
                        Elements.build("targetMedium"), 10
                );
            }
        }
        public static class Large {
            public static LargeRefinerRecipe build() {
                return new LargeRefinerRecipe(
                        1,
                        Elements.build("sourceLarge1"), 10,
                        Elements.build("sourceLarge2"), 10,
                        Elements.build("sourceLarge3"), 10,
                        Elements.build("targetLarge"), 10
                );
            }
        }
    }

    public static class RecipesForElements {
        public static class Small {
            public static RecipesForElement<SmallRefinerRecipe> build() {
                return new RecipesForElement<>(
                        List.of(RefinerRecipes.Small.build()),
                        List.of(RefinerRecipes.Small.build())
                );
            }
        }

        public static class Medium {
            public static RecipesForElement<MediumRefinerRecipe> build() {
                return new RecipesForElement<>(
                        List.of(RefinerRecipes.Medium.build()),
                        List.of(RefinerRecipes.Medium.build())
                );
            }
        }

        public static class Large {
            public static RecipesForElement<LargeRefinerRecipe> build() {
                return new RecipesForElement<>(
                        List.of(RefinerRecipes.Large.build()),
                        List.of(RefinerRecipes.Large.build())
                );
            }
        }
    }
}
