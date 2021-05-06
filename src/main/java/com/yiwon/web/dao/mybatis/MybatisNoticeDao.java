package com.yiwon.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yiwon.web.dao.NoticeDao;
import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;

@Repository
public class MybatisNoticeDao implements NoticeDao {

	private NoticeDao mapper;
	
	@Autowired
	public MybatisNoticeDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(NoticeDao.class);		
	}

	@Override
	public List<NoticeView> getViewList(int frNo, int toNo, String field, String query, String pub) {		
		return mapper.getViewList(frNo, toNo, field, query, pub);
	}

	@Override
	public int getCount(String field, String query, String pub) {
		
		return mapper.getCount(field, query, pub);
	}

	@Override
	public NoticeView getViewDetail(int id) {
		
		return mapper.getViewDetail(id);
	}

	@Override
	public Notice getNext(int id) {
		
		return mapper.getNext(id);
	}

	@Override
	public Notice getPrev(int id) {
		
		return mapper.getPrev(id);
	}

	@Override
	public int update(Notice notice) {
		
		return mapper.update(notice);
	}
	
	@Override
	public int addHit(Notice notice) {
		
		return mapper.addHit(notice);
	}

	@Override
	public int insert(Notice notice) {
		
		return mapper.insert(notice);
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
	}

	@Override
	public int deleteAll(int[] ids) {

		return mapper.deleteAll(ids);
	}

	@Override
	public int updatePubAll(int[] Ids, String pub) {
		
		return mapper.updatePubAll(Ids, pub);
	}
	
	

}
