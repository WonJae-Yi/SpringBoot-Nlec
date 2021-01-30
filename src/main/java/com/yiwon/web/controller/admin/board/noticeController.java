package com.yiwon.web.controller.admin.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class noticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list") //url mapping
	public String list() {
		
		List<Notice> list = service.getList();
		
		return "admin.board.notice.list"; 
	}
	
	@RequestMapping("detail") 
	public String detail() {
		
		Notice notice = service.getDetail(1);
		
		return "admin.board.notice.detail";
	}
	
	@RequestMapping("reg")
	public String reg() {
		
		return "admin.board.notice.reg";
	}


}
