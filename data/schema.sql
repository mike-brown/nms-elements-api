CREATE TABLE elements (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    rarity ENUM('common', 'uncommon', 'rare', 'product')
);

CREATE TABLE small_refiner_recipes (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    source_element_id INT REFERENCES elements (id) NOT NULL,
    source_amount INT NOT NULL,
    target_element_id INT REFERENCES elements (id) NOT NULL,
    target_amount INT NOT NULL,
    UNIQUE (source_element_id, target_element_id),
    CHECK (source_element_id <> target_element_id)
);

CREATE TABLE medium_refiner_recipes (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    source_1_element_id INT REFERENCES elements (id) NOT NULL,
    source_1_amount INT NOT NULL,
    source_2_element_id INT REFERENCES elements (id) NOT NULL,
    source_2_amount INT NOT NULL,
    target_element_id INT REFERENCES elements (id) NOT NULL,
    target_amount INT NOT NULL,
    UNIQUE (source_1_element_id, source_2_element_id, target_element_id),
    CHECK (source_1_element_id <> source_2_element_id)
);

CREATE TABLE large_refiner_recipes (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    source_1_element_id INT REFERENCES elements (id) NOT NULL,
    source_1_amount INT NOT NULL,
    source_2_element_id INT REFERENCES elements (id) NOT NULL,
    source_2_amount INT NOT NULL,
    source_3_element_id INT REFERENCES elements (id) NOT NULL,
    source_3_amount INT NOT NULL,
    target_element_id INT REFERENCES elements (id) NOT NULL,
    target_amount INT NOT NULL,
    UNIQUE (source_1_element_id, source_2_element_id, source_3_element_id, target_element_id),
    CHECK (
        source_1_element_id <> source_2_element_id AND
        source_1_element_id <> source_3_element_id AND
        source_2_element_id <> source_3_element_id
    )
);