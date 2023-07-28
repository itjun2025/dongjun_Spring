package com.momo.comboard;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.board.boardTest;
import com.momo.mapper.ComMapper;
import com.momo.vo.BoardVO;
import com.momo.vo.ComBoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class mappertest {

	@Autowired
	ComMapper commapper;
	
	@Test
	public void getList() {
		List<ComBoardVO> list = commapper.list();
		list.forEach(board -> {
			log.info("ComboardVO============");
			log.info(board.getCom_bno());
			log.info(board.getNickname());
			log.info(board.getCom_title());
			log.info(board.getCom_content());
			log.info(board.getRegdate() );
			log.info(board.getUpdate_date() );
			log.info(board.getReplycnt() );
			log.info(board.getMno() );
		});	
	}
	
	@Test
	public void insert() {
	    ComBoardVO vo = new ComBoardVO();
	    vo.setCom_bno(2);
	    vo.setCom_content("내용2");
	    vo.setCom_title("제목2");
	    vo.setNickname("닉네임2");
	    vo.setMno(1);
	    vo.setRegdate("2023-07-27"); // "YYYY-MM-DD" 형식으로 설정
	    vo.setUpdate_date("2024-07-27"); // "YYYY-MM-DD" 형식으로 설정
	    vo.setReplycnt(13); // 숫자로 설정

	    int res = commapper.insert(vo);
	    assertEquals(1, res);
	}
	
	
	@Test
	public void delete() {
		int res = commapper.delete(1);
		assertEquals(1, res);
	}
	
	@Test
	public void getOne() {
		
		ComBoardVO board = commapper.getOne(11);
		System.out.println("=====================");
		log.info(board);
		
	}
	
	
	@Test
	public void update() {
		int bno = 11;
		ComBoardVO vo = new ComBoardVO();
		vo.setCom_bno(bno);
		vo.setCom_content("내용2/1");
	    vo.setCom_title("제목 수정수정수정");
	    vo.setNickname("닉네임2/1");
	    vo.setMno(1);
	    vo.setRegdate("2023-07-28"); // "YYYY-MM-DD" 형식으로 설정
	   
	    vo.setReplycnt(30); // 숫자로 설정
	    
	    int res = commapper.update(vo);
	    
	    ComBoardVO getboard = commapper.getOne(bno);
	    
	    assertEquals("제목 수정수정수정", getboard.getCom_title());
	}
	
}
