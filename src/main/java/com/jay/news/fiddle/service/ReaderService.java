package com.jay.news.fiddle.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

@Service
public class ReaderService {

	private static final Logger log = Logger.getLogger(ReaderService.class);
	
	public List<SyndEntry> getFeeds(URL url) {
		List<SyndEntry> feeds = new ArrayList<SyndEntry>();
		XmlReader reader = null;
		SyndFeed feed = null;
		try {
			/*
			System.setProperty("http.proxyHost", "proxy-tw.bcbsmn.com");
			System.setProperty("http.proxyPort", "9119");
			System.setProperty("http.proxyUser", "a0c5zz");
			System.setProperty("http.proxyPassword", "test0810");
			*/
			reader = new XmlReader(url);
			
			feed = new SyndFeedInput().build(reader);
			feeds = feed.getEntries();
		} catch (IOException e) {
			log.error("Exception reading url");
		} catch (IllegalArgumentException e) {
			log.error("Exception reading url");
		} catch (FeedException e) {
			log.error("Exception reading feed");
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					log.error("Unable to close Feed XmlReader");
				}
		}
		return feeds;
	}

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://feeds.reuters.com/reuters/businessNews");
		XmlReader reader = null;

		try {

			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);
			System.out.println("Feed Title: " + feed.getAuthor());

			for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
				SyndEntry entry = (SyndEntry) i.next();
				System.out.println(entry.getTitle());
			}
		} finally {
			if (reader != null)
				reader.close();
		}
	}
}