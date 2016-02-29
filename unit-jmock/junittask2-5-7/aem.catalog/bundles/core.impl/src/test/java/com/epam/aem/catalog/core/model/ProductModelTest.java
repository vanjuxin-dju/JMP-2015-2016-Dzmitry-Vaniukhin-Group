package com.epam.aem.catalog.core.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.junit.Test;

import com.epam.aem.catalog.core.base.BaseTest;

public class ProductModelTest extends BaseTest {

	private static final String NAME = "Logitech";
	private static final String DESCRIPTION = "Logitech full black mouse";
	private static final String IMAGE_PATH = "/content/jcr_root/content/dam/aem-catalog/media/images/mouse-b.jpg";
	private static final Integer COUNT = 12;
	private static final List<String> TAGS = Arrays.asList("Device/Mouse",
			"Color/Black");

	@Test
	public void testProducatModel() {
		Resource resource = context.resourceResolver().getResource(
				"/content/dam/aem-catalog/product/logitech/logitech-x5");
		ProductModel model = resource.adaptTo(ProductModel.class);
		// asserts
		assertEquals(NAME, model.getName());
		assertEquals(COUNT, model.getCount());
		assertEquals(DESCRIPTION, model.getDescription());
		assertEquals(IMAGE_PATH, model.getImagePath());
		assertEquals(TAGS, model.getTags());
	}
}
