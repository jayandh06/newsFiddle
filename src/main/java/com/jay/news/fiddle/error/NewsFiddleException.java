package com.jay.news.fiddle.error;

import org.apache.log4j.Logger;

public class NewsFiddleException extends  Throwable{
	
	private static Logger log = Logger.getLogger(NewsFiddleException.class); 
	public NewsFiddleException(String message, Exception e){
		super(message,e);
	}
}
