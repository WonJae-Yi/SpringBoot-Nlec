package com.yiwon.web.service;

import com.yiwon.web.entity.Member;

public interface MemberService {
	
	int insert(Member member);
	
	int login(Member member);
	int idChk(String id);

}
