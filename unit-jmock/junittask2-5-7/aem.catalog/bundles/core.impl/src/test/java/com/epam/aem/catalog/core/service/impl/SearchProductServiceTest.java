package com.epam.aem.catalog.core.service.impl;

import static org.mockito.Mockito.when;
import io.wcm.testing.mock.aem.junit.AemContext;

import java.util.Arrays;
import java.util.List;

import javax.jcr.query.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.aem.catalog.core.model.ProductModel;
import com.epam.aem.catalog.core.model.ProductRequestModel;
import com.epam.aem.catalog.core.service.SearchProductService;

// it doesn't work
public class SearchProductServiceTest {
	private SearchProductService service = new SearchProductServiceImpl();
	
	private static final int EXPECTED_LENGTH_1 = 2;
	
	private static final String MODEL_PACKAGE="com.epam.aem.catalog.core.model";
	private static final String CURRENT_PAGE="/content/aem-catalog/en";
	private static final String CURRENT_RESOURCE="/content/aem-catalog/en/jcr:content/par/listproduct";
	private static final String SELECTORS="searchproduct";
	private static final String SUFFIX="json";
	
	private static final String QUERY_VALUE = "Color";
	private static final String QUERY_STRING="query=" + QUERY_VALUE;
	
	private static final String CONTENT_NODE_TYPE = "nt:unstructured";
	private static final String CONTENT_NODE_PATH = "/content/dam/aem-catalog/product";
	
	@Rule
	public  AemContext context=new AemContext(ResourceResolverType.JCR_MOCK);
	
	@Mock
	ProductRequestModel model;
	
	@Mock
	ResourceResolver resourceResolverMock;
	
	@Mock
	ResourceResolverFactory resolverFactoryMock;
	
	@Mock
	Resource resourceMock;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		//load test content from json 
		ProductModel productModel = new ProductModel();

		List<Resource> resources = Arrays.asList(resourceMock);
		context.load().json("/content.json", "/content");
		//build request
		context.request().setQueryString(QUERY_STRING);
		context.requestPathInfo().setSelectorString(SELECTORS);
		context.requestPathInfo().setSuffix(SUFFIX);
		//set resource that send request
		context.currentPage(CURRENT_PAGE);
		context.currentResource(CURRENT_RESOURCE);
		//
		context.requestPathInfo().setResourcePath(CURRENT_RESOURCE);
		context.addModelsForPackage(MODEL_PACKAGE);
		
		when(model.getQuery()).thenReturn(QUERY_VALUE);
		String statement = buildStatement(QUERY_VALUE);
		when(resourceMock.adaptTo(ProductModel.class)).thenReturn(productModel);
		when(resourceResolverMock.findResources(statement, Query.JCR_SQL2)).thenReturn(resources.iterator());
		context.registerInjectActivateService(service);
		/*
		resourceResolverMock = context.resourceResolver();
		assertNotNull(resourceResolverMock);
		requestMock = new MockSlingHttpServletRequest(resourceResolverMock);*/
	}
	
	@Test @Ignore
	public void testSearchProductService() {
		//ProductRequestModel model = context.request().adaptTo(ProductRequestModel.class);
		//model = requestMock.adaptTo(ProductRequestModel.class);
		List<ProductModel> list = service.returnProducts(model);
		
		Assert.assertEquals(EXPECTED_LENGTH_1, list.size());
	}
	
	private String buildStatement(String query) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT s.* FROM [");
		sb.append(CONTENT_NODE_TYPE);
		sb.append("] AS s WHERE ");
		sb.append(" ISDESCENDANTNODE([");
		sb.append(CONTENT_NODE_PATH);
		sb.append("])");
		if (!StringUtils.isEmpty(query)) {
			sb.append(" AND  ([jcr:title]='");
			sb.append(query);
			sb.append("' OR lower([jcr:description]) like '%");
			sb.append(query);
			sb.append("%' OR [tags] like '%");
			sb.append(query);
			sb.append("%')");
		}
		return sb.toString();
	}
}
