package com.momo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.momo.mapper.RecMapper;
import com.momo.vo.BoardVO;
import com.momo.vo.RecBoardVO;

@Service
public class RecBoardServiceImpl implements RecBoardService {

	@Autowired
	RecMapper recMapper;
	
	@Autowired
	Fileuploadservice fileuploadService;

	@Override
	public List<RecBoardVO> getlist() {
		// TODO Auto-generated method stub
		return recMapper.getlist();
	}

	@Override
	public int insert(RecBoardVO vo) {
		// TODO Auto-generated method stub
		return recMapper.insert(vo);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return recMapper.delete(bno);
	}

	@Override
	public RecBoardVO getOne(int bno) {
		// TODO Auto-generated method stub
		return recMapper.getOne(bno);
	}

	@Override
	public int update(RecBoardVO vo) {
		// TODO Auto-generated method stub
		return recMapper.update(vo);
	}

	

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertSelectKey(RecBoardVO board
								, List<MultipartFile> files) throws Exception {
		
		// 게시물 등록
		int res = recMapper.insertSelectKey(board);
		
		// 파일 첨부
		fileuploadService.fileupload(files, board.getB_NO());
		
		
		return res;
	}
	
	
}
