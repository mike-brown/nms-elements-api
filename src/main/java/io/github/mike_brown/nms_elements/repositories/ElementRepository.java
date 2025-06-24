package io.github.mike_brown.nms_elements.repositories;

import io.github.mike_brown.nms_elements.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElementRepository extends JpaRepository<Element, Integer> {
    public Optional<Element> findByNameIgnoreCase(String name);
}
