package com.yiwon.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yiwon.web.dao.MemberDao;
import com.yiwon.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao{
	
	private MemberDao mapper;
	
	@Autowired
	public MybatisMemberDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(MemberDao.class);		
	}

	
	@Override
	public int insert(Member member) {
		
		return mapper.insert(member);
	};
	
	@Override
	public int login(Member member) {
		
		return mapper.login(member);
	};
	
	@Override
	public int idChk(String id) {
		
		return mapper.idChk(id);
	};
	

}
