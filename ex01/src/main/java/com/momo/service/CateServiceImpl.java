package com.momo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.mapper.CateMapper;
import com.momo.vo.CategoryVO;

@Service
public class CateServiceImpl implements CateService {

	@Autowired
	CateMapper mapper;
	
	@Override
	public List<CategoryVO> getlist() {
		
		return mapper.getlist();
	}

	@Override
	public int insert(CategoryVO vo) {

		return mapper.insert(vo);
	}

	
}
