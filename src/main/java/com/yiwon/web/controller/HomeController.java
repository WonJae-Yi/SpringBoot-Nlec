package com.yiwon.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //나는 콘터롤러 입니다.
public class HomeController {
	
	@RequestMapping("/index") //url mapping
	public String abc() {
		
		return "Hellow Spring bots";
	}

}
