package com.epam.aem.catalog.core.servlets.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.aem.catalog.core.base.BaseTest;
import com.epam.aem.catalog.core.json.JSONCreator;
import com.epam.aem.catalog.core.model.ProductModel;
import com.epam.aem.catalog.core.model.ProductRequestModel;
import com.epam.aem.catalog.core.service.SearchProductService;

public class SearchProductServletTest extends BaseTest {

	private static final String JSON = "[{\"name\":\"Hewlett-Packard\","
			+ "\"description\":\"Hewlett-Packard one simple mouse for every day\","
			+ "\"count\":\"100\","
			+ "\"tags\":\"[Device/Mouse, Color/Cyan]\"}]";

	private static final String EMPTY_JSON = "[]";

	@Mock
	private SlingHttpServletRequest requestMock;
	//case then don't set return parameter
	@Mock
	private SlingHttpServletRequest emptyRequestMock;

	@Mock
	private ProductRequestModel model;
	@Mock
	private ProductRequestModel modelEmpty;

	@Mock
	private SearchProductService productService;

	@Mock
	private JSONCreator<List<ProductModel>> creator;


	private MockSlingHttpServletResponse responseMock;
	private SearchProductServlet instance;

	@Before
	public void init() throws IOException {
		
		MockitoAnnotations.initMocks(this);
		responseMock=new MockSlingHttpServletResponse();
		instance = new SearchProductServlet();
		
		when(model.getFields()).thenReturn(Arrays.asList(""));
		when(modelEmpty.getFields()).thenReturn(new ArrayList<String>());
		
		when(requestMock.adaptTo(ProductRequestModel.class)).thenReturn(model);
		when(emptyRequestMock.adaptTo(ProductRequestModel.class)).thenReturn(modelEmpty);
		
		when(productService.returnProducts(model)).thenReturn(
				new ArrayList<ProductModel>());
		when(
				creator.createJSON(Collections.<ProductModel> emptyList(),
						model.getFields())).thenReturn(JSON);

		context.registerService(SearchProductService.class, productService);
		context.registerService(JSONCreator.class, creator);		

		context.registerInjectActivateService(instance);
	}

	@Test
	public void toTest() throws ServletException, IOException {
		assertNotNull(instance);		
		instance.doGet(requestMock, responseMock);
		assertEquals(JSON,responseMock.getOutputAsString());
	}
	
	@Test
	public void toTestEmptyReturnedParameters() throws ServletException, IOException {
		assertNotNull(instance);		
		instance.doGet(emptyRequestMock, responseMock);
		assertEquals(EMPTY_JSON,responseMock.getOutputAsString());
	}
}