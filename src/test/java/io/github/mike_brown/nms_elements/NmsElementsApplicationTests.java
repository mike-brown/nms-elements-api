package io.github.mike_brown.nms_elements;

import io.github.mike_brown.nms_elements.controllers.ElementsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NmsElementsApplicationTests {

	@Autowired
	private ElementsController elementsController;

	@Test
	void contextLoads() {

	}

}
