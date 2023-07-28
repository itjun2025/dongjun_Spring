package com.momo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.mapper.ComMapper;
import com.momo.vo.ComBoardVO;

@Service
public class ComBoardServiceImpl implements ComBoardService {

	@Autowired
	ComMapper commapper;
	
	@Override
	public List<ComBoardVO> getlist() {
		return commapper.list();
	}

	@Override
	public int insert(ComBoardVO vo) {
		
		return commapper.insert(vo);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return commapper.delete(bno);
	}

	@Override
	public ComBoardVO getOne(int bno) {
		// TODO Auto-generated method stub
		return commapper.getOne(bno);
	}

	@Override
	public int update(ComBoardVO vo) {
		// TODO Auto-generated method stub
		return commapper.update(vo);
	}

	
}
