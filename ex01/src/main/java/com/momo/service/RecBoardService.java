package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.momo.vo.BoardVO;
import com.momo.vo.RecBoardVO;

@Service
public interface RecBoardService {
	

	public List<RecBoardVO> getlist();
	
	public int insert(RecBoardVO vo);
	
	// public int insertSelectKey(RecBoardVO board);
	public int insertSelectKey(RecBoardVO board, List<MultipartFile> files) throws Exception;
	
	public int delete(int bno);
	
	public RecBoardVO getOne(int bno);
	
	public int update(RecBoardVO vo);

}
