package com.momo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momo.mapper.RecStepMapper;
import com.momo.vo.RecStepVO;

@Service
public class RecStepServiceImpl implements RecStepService{

	@Autowired
	RecStepMapper mapper;

	@Override
	public int insert(RecStepVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo);
	}
}
