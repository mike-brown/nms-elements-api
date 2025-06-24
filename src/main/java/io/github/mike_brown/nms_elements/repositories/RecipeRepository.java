package io.github.mike_brown.nms_elements.repositories;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RecipeRepository<T extends Recipe> extends JpaRepository<T, Integer> {
    List<T> findBySourceOrTargetElement(Element element);
}
