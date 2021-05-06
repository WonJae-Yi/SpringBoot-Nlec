package com.yiwon.web.controller.member;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiwon.web.entity.Member;
import com.yiwon.web.service.MemberService;

@Controller // jps같은 view page를 반환할 경우 사용
@RequestMapping("/member/") 
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("agree") 
	public String agree() {
		System.out.println("GET:agree");
		
		return "member.agree";
	}
	@PostMapping("agree")
	public String agree2() {
		System.out.println("POST:agree");
		return "redirect:join";
	}

	@GetMapping("join") 
	public String join() {
		System.out.println("GET:join");
		
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(@RequestParam Map<String, String> param, Model model) {
		System.out.println("POST:join");
		

		String id = param.get("id");
		String pwd = param.get("pwd");
		String pwd2 = param.get("pwd2");
		String name = param.get("name");
		String gender = param.get("gender");
		String birthday = param.get("birthday");
		String isLunar = param.get("isLunar");		
		String phone = param.get("phone");
		String email = param.get("email");
		
		Member member = new Member();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setGender(gender);
		member.setBirthday(birthday);
		member.setPhone(phone);
		member.setEmail(email);
		
		int result = 0;
		result = service.insert(member);	
		
		return "redirect:confirm";
	}
	
	@GetMapping("confirm") 
	public String confirm() {
		System.out.println("GET:confirm");
		return "member.confirm";
	}
	
	@PostMapping("confirm") 
	public String confirm2() {
		System.out.println("POST:confirm");
		return "redirect:login";
	}	
	
	@GetMapping("login") 
	public String login() {
		System.out.println("GET:login");
		return "member.login";
	}
	
	@PostMapping("login")
	public String login(@RequestParam Map<String, String> param, Model model) {
		System.out.println("POST:login");
		
		String username = param.get("username");
		String password = param.get("password");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		
		int result = 0;
		
		Member member = new Member();
		
		member.setId(username);
		member.setPwd(password);
		result = service.login(member);
		
		String setView;
		if (result == 1) {
			setView = "redirect:home";
		} else {
			setView = "member.login";
		}
		
		return setView;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/idchk", produces="text/plane")
	public int idchk(@RequestBody String paramData) throws ParseException {
		System.out.println("POST:idchk");
		//클라이언트가 보낸 ID값
		String id = paramData.trim();
		System.out.println(id);
		int result = 0;
		
		result = service.idChk(id);
		
		if(result == 1) {//결과 값이 있으면 아이디 존재	
			System.out.println("중복");
		} else {		//없으면 아이디 존재 X
			System.out.println("가능");
		}
		return result;
	}
}
