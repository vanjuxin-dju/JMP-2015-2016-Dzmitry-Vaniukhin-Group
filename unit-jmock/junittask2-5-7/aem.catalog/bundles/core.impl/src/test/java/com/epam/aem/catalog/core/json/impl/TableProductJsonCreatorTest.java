package com.epam.aem.catalog.core.json.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.apache.sling.api.resource.Resource;
import org.junit.Test;

import com.epam.aem.catalog.core.base.BaseTest;
import com.epam.aem.catalog.core.json.JSONCreator;
import com.epam.aem.catalog.core.model.ProductModel;

public class TableProductJsonCreatorTest extends BaseTest {
	private JSONCreator<List<ProductModel>> creator = new TableProductJsonCreator();
	
	private static final String RESULT_LISTPRODUCT_1 =  "[{\"name\":\"Hewlett-Packard\"," + 
									"\"description\":\"Hewlett-Packard one simple mouse for every day\"," + 
									"\"count\":\"100\"," + 
									"\"tags\":\"[Device/Mouse, Color/Cyan]\"}]";
	
	private static final List<String> ALLOWED_PARAMETERS_1 = Arrays.asList(
			"name", "description", "count", "tags");
	
	private static final String RESULT_LISTPRODUCT_2 =  "[{\"name\":\"Hewlett-Packard\"," + 
			"\"description\":\"Hewlett-Packard one simple mouse for every day\"}]";

	private static final List<String> ALLOWED_PARAMETERS_2 = Arrays.asList(
			"name", "description");
	
	@Test
	public void testGeneratingJsonAllParams() {
		Resource resource = context.resourceResolver().getResource(
				"/content/dam/aem-catalog/product/pewlett-packard/hewlett-packard");
		ProductModel model = resource.adaptTo(ProductModel.class);
		List<ProductModel> list = new ArrayList<>();
		list.add(model);
		String json = creator.createJSON(list, ALLOWED_PARAMETERS_1);
		assertEquals(RESULT_LISTPRODUCT_1, json);
	}
	
	@Test
	public void testGeneratingJsonNotAllParams() {
		Resource resource = context.resourceResolver().getResource(
				"/content/dam/aem-catalog/product/pewlett-packard/hewlett-packard");
		ProductModel model = resource.adaptTo(ProductModel.class);
		List<ProductModel> list = new ArrayList<>();
		list.add(model);
		String json = creator.createJSON(list, ALLOWED_PARAMETERS_2);
		assertEquals(RESULT_LISTPRODUCT_2, json);
	}
}
