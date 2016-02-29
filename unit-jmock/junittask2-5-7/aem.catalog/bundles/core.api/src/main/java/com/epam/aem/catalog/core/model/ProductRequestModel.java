package com.epam.aem.catalog.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class)
public class ProductRequestModel {

	private static final List<String> ALLOWED_PARAMETERS = Arrays.asList(
			"name", "description", "count", "tags");
	@Self
	private SlingHttpServletRequest request;

	@ValueMapValue
	@Default(booleanValues = false)
	private Boolean sortOrder;

	private String query;
	private List<String> fields;

	@PostConstruct
	public void init() {
		ResourceResolver resolver = request.getResourceResolver();
		query = request.getParameter("query");
		query = StringUtils.defaultString(query, "");

		String path = request.getRequestPathInfo().getResourcePath();
		Map<String, Boolean> parameters = getParameters(resolver, path);
		this.fields = getReturnedFileds(parameters);
	}

	public String getQuery() {
		return query;
	}

	public Boolean getSortOrder() {
		return sortOrder;
	}
	

	public List<String> getFields() {
		return fields;
	}

	private List<String> getReturnedFileds(Map<String, Boolean> map) {
		List<String> fields = new ArrayList<String>();
		for (Entry<String, Boolean> enty : map.entrySet()) {
			String key = enty.getKey();
			if (ALLOWED_PARAMETERS.contains(key)) {
				if (enty.getValue()) {
					fields.add(key);
				}
			}
		}
		return fields;
	}

	private Map<String, Boolean> getParameters(ResourceResolver resolver,
			String path) {
		Map<String, Boolean> map = new HashMap<>();
		Resource resource = resolver.resolve(path);
		ValueMap valueMap = resource.adaptTo(ValueMap.class);
		for (String key : ALLOWED_PARAMETERS) {
			Boolean value = valueMap.get(key, Boolean.class);
			value = value != null ? value : false;
			map.put(key, value);
		}
		return map;
	}
}
