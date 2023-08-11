package com.momo.mapper;

import java.util.List;

import com.momo.vo.RecFileVO;

public interface RecFileMapper {

	public List<RecFileVO> getList(int bno);
	
	public int insert(RecFileVO vo);
}
