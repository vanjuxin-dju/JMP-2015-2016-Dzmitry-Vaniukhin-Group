package com.epam.aem.catalog.core.base;

import io.wcm.testing.mock.aem.junit.AemContext;

import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.Before;
import org.junit.Rule;

public class BaseTest {
	
	private static final String MODEL_PACKAGE="com.epam.aem.catalog.core.model";
	private static final String CURRENT_PAGE="/content/aem-catalog/en";
	private static final String CURRENT_RESOURCE="/content/aem-catalog/en/jcr:content/par/listproduct";
	private static final String SELECTORS="searchproduct";
	private static final String SUFFIX="json";
	private static final String QUERY_STRING="query=Logitech";
	

	@Rule
	public final AemContext context=new AemContext(ResourceResolverType.JCR_MOCK);
	
	@Before
	public void setUp() throws Exception{
		//load test content from json 
		context.load().json("/content.json", "/content");
		//build request
		context.request().setQueryString(QUERY_STRING);
		context.requestPathInfo().setSelectorString(SELECTORS);
		context.requestPathInfo().setSuffix(SUFFIX);
		//set resource that send request
		context.currentPage(CURRENT_PAGE);
		context.currentResource(CURRENT_RESOURCE);
		context.requestPathInfo().setResourcePath(CURRENT_RESOURCE);
		//
		context.addModelsForPackage(MODEL_PACKAGE);

	}
}
