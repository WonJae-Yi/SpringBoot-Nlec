package com.yiwon.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;
import com.yiwon.web.service.NoticeService;

//@RestController  //반환하는 모든것들을 문자열로 반환한다. 
@Controller  //jps같은 view page를 반환할 경우 사용
@RequestMapping("/customer/notice/") //url mapping
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list") //url mapping
	public String list(Model model) {
		
		int page = 2;
		String field = "title";
		String query = "";
		String pub = "0";
		
		List<NoticeView> list = service.getViewList(page, field, query, pub);
		
		model.addAttribute("list", list);
		
//		return "customer/notice/list";  //ResourceViewResolver, 매핑주소와 동일한 부분은 생략가능
		return "customer.notice.list";  //TilesViewResolver
	}
	
	@RequestMapping("detail") //url mapping
	public String detail() {
		
		return "customer.notice.detail";
	}

}
