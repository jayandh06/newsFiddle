package com.company.rssfiddle.util;

import java.lang.reflect.Type;

import com.company.rssfiddle.domain.UserProfile;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class UserProfileSerializer implements JsonSerializer<UserProfile> {

	@Override
	public JsonElement serialize(UserProfile userprofile, Type type,
			JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userId", userprofile.getUserId());
		jsonObject.addProperty("firstName", userprofile.getFirstName());
		jsonObject.addProperty("middleName", userprofile.getMiddleName());
		jsonObject.addProperty("lastName", userprofile.getLastName());
		jsonObject.addProperty("zipCode", userprofile.getZipCode());
		jsonObject.addProperty("emailId", userprofile.getEmailId());
		jsonObject.addProperty("countryId",userprofile.getCountryId());
		jsonObject.addProperty("gender",userprofile.getGender());
		return jsonObject;
	}

}
