package com.yiwon.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yiwon.web.entity.Notice;
import com.yiwon.web.entity.NoticeView;

public interface NoticeDao {


	List<NoticeView> getViewList(int frNo, int toNo, String field, String query, String pub);	
	int getCount(String field, String query, String pub);	
	NoticeView getViewDetail(int id);

	Notice getNext(int id);
	Notice getPrev(int id);

	int update(Notice notice);
	int addHit(Notice notice);
	int insert(Notice notice);
	int delete(int id);
	
	int deleteAll(int[] ids);
	//int updatePubAll(int[] pubIds, int[] closeIds);	
	int updatePubAll(int[] pubIds, String pub);	


}
