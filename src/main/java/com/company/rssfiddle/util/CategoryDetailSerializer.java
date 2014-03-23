package com.company.rssfiddle.util;

import java.lang.reflect.Type;

import com.company.rssfiddle.domain.CategoryDetail;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class CategoryDetailSerializer implements	JsonSerializer<CategoryDetail>{
	@Override
	public JsonElement serialize(CategoryDetail categoryDetail, Type type,
			JsonSerializationContext context) {	
		
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("categoryDetailId", categoryDetail.getCatDetailId());
		jsonObject.addProperty("providerUrl", categoryDetail.getCompanyUrl());
		jsonObject.addProperty("providerName", categoryDetail.getCompany());
		jsonObject.addProperty("rssUrl", categoryDetail.getRssUrl());
		jsonObject.addProperty("categoryId", categoryDetail.getCategory().getCategoryId());
		jsonObject.addProperty("categoryName",categoryDetail.getCategory().getCategoryName());
		return jsonObject;
	}
	
}
