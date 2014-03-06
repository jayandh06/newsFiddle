package com.jay.news.fiddle.util;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jay.news.fiddle.domain.Category;

public class CategorySerializer implements	JsonSerializer<Category>{
	@Override
	public JsonElement serialize(Category category, Type type,
			JsonSerializationContext context) {	
		
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("categoryName", category.getCategoryName());
		jsonObject.addProperty("categoryId", category.getCategoryId());
		
		return jsonObject;
	}
	
}
