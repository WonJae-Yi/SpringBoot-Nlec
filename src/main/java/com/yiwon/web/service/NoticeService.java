package com.yiwon.web.service;

import java.util.List;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;

public interface NoticeService {

	//기본 페이지를 요청할 때
	List<NoticeView> getViewList();
	//검색을 요청할때
	List<NoticeView> getViewList(String field, String query);
	//페이지를 요청할때
	List<NoticeView> getViewList(int page, String field, String query, String pub);
	
	int getCount();
	int getCount(String field, String query);
	
	//자세한 페이지 요청할 때
	NoticeView getViewDetail(int id);
	
	Notice getNext(int id);
	Notice getPrev(int id);

	//일괄공개를 요청할 떼
	int updatePubAll(int[] pibIds, int[] closeIds);
	//일괄삭제를 요청할 때
	int deleteAll(int[] ids);
	
	int update(Notice notice);
	int delete(int id);
	int insert(Notice notice);

}
