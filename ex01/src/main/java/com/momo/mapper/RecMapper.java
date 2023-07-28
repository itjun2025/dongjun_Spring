package com.momo.mapper;

import java.util.List;

import com.momo.vo.RecBoardVO;

public interface RecMapper {
	
	public List<RecBoardVO> getlist();
	
	public int insert(RecBoardVO vo);
	
	public int delete(int bno);
	
	public RecBoardVO getOne(int bno);
	
	public int update(RecBoardVO vo);

}
