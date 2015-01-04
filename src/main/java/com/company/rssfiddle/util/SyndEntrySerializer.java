package com.company.rssfiddle.util;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sun.syndication.feed.synd.SyndEntryImpl;

public class SyndEntrySerializer implements JsonSerializer<SyndEntryImpl> {

	String providerName;
	public SyndEntrySerializer(String providerName){
		this.providerName = providerName;
	}
	
	@Override
	public JsonElement serialize(SyndEntryImpl syndEntry, Type type,
			JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("provider", providerName);
		jsonObject.addProperty("title", syndEntry.getTitle());
		jsonObject.addProperty("uri", syndEntry.getUri());
		jsonObject.addProperty("link", syndEntry.getLink());
		if (syndEntry.getDescription() != null) {
			jsonObject.addProperty("description", syndEntry.getDescription()
					.getValue());
		}
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		if (syndEntry.getPublishedDate() != null) {
			jsonObject.addProperty("updateDate",
					df.format(syndEntry.getPublishedDate()));			
		}
		else{
			if(syndEntry.getUpdatedDate() != null){
				jsonObject.addProperty("updateDate",
						df.format(syndEntry.getUpdatedDate()));
			}
		}
		jsonObject.addProperty("Author", syndEntry.getAuthor());
		return jsonObject;
	}
}
