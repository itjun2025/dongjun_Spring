package com.momo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.momo.vo.BookVO;
import com.momo.vo.Criteria;

public interface BookMapper {

	
	
	public List<BookVO> getList(Criteria cri);
	
	

	public int getTotalCnt(Criteria cri);
	
	public BookVO getOne(int no);
}
