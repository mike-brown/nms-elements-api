package io.github.mike_brown.nms_elements.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="large_refiner_recipes")
public class LargeRefinerRecipe implements Recipe {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @Getter
    @JoinColumn(name="source_1_element_id")
    private Element source1Element;

    @Getter
    @Column(name="source_1_amount")
    private int source1Amount;

    @ManyToOne
    @Getter
    @JoinColumn(name="source_2_element_id")
    private Element source2Element;

    @Getter
    @Column(name="source_2_amount")
    private int source2Amount;

    @ManyToOne
    @Getter
    @JoinColumn(name="source_3_element_id")
    private Element source3Element;

    @Getter
    @Column(name="source_3_amount")
    private int source3Amount;

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
