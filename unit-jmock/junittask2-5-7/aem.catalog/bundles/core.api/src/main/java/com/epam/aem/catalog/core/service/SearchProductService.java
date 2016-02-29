package com.epam.aem.catalog.core.service;

import java.util.List;

import com.epam.aem.catalog.core.model.ProductModel;
import com.epam.aem.catalog.core.model.ProductRequestModel;

public interface SearchProductService {
	
	List<ProductModel> returnProducts(ProductRequestModel model);

}
