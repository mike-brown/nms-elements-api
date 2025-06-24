package io.github.mike_brown.nms_elements.services;

import io.github.mike_brown.nms_elements.entities.*;
import io.github.mike_brown.nms_elements.models.RecipesForElement;
import io.github.mike_brown.nms_elements.repositories.LargeRefinerRecipeRepository;
import io.github.mike_brown.nms_elements.repositories.MediumRefinerRecipeRepository;
import io.github.mike_brown.nms_elements.repositories.RecipeRepository;
import io.github.mike_brown.nms_elements.repositories.SmallRefinerRecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefinementsService {
    private final SmallRefinerRecipeRepository smallRefinerRecipeRepository;
    private final MediumRefinerRecipeRepository mediumRefinerRecipeRepository;
    private final LargeRefinerRecipeRepository largeRefinerRecipeRepository;

    private <T extends Recipe> RecipesForElement<T> findRecipesForElement(Element element, RecipeRepository<T> repository) {
        List<T> recipes = repository.findBySourceOrTargetElement(element);
        Map<Boolean, List<T>> partitions = recipes.stream().collect(
                Collectors.partitioningBy(s -> s.isTargetFor(element))
        );
        return new RecipesForElement<T>(
                partitions.get(false), // Not the target, so the source
                partitions.get(true)   // Is the target
        );
    }

    public RecipesForElement<SmallRefinerRecipe> findSmallRecipesForElement(Element element) {
        return findRecipesForElement(element, smallRefinerRecipeRepository);
    }

    public RecipesForElement<MediumRefinerRecipe> findMediumRecipesForElement(Element element) {
        return findRecipesForElement(element, mediumRefinerRecipeRepository);
    }

    public RecipesForElement<LargeRefinerRecipe> findLargeRecipesForElement(Element element) {
        return findRecipesForElement(element, largeRefinerRecipeRepository);
    }
}
