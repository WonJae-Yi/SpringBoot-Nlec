package com.yiwon.web.dao.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yiwon.web.dao.NoticeDao;
import com.yiwon.web.entity.NoticeView;

@SpringBootTest
class MybatisNoticeDaoTest {
	
	@Autowired
	private NoticeDao noticeDao;
	

	@Test
	void test() {
		List<NoticeView> list = noticeDao.getViewList(1, 1, "title", " ","0");
		

		System.out.println("YIWON TEST: " + list.get(0));
	}

}
