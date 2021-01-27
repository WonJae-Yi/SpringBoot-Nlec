package com.yiwon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //나는 콘터롤러 입니다.
public class HomeController {
	
	@RequestMapping("/index") //url mapping
	public String index() {
		
		return "home.index";
	}
	@RequestMapping("/help") //url mapping
	public String help() {
		
		return "home.help";
	}

}
