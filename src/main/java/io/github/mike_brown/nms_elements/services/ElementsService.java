package io.github.mike_brown.nms_elements.services;

import io.github.mike_brown.nms_elements.entities.Element;
import io.github.mike_brown.nms_elements.repositories.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementsService {
    private final ElementRepository elementRepo;

    public List<Element> getAllElements() {
        return elementRepo.findAll();
    }

    public Optional<Element> findElementByName(String name) {
        return elementRepo.findByNameIgnoreCase(name);
    }



}
