package com.jay.news.fiddle.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sun.syndication.feed.synd.SyndEntryImpl;

public class SyndEntrySerializer implements JsonSerializer<SyndEntryImpl> {

	@Override
	public JsonElement serialize(SyndEntryImpl syndEntry, Type type,
			JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("title", syndEntry.getTitle());
		jsonObject.addProperty("uri", syndEntry.getUri());
		jsonObject.addProperty("link", syndEntry.getLink());
		jsonObject.addProperty("description", syndEntry.getDescription()
				.getValue());
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if (syndEntry.getPublishedDate() != null) {
			jsonObject.addProperty("updateDate",
					df.format(syndEntry.getPublishedDate()));
		}
		jsonObject.addProperty("Author", syndEntry.getAuthor());
		return jsonObject;
	}
}
