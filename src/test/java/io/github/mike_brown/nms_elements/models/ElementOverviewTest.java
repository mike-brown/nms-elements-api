package io.github.mike_brown.nms_elements.models;

import io.github.mike_brown.nms_elements.testutils.CreationHelpers.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ElementOverviewTest {
    @Test
    void isMissingTest() {
        ElementOverview found = new ElementOverview(
                Elements.build(),
                null, null, null
        );
        assertThat(found.isMissing(), is(false));

        ElementOverview notFound = new ElementOverview("Missing");
        assertThat(notFound.isMissing(), is(true));
    }
}
