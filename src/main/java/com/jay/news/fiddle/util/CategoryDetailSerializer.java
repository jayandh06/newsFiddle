package com.jay.news.fiddle.util;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jay.news.fiddle.domain.CategoryDetail;

public class CategoryDetailSerializer implements	JsonSerializer<CategoryDetail>{
	@Override
	public JsonElement serialize(CategoryDetail categoryDetail, Type type,
			JsonSerializationContext context) {	
		
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("companyUrl", categoryDetail.getCompanyUrl());
		jsonObject.addProperty("companyName", categoryDetail.getCompany());
		jsonObject.addProperty("rssUrl", categoryDetail.getRssUrl());
		jsonObject.addProperty("categoryId", categoryDetail.getCategory().getCategoryId());

		return jsonObject;
	}
	
}
