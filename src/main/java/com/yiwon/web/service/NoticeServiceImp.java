package com.yiwon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiwon.web.dao.NoticeDao;
import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	

	@Override
	public NoticeView getViewDetail(int id) {
		
		NoticeView notice = noticeDao.getViewDetail(id);
		noticeDao.addHit(notice);
		return notice;
	}

	@Override
	public List<NoticeView> getViewList(String pub) {
		// TODO Auto-generated method stub
		return getViewList(1,"title","",pub);
	}

	@Override
	public List<NoticeView> getViewList(String field, String query, String pub) {
	
		return getViewList(1, field, query, "0");
	}
	
	@Override
	public List<NoticeView> getViewList(int page, String field, String query, String pub) {
		int frNo = 1 + (page - 1) * 10;
		int toNo = page * 10;
		
		System.out.println("NoticeService getViewList :" + query);
		List<NoticeView> list = noticeDao.getViewList(frNo, toNo, field, query, pub);
		return list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return getCount("title","","1");
	}

	@Override
	public int getCount(String field, String query, String pub) {
		System.out.println("NoticeService getCount pub:" + pub);
		// TODO Auto-generated method stub
		return noticeDao.getCount(field,query,pub);
	}


	@Override
	public Notice getNext(int id) {
		
		return noticeDao.getNext(id);
	}

	@Override
	public Notice getPrev(int id) {
		
		return noticeDao.getPrev(id);
	}

	@Override
	public int updatePubAll(int[] pubIds, int[] closeIds) {
		int result = 0;
		result += noticeDao.updatePubAll(pubIds, "1");
		result += noticeDao.updatePubAll(closeIds, "0");
		
		return result;
	}

	@Override
	public int deleteAll(int[] ids) {
		
		return noticeDao.deleteAll(ids);
	}

	@Override
	public int update(Notice notice) {
		
		return noticeDao.update(notice);
	}
	
	@Override
	public int delete(int id) {
		
		return noticeDao.delete(id);
	}
	
	@Override
	public int insert(Notice notice) {
		
		return noticeDao.insert(notice);
	}
}
