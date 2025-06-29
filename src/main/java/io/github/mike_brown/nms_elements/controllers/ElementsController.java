package io.github.mike_brown.nms_elements.controllers;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.enums.RarityEnum;
import io.github.mike_brown.nms_elements.models.ElementOverview;
import io.github.mike_brown.nms_elements.models.ElementsList;
import io.github.mike_brown.nms_elements.services.ElementsService;
import io.github.mike_brown.nms_elements.services.RefinementsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    private static final Logger logger = LoggerFactory.getLogger(ElementsController.class);

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
                groupedByRarity.getOrDefault(RarityEnum.rare, List.of()),
                groupedByRarity.getOrDefault(RarityEnum.product, List.of())
        );
    }

    @GetMapping(path="/{name}")
    public ResponseEntity<ElementOverview> elementOverview(@PathVariable String name) {
        Optional<Element> maybeElement = elementsService.findElementByName(name);

        if(maybeElement.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ElementOverview(name));
        }

        Element foundElement = maybeElement.get();

        logger.debug(foundElement.getName());

        return ResponseEntity.ok(new ElementOverview(
            foundElement,
            refinementsService.findSmallRecipesForElement(foundElement),
            refinementsService.findMediumRecipesForElement(foundElement),
            refinementsService.findLargeRecipesForElement(foundElement)
        ));
    }
}
