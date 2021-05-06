package com.yiwon.web.controller.admin.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;
import com.yiwon.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//@RequestMapping("list") //url mapping
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(@RequestParam Map<String, String> param,	Model model) {
		
		String field_ = param.get("f");
		String query_ = param.get("q");
		String page_ = param.get("p");

		
		System.out.println("GET:" + field_);
		
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

		String pub = "0";

		List<NoticeView> list = service.getViewList(page, field, query, pub);

		model.addAttribute("list", list);
				
		 // 전체 건수 가져오기 
		int count = service.getCount(field, query, pub);
		model.addAttribute("count", count);	
		
		return "admin.board.notice.list"; 
	}
	
	@PostMapping(value="/list")
	public String list(@RequestParam(value="open-id") List<String> openIds,
						@RequestParam("cmd") String cmd,
						@RequestParam("ids") String ids_,
						Model model) {
		
		System.out.println("POST:" + cmd);

		ids_ = ids_.trim(); //앞뒤 공백제거
		String[] ids = ids_.split(" "); //공백을 기준으로 배열로 변황
		
		int result = 0;
		
		switch (cmd) {
		case "일괄공개":
			
			for(int i =0; i < ids.length; i++) {
				System.out.println("i=" + ids[i]);
			}
			//result = service.updatePubAll(ids, openIds);
			break;
			
		case "일괄삭제":
			//result = service.deleteAll(delIds);
			break;
		}
		
		return "redirect:list";
	}
	
	@RequestMapping("detail")
	public String detail(int id, Model model) {

		Notice notice = service.getViewDetail(id);		
		model.addAttribute("n", notice);
				 
		// 이전글 
		Notice preNotice = service.getPrev(id);
		model.addAttribute("prevn", preNotice);
		  
		// 다음글 
		Notice nextNotice = service.getNext(id);
		model.addAttribute("nextn", nextNotice);
				 			
		
		return "admin.board.notice.detail";
	}
	
	@GetMapping("reg")
	public String reg( ) {
		
		return "admin.board.notice.reg";  //forward 방식
	}
	
	@RequestMapping("reg")
	public String reg(@RequestParam Map<String, String> param,	Model model) {
		

		String title = param.get("title");
		String content = param.get("content");
		String isOpen = param.get("open");  //체크되었을때만 true가 넘어옴
		String pub = "0";
		if(isOpen != null)			
			pub = "1";	
				
//		//파일등록 
//		Collection<Part> parts = param.getParts(); 
//		StringBuilder builder =	new StringBuilder();
//		  
//		for(Part p : parts) {
//		  
//			  if(!p.getName().equals("file")) continue; 
//			  if(p.getSize() == 0) continue;
//			  
//			  Part filePart = p; 
//			  String fileName = filePart.getSubmittedFileName();
//			  builder.append(fileName); 
//			  builder.append(","); 
//			  InputStream fis = filePart.getInputStream();			  
//			  String realPath = request.getServletContext().getRealPath("/upload");			  
//			  
//			  //동일한  파일명이 존재한다면 
//			  String filePath = realPath + File.separator + fileName;
//			  
//			  //System.out.println(filePath); 
//			  File path = new File(realPath);
//			  if(!path.exists()) path.mkdirs();
//			  			  
//			  FileOutputStream fos = new FileOutputStream(filePath);
//			  
//			  byte[] buf = new byte[1024]; 
//			  int size = 0; 
//			  while((size = fis.read(buf)) != -1) 
//				  fos.write(buf,0,size);
//			  
//			  fos.close(); 
//			  fis.close();
//			  
//		  }
//		  
//		builder.delete(builder.length() - 1, builder.length()); //마지막 콤마 자르기
//		 		

		int result = 0;
		
		Notice notice = new Notice();
		
		notice.setTitle(title);
		notice.setContent(content);
		notice.setPub(pub);
		notice.setWriterid("yiwon");
//		notice.setFiles(builder.toString());

		result = service.insert(notice);			
		
//		return "admin.board.notice.list";
		return "redirect:list";
	}


}
