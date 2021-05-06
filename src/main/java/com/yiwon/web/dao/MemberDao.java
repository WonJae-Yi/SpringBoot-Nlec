package com.yiwon.web.dao;

import com.yiwon.web.entity.Member;

public interface MemberDao {
	
	int insert(Member member);

	int login(Member member);
	
	int idChk(String id);

}
