package com.jay.news.fiddle.domain;

import org.springframework.stereotype.Component;

import com.sun.syndication.feed.synd.SyndEntryImpl;

@Component
public class FiddleSyndEntry extends SyndEntryImpl {

	private String provider;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	
	
}
