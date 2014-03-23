package com.company.rssfiddle.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.rssfiddle.domain.CategoryDetail;
import com.company.rssfiddle.service.CategoryDetailService;
import com.company.rssfiddle.service.ReaderService;
import com.company.rssfiddle.util.SyndEntrySerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;

@Controller
@RequestMapping("/synd")
public class SyndController {

	private static final Logger log = Logger.getLogger(SyndController.class);
	@Autowired
	ReaderService readerService;
	

	@Autowired
	CategoryDetailService categoryDetailService;

	@RequestMapping("/feeds")
	public String showNews() {
		return "feeds";
	}

	@RequestMapping("/feeds/{categoryDetailId}")
	@ResponseBody
	public String getHotNews(@PathVariable String categoryDetailId) {

		CategoryDetail catDetail;
		List<SyndEntry> entries = new ArrayList<SyndEntry>();

		catDetail = categoryDetailService.getDetailById(new Integer(
				categoryDetailId));

		URL url = null;
		StringBuilder responseString = new StringBuilder();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson;

		try {
			url = new URL(catDetail.getRssUrl());
			entries.addAll(readerService.getFeeds(url, catDetail));
			gsonBuilder.registerTypeAdapter(SyndEntryImpl.class,
					new SyndEntrySerializer(catDetail.getCompany()));
			gsonBuilder.setPrettyPrinting();
			gson = gsonBuilder.create();
			responseString.append(gson.toJson(entries
					.toArray(new SyndEntryImpl[0])));
		} catch (MalformedURLException e) {
			log.error("Invalid URL Exception");
		}

		return responseString.toString();

	}
}
