package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.momo.vo.BookVO;
import com.momo.vo.Criteria;

@Service
public interface BookService {

	public List<BookVO> getList(Criteria cri, Model model);
	
	public BookVO getOne(int no, Model model);
		
	
}
