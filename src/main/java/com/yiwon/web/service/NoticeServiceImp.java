package com.yiwon.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiwon.web.dao.NoticeDao;
import com.yiwon.web.entity.Notice;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> getList() {
		List<Notice> list = noticeDao.getList();
		return list;
	}

	@Override
	public Notice getDetail(int id) {
		Notice notice = noticeDao.getDetail(id);
		return notice;
	}

}
