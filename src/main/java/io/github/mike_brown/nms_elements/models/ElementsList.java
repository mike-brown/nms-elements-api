package io.github.mike_brown.nms_elements.models;

import io.github.mike_brown.nms_elements.entities.Element;

import java.util.List;

public record ElementsList(
        List<Element> common,
        List<Element> uncommon,
        List<Element> rare,
        List<Element> products) {
}
