package com.company.rssfiddle.util;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
		
	
		@Resource
		private MailSender mailSender;
		
		@Resource
		private SimpleMailMessage simpleMailMessage;
	
		private static final Logger logger = Logger.getLogger(EmailUtil.class);
		
		public void sendSignupEmail(String toEmail) {
			simpleMailMessage.setFrom("r.jayandh@gmail.com");
			simpleMailMessage.setTo(toEmail);
			simpleMailMessage.setSubject("Welcome to RSS Fiddle -  Signup Confirmation");
			simpleMailMessage.setText("Hi, \n Welcome to RSS Fiddle");
			
			try {
				 mailSender.send(simpleMailMessage);
			}
			catch(MailException me) {
				logger.error("Error Sending email : " + me);
			}
		}
}
