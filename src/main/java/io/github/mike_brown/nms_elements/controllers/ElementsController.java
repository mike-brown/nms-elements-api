package io.github.mike_brown.nms_elements.controllers;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.enums.RarityEnum;
import io.github.mike_brown.nms_elements.models.ElementOverview;
import io.github.mike_brown.nms_elements.models.ElementsList;
import io.github.mike_brown.nms_elements.services.ElementsService;
import io.github.mike_brown.nms_elements.services.RefinementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ElementsController {

    private final ElementsService elementsService;
    private final RefinementsService refinementsService;

    @GetMapping(path="/")
    public ElementsList elements() {
        Map<RarityEnum, List<Element>> groupedByRarity = elementsService.getAllElements()
                .stream()
                .collect(Collectors.groupingBy(Element::getRarity));

        return new ElementsList(
                groupedByRarity.getOrDefault(RarityEnum.common, List.of()),
                groupedByRarity.getOrDefault(RarityEnum.uncommon, List.of()),
                groupedByRarity.getOrDefault(RarityEnum.rare, List.of())
        );
    }

    @GetMapping(path="/{name}")
    public ElementOverview elementOverview(@PathVariable String name) {
        Optional<Element> maybeElement = elementsService.findElementByName(name);

        if(maybeElement.isEmpty()) {
            return new ElementOverview(name);
        }

        Element foundElement = maybeElement.get();

        return new ElementOverview(
            foundElement,
            refinementsService.findSmallRecipesForElement(foundElement),
            refinementsService.findMediumRecipesForElement(foundElement),
            refinementsService.findLargeRecipesForElement(foundElement)
        );
    }
}
