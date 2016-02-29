package com.epam.aem.catalog.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.epam.aem.catalog.core.base.BaseTest;

public class ProductRequestModelTest extends BaseTest {

	private static final Boolean IS_SORTED = true;
	private static final String QUERY = "Logitech";
	// keys
	private static final String COUNT = "count";
	private static final String DESCRIPTION = "description";
	private static final String NAME = "name";
	private static final String TAGS = "tags";

	@Test
	public void toTest() {
		ProductRequestModel model = context.request().adaptTo(
				ProductRequestModel.class);
		List<String> fields = model.getFields();
		
		assertEquals(IS_SORTED, model.getSortOrder());
		assertEquals(QUERY, model.getQuery());

		assertTrue(fields.contains(NAME));
		assertTrue(fields.contains(COUNT));
		assertTrue(fields.contains(DESCRIPTION));
		assertFalse(fields.contains(TAGS));
	}

}
