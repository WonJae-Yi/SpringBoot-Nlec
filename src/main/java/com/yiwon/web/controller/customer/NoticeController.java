package com.yiwon.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController  //반환하는 모든것들을 문자열로 반환한다. 
@Controller  //jps같은 view page를 반환할 경우 사용
@RequestMapping("/customer/notice/") //url mapping
public class NoticeController {
	
	@RequestMapping("list") //url mapping
	public String list(Model model) {
		
		model.addAttribute("test", "Hello~Devsssss");
		
		return "customer/notice/list";  //매핑주소와 동일한 부분은 생략가능
	}
	
	@RequestMapping("detail") //url mapping
	public String detail() {
		
		return "customer/notice/detail";
	}

}
