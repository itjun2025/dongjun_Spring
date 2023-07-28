package com.momo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.momo.mapper.BookMapper;
import com.momo.vo.BookVO;
import com.momo.vo.Criteria;
import com.momo.vo.pageDto;

import lombok.extern.log4j.Log4j;


@Service
@Log4j
public class BookServiceImp implements BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<BookVO> getList(Criteria cri, Model model){
		
		
		
		/*
		 * 1. 리스트 조회
		 * 2. 총건수 조회
		 * 3. 페이지 블럭을 생성(페이지DTO생성)
		 * */
		
		// return bookMapper.getList(cri);
		
		List<BookVO> list = bookMapper.getList(cri);
		int totalCnt = bookMapper.getTotalCnt(cri);
		
		// 게시물의 총건수로 페이지 블럭을 생성
		pageDto pageDto = new pageDto(cri,totalCnt);
		
		model.addAttribute("list",list);
		model.addAttribute("pageDto",pageDto);
		log.info("pageDto : "+ pageDto);
		
		return null;
		
		
	}

	@Override
	public BookVO getOne(int no, Model model) {
		BookVO book = bookMapper.getOne(no);
		model.addAttribute("book",book);
		return book;
	}

	
	
	
}
