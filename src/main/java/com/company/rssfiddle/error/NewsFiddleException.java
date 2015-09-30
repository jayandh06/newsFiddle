package com.company.rssfiddle.error;

import org.apache.log4j.Logger;

public class NewsFiddleException extends  Throwable{
	
	
	private static final long serialVersionUID = -4877141457153275316L;
	
	private static Logger log = Logger.getLogger(NewsFiddleException.class); 
	public NewsFiddleException(String message, Exception e){
		
		super(message,e);
		log.debug(message);
	}
}
