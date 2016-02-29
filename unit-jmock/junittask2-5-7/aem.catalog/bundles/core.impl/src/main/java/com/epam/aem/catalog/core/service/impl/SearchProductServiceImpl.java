package com.epam.aem.catalog.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.jcr.query.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;

import com.epam.aem.catalog.core.model.ProductModel;
import com.epam.aem.catalog.core.model.ProductRequestModel;
import com.epam.aem.catalog.core.service.SearchProductService;

/*
 * build query SQL2,  like next example:
 * SELECT s.* FROM [nt:unstructured] AS s WHERE  ISDESCENDANTNODE([/content/dam/aem-catalog/product]) 
 * 		AND  ([jcr:title]='QUERY' OR lower([jcr:description]) like '%QUERY%' OR [tags] like '%QUERY%')
 */
@Service
@Component
public class SearchProductServiceImpl implements SearchProductService {

	private static final String CONTENT_NODE_TYPE = "nt:unstructured";
	private static final String CONTENT_NODE_PATH = "/content/dam/aem-catalog/product";

	@Reference
	private ResourceResolverFactory factory;
	private ResourceResolver resolver;

	@SuppressWarnings("deprecation")
	@Activate
	public void initialize(ComponentContext context) throws LoginException {
		resolver=factory.getAdministrativeResourceResolver(null);
	}

	@Override
	public List<ProductModel> returnProducts(ProductRequestModel model) {
		List<ProductModel> products = new ArrayList<>(0);

		String statement = buildStatement(StringUtils.defaultString(
				model.getQuery(), ""));
		Iterator<Resource> resources = resolver.findResources(
				statement, Query.JCR_SQL2);
		while (resources.hasNext()) {
			ProductModel product = resources.next().adaptTo(ProductModel.class);
			if (product != null) {
				products.add(product);
			}
		}
		if (model.getSortOrder()) {
			Collections.sort(products, new ProductComporator());
		}
		return products;
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
			// TODO
			sb.append("' OR lower([jcr:description]) like '%");
			sb.append(query);
			sb.append("%' OR [tags] like '%");
			sb.append(query);
			sb.append("%')");
		}
		return sb.toString();
	}

	private class ProductComporator implements Comparator<ProductModel> {

		@Override
		public int compare(ProductModel arg0, ProductModel arg1) {
			if (arg0.getName() == null && arg1.getName() == null) {
				return 0;
			}
			if (arg0.getName() == null) {
				return -1;
			}
			if (arg1.getName() == null) {
				return 1;
			}
			return arg0.getName().compareToIgnoreCase(arg1.getName());
		}

	}
}
