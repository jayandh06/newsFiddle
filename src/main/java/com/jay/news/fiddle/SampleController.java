package com.jay.news.fiddle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String getName(@PathVariable String name){
		return "Hello " + name;
	}
}
