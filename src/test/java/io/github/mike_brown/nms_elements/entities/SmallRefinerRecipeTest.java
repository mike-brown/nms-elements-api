package io.github.mike_brown.nms_elements.entities;

import io.github.mike_brown.nms_elements.testutils.CreationHelpers.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestPropertySource("classpath:application-test.properties")
public class SmallRefinerRecipeTest {
    @Test
    void isTargetForTest() {
        Element testElement = Elements.build();
        Element differentElement = Elements.build();

        SmallRefinerRecipe r = new SmallRefinerRecipe();
        r.setTargetElement(testElement);

        assertThat(r.isTargetFor(testElement), is(true));
        assertThat(r.isTargetFor(differentElement), is(false));

    }
}
