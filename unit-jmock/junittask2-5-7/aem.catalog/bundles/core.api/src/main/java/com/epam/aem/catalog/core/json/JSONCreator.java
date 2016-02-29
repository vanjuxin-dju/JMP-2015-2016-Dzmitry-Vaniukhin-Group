package com.epam.aem.catalog.core.json;

import java.util.List;

public interface JSONCreator<T> {
	String createJSON(T object, List<String> allowedField);
}
