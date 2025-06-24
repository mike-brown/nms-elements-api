package io.github.mike_brown.nms_elements.repositories;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.SmallRefinerRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmallRefinerRecipeRepository extends RecipeRepository<SmallRefinerRecipe>{
    @Query("""
        SELECT r FROM SmallRefinerRecipe r
        WHERE r.sourceElement = ?1 or r.targetElement = ?1
    """)
    List<SmallRefinerRecipe> findBySourceOrTargetElement(Element element);
}
