----------------
--- ELEMENTS ---
----------------
INSERT INTO elements (name, rarity) VALUES ('Carbon', 'common');
INSERT INTO elements (name, rarity) VALUES ('Oxygen', 'common');
INSERT INTO elements (name, rarity) VALUES ('Salt', 'common');

INSERT INTO elements (name, rarity) VALUES ('Condensed Carbon', 'uncommon');

INSERT INTO elements (name, rarity) VALUES ('Chlorine', 'rare');
INSERT INTO elements (name, rarity) VALUES ('Nitrogen', 'rare');

INSERT INTO elements (name, rarity) VALUES ('Nitrogen Salt', 'product');

---------------
--- RECIPES ---
---------------
INSERT INTO small_refiner_recipes (source_element_id, source_amount, target_element_id, target_amount)
    VALUES (
        (SELECT id FROM elements WHERE name = 'Carbon'), 2,
        (SELECT id FROM elements WHERE name = 'Condensed Carbon'), 1
);


INSERT INTO medium_refiner_recipes
    (source_1_element_id, source_1_amount, source_2_element_id, source_2_amount, target_element_id, target_amount)
    VALUES (
        (SELECT id FROM elements WHERE name = 'Carbon'), 2,
        (SELECT id FROM elements WHERE name = 'Oxygen'), 2,
        (SELECT id FROM elements WHERE name = 'Condensed Carbon'), 5
);
INSERT INTO medium_refiner_recipes
    (source_1_element_id, source_1_amount, source_2_element_id, source_2_amount, target_element_id, target_amount)
    VALUES (
        (SELECT id FROM elements WHERE name = 'Condensed Carbon'), 1,
        (SELECT id FROM elements WHERE name = 'Oxygen'), 2,
        (SELECT id FROM elements WHERE name = 'Condensed Carbon'), 6
);

INSERT INTO large_refiner_recipes
    (source_1_element_id, source_1_amount, source_2_element_id, source_2_amount, source_3_element_id, source_3_amount, target_element_id, target_amount)
    VALUES (
        (SELECT id FROM elements WHERE name = 'Nitrogen'), 100,
        (SELECT id FROM elements WHERE name = 'Carbon'), 20,
        (SELECT id FROM elements WHERE name = 'Chlorine'), 5,
        (SELECT id FROM elements WHERE name = 'Nitrogen Salt'), 1
);