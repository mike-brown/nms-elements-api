package io.github.mike_brown.nms_elements.repositories;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.LargeRefinerRecipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LargeRefinerRecipeRepository extends RecipeRepository<LargeRefinerRecipe> {
    @Query("""
        SELECT r FROM LargeRefinerRecipe r
        WHERE r.source1Element = ?1 OR r.source2Element = ?1 OR r.source3Element = ?1 OR r.targetElement = ?1
    """)
    List<LargeRefinerRecipe> findBySourceOrTargetElement(Element element);
}
