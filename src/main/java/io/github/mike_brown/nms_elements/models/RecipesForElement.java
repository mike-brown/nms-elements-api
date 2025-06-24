package io.github.mike_brown.nms_elements.models;

import io.github.mike_brown.nms_elements.entities.Recipe;

import java.util.List;

public record RecipesForElement<T extends Recipe>(
        List<T> asSource,
        List<T> asTarget) {}
