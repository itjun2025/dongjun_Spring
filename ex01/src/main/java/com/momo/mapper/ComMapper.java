package com.momo.mapper;

import java.util.List;

import com.momo.vo.ComBoardVO;

public interface ComMapper {

	public List<ComBoardVO> list();
	
	public int insert(ComBoardVO vo);
	
	public int delete(int bno);
	
	public ComBoardVO getOne(int bno);
	
	public int update(ComBoardVO vo);
	
	int insertSelectKey(ComBoardVO board);
	
	
	
	
}
