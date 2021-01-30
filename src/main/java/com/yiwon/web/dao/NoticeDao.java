package com.yiwon.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yiwon.web.entity.Notice;

@Mapper
public interface NoticeDao {

	@Select("select * from notice")
	List<Notice> getList();

	Notice getDetail(int id);

}
