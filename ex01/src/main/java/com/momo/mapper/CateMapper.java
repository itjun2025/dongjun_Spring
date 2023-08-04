package com.momo.mapper;

import java.util.List;

import com.momo.vo.CategoryVO;

public interface CateMapper {

	public List<CategoryVO> getlist();
	
	public int insert(CategoryVO vo);
}
