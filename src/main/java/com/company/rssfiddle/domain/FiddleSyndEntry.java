package com.company.rssfiddle.domain;

import org.springframework.stereotype.Component;

import com.sun.syndication.feed.synd.SyndEntryImpl;

@Component
public class FiddleSyndEntry extends SyndEntryImpl {

	
	private static final long serialVersionUID = -3588804539928938771L;
	private String provider;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	
	
	
}
