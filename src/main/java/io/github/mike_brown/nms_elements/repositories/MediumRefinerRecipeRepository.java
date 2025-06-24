package io.github.mike_brown.nms_elements.repositories;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.MediumRefinerRecipe;
import io.github.mike_brown.nms_elements.entities.SmallRefinerRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediumRefinerRecipeRepository extends RecipeRepository<MediumRefinerRecipe> {
    @Query("""
        SELECT r FROM MediumRefinerRecipe r
        WHERE r.source1Element = ?1 OR r.source2Element = ?1 OR r.targetElement = ?1
    """)
    List<MediumRefinerRecipe> findBySourceOrTargetElement(Element element);
}
