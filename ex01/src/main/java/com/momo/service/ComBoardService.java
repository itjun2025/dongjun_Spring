package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.momo.vo.ComBoardVO;

@Service
public interface ComBoardService {

	public List<ComBoardVO> getlist();
	
	public int insert(ComBoardVO vo);
	
	public int delete(int bno);
	
	public ComBoardVO getOne(int bno);
	
	public int update(ComBoardVO vo);
	
}
