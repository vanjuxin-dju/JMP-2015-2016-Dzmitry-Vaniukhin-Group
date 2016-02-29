package com.epam.aem.catalog.core.servlets.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.epam.aem.catalog.core.json.JSONCreator;
import com.epam.aem.catalog.core.model.ProductModel;
import com.epam.aem.catalog.core.model.ProductRequestModel;
import com.epam.aem.catalog.core.service.SearchProductService;

@SlingServlet(resourceTypes = "sling/servlet/default", selectors = {"searchproduct"}, extensions={"json"})
public class SearchProductServlet extends SlingSafeMethodsServlet {

	// implements Serializable.class
	private static final long serialVersionUID = -1650111109934560502L;

	private static final String JSON_EMPTY = "[]";
	private static final String CONTENT_TYPE = "application/json";
	private static final String ENCODING="UTF-8";

	@Reference
	private JSONCreator<List<ProductModel>> creator;
	@Reference
	private SearchProductService productService;

	@Override
	protected void doGet(SlingHttpServletRequest request,
			SlingHttpServletResponse response) throws ServletException,
			IOException {

		ProductRequestModel model = request.adaptTo(ProductRequestModel.class);
		List<String> returnedFields = model.getFields();
		
		response.setContentType(CONTENT_TYPE);
		response.setCharacterEncoding(ENCODING);
		
		if (!returnedFields.isEmpty()) {
			List<ProductModel> products = productService.returnProducts(model);
			String json = creator.createJSON(products, returnedFields);
			response.getWriter().write(json);
		} else {
			response.getWriter().write(JSON_EMPTY);
		}
	}
}
