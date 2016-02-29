package com.epam.aem.catalog.core.json.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import com.epam.aem.catalog.core.json.JSONCreator;
import com.epam.aem.catalog.core.model.ProductModel;

/*
 * build json for jQueryTable, with format  like next example
 * [{"name":"Hewlett-Packard","count":"100"},{"name":"Logitech","count":"12"}]
 */
@Service
@Component
public class TableProductJsonCreator implements
		JSONCreator<List<ProductModel>> {
	private static final String SEPARATOR = ":";
	private static final String NAME = "name";
	private static final String DESCTRIPTION = "description";
	private static final String COUNT = "count";
	private static final String TAGS = "tags";
	private static final String BRACE_START = "{";
	private static final String BRACE_END = "}";
	private static final String ARRAY_START = "[";
	private static final String ARRAY_END = "]";
	private static final String COMMA = ",";
	private static final String DOUBLE_QUOTES = "\"";

	@Override
	public String createJSON(List<ProductModel> object, List<String> allowedFields) {
		StringBuilder sb = new StringBuilder();
		sb.append(ARRAY_START);
		Iterator<ProductModel> iterator = object.iterator();
		while (iterator.hasNext()) {
			ProductModel product = iterator.next();
			buildProductJson(sb, allowedFields, product);
			if (iterator.hasNext()) {
				sb.append(COMMA);
			}
		}
		sb.append(ARRAY_END);
		return sb.toString();
	}

	private void buildProductJson(StringBuilder sb, List<String> allowedFields,
			ProductModel product) {
		Iterator<String> iterator = allowedFields.iterator();

		sb.append(BRACE_START);

		while (iterator.hasNext()) {

			switch (iterator.next()) {
			case NAME:
				sb.append(DOUBLE_QUOTES).append(NAME).append(DOUBLE_QUOTES)
						.append(SEPARATOR);
				sb.append(DOUBLE_QUOTES)
						.append(StringUtils.defaultString(product.getName(),
								StringUtils.EMPTY)).append(DOUBLE_QUOTES);
				break;
			case DESCTRIPTION:
				sb.append(DOUBLE_QUOTES).append(DESCTRIPTION)
						.append(DOUBLE_QUOTES).append(SEPARATOR);
				sb.append(DOUBLE_QUOTES)
						.append(StringUtils.defaultString(
								product.getDescription(), StringUtils.EMPTY))
						.append(DOUBLE_QUOTES);
				break;
			case COUNT:
				sb.append(DOUBLE_QUOTES).append(COUNT).append(DOUBLE_QUOTES)
						.append(SEPARATOR);
				sb.append(DOUBLE_QUOTES)
						.append(StringUtils.defaultString(product.getCount()
								.toString(), StringUtils.EMPTY))
						.append(DOUBLE_QUOTES);
				break;
			case TAGS:
				sb.append(DOUBLE_QUOTES).append(TAGS).append(DOUBLE_QUOTES)
						.append(SEPARATOR);
				sb.append(DOUBLE_QUOTES)
						.append(StringUtils.defaultString(product.getTags()
								.toString(), StringUtils.EMPTY))
						.append(DOUBLE_QUOTES);
				break;
			}
			if (iterator.hasNext()) {
				sb.append(COMMA);
			}
		}
		sb.append(BRACE_END);
	}
}
