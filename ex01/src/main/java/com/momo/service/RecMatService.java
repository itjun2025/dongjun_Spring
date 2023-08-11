package com.momo.service;

import org.springframework.stereotype.Service;

import com.momo.vo.RecMatVO;

@Service
public interface RecMatService {
	
	public int insert(RecMatVO vo);

}
