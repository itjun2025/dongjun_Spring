package com.momo.service;

import org.springframework.stereotype.Service;

import com.momo.vo.RecStepVO;

@Service
public interface RecStepService {
	
	public int insert(RecStepVO vo);
}
