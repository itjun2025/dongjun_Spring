package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.momo.vo.CategoryVO;

@Service
public interface CateService {

public List<CategoryVO> getlist();
	
	public int insert(CategoryVO vo);
}
