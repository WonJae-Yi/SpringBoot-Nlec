package com.yiwon.web.service;

import java.util.List;

import com.yiwon.web.entity.Notice;

public interface NoticeService {

	List<Notice> getList();

	Notice getDetail(int id);

}
