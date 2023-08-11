package com.momo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.mapper.RecMatMapper;
import com.momo.vo.RecMatVO;

@Service
public class RecMatServiceImpl implements RecMatService{

	@Autowired
	RecMatMapper mapper;
	
	@Override
	public int insert(RecMatVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}

	
}
