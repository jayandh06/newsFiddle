package com.company.rssfiddle.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/theme/**")
		    .addResourceLocations("classpath:/theme/");
		  registry.addResourceHandler("/css/**")
		    .addResourceLocations("/css/");
		  registry.addResourceHandler("/img/**")
		    .addResourceLocations("/img/");
		  registry.addResourceHandler("/js/**")
		    .addResourceLocations("/js/");
		}
}
