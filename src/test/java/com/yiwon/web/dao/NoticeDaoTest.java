package com.yiwon.web.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.yiwon.web.entity.NoticeView;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class NoticeDaoTest {
	
	@Autowired
	private NoticeDao noticeDao;

	@Test
	void test() {
		
		List<NoticeView> list = noticeDao.getViewList(1, 1, "title", " ","0");
		//int cnt = noticeDao.getCount("title", "");
		

		System.out.println("YIWON TEST: " + list.get(0));
	}

}
