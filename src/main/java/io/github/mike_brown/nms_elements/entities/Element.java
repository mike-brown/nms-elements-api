package io.github.mike_brown.nms_elements.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.mike_brown.nms_elements.enums.RarityEnum;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name="elements")
public class Element {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Getter
    @Column(unique=true, nullable=false)
    private String name;

    @Getter
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private RarityEnum rarity;

}
