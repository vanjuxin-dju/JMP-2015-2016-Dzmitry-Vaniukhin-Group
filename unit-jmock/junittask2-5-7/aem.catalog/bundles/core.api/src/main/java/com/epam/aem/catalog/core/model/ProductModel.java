package com.epam.aem.catalog.core.model;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables=Resource.class)
public class ProductModel {

	@Inject 
	@Named("jcr:title")
	private String name;

	@Inject 
	@Optional
	@Named("jcr:description")
	private String description;

	@Inject
	@Optional
	private String imagePath;

	@Inject 
	private Integer count;

	@Inject
	@Optional
	private String[] tags;

	public Integer getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public List<String> getTags() {
		return Arrays.asList(tags);
	}
}
