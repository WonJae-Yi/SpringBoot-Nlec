package com.yiwon.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class noticeController {
	
	@RequestMapping("list") //url mapping
	public String list(Model model) {
		
		model.addAttribute("test", "Hello~Devsssss");
		
		return "admin/board/notice/list"; 
	}
	
	@RequestMapping("detail") 
	public String detail() {
		
		return "admin/board/notice/detail";
	}
	
	@RequestMapping("reg")
	public String reg() {
		
		return "admin/board/notice/reg";
	}


}
