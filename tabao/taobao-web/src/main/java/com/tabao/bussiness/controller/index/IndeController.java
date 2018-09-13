package com.tabao.bussiness.controller.index;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndeController {
	
	@RequestMapping("/index")
	public String index() {
		return "hello world";
	}
	
}
