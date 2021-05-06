package com.yiwon.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiwon.web.dao.MemberDao;
import com.yiwon.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public int insert(Member member) {
		
		return memberDao.insert(member);
	}
	@Override
	public int login(Member member) {
		
		return memberDao.login(member);
	}
	@Override
	public int idChk(String id) {
		
		return memberDao.idChk(id);
	}

}
