package io.github.mike_brown.nms_elements.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="small_refiner_recipes")
@AllArgsConstructor
@NoArgsConstructor
public class SmallRefinerRecipe implements Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    private int id;

    @ManyToOne
    @Getter
    private Element sourceElement;

    @Getter
    private int sourceAmount;

    @ManyToOne
    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    protected Element targetElement;

    @Getter
    protected int targetAmount;

    @Override
    public Boolean isTargetFor(Element element) {
        return this.targetElement == element;
    }
}
