package com.yiwon.web.controller.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;
import com.yiwon.web.service.NoticeService;

//@RestController  //반환하는 모든것들을 문자열로 반환한다. 
@Controller // jps같은 view page를 반환할 경우 사용
@RequestMapping("/customer/notice/") // url mapping
public class NoticeController {

	@Autowired
	private NoticeService service;

	@RequestMapping("list") // url mapping
	public String list(@RequestParam Map<String, String> param,	Model model) {
		
		String field_ = param.get("f");
		String query_ = param.get("q");
		String page_ = param.get("p");

		String field = "title";
		if (field_ != null && !field_.equals(""))
			field = field_;
		
		System.out.println("field:" + field);

		String query = "";
		if (query_ != null && !query_.equals(""))
			query = query_;
		System.out.println("query:" + query);

		int page = 1;
		if (page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);

		String pub = "1";

		List<NoticeView> list = service.getViewList(page, field, query, pub);

		model.addAttribute("list", list);
		

		
		 // 전체 건수 가져오기 
		int count = service.getCount(field, query, pub);
		model.addAttribute("count", count);

//		return "customer/notice/list";  //ResourceViewResolver, 매핑주소와 동일한 부분은 생략가능
		return "customer.notice.list"; // TilesViewResolver
	}

	@RequestMapping("detail")
	public String detail(Model model, int id) {

		Notice notice = service.getViewDetail(id);		
		model.addAttribute("n", notice);
				 
		// 이전글 
		Notice preNotice = service.getPrev(id);
		model.addAttribute("prevn", preNotice);
		  
		// 다음글 
		Notice nextNotice = service.getNext(id);
		model.addAttribute("nextn", nextNotice);
				 			

		return "customer.notice.detail";
	}

}
