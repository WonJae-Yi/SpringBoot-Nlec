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
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<NoticeView> getViewList(int frNo, int toNo, String field, String query, String pub) {
		NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		return noticeDao.getViewList(frNo, toNo, field, query, pub);
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NoticeView getViewDetail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getNext(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getPrev(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePubAll(int[] pubIds, boolean pub) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
