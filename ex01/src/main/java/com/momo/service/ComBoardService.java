package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.momo.vo.ComBoardVO;
import com.momo.vo.Criteria;
import com.momo.vo.RecBoardVO;

@Service
public interface ComBoardService {

	public List<ComBoardVO> getlist( Model model);
	
	public int insert(ComBoardVO vo);
	
	public int delete(int bno);
	
	public ComBoardVO getOne(int bno);
	
	public int update(ComBoardVO comboard , List<MultipartFile> photos) 
			throws Exception;
	
	public int insertSelectKey(ComBoardVO comboard, List<MultipartFile> photos) 
			throws Exception;
			
	
}
