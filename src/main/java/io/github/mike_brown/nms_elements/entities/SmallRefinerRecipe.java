package io.github.mike_brown.nms_elements.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="small_refiner_recipes")
public class SmallRefinerRecipe implements Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @Getter
    private Element sourceElement;

    @Getter
    private int sourceAmount;

    @ManyToOne
    @Getter
    protected Element targetElement;

    @Getter
    protected int targetAmount;

    @Override
    public Boolean isTargetFor(Element element) {
        return this.targetElement == element;
    }

}
