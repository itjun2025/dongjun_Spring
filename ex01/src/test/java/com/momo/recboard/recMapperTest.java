package com.momo.recboard;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.RecMapper;
import com.momo.recboard.recMapperTest;
import com.momo.vo.ComBoardVO;
import com.momo.vo.RecBoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class recMapperTest {

	@Autowired
	RecMapper mapper;
	
	@Test
	public void getlist() {
		List<RecBoardVO> list = mapper.getlist();
		list.forEach(board -> {
			log.info("RecBoardVO============");
			log.info(board.getB_NO());
			log.info(board.getTitle());
			log.info(board.getNickName());
			log.info(board.getRegdate());
			log.info(board.getUpdatedate());
			log.info(board.getBoomup());
			log.info(board.getIntro());
			log.info(board.getCookTip());
			log.info(board.getViewCnt());
			log.info(board.getStar());
			log.info(board.getC_NO());
			log.info(board.getMno());
			
		});	
		
	}
	
	@Test
	public void insert() {
		
		RecBoardVO vo = new RecBoardVO();
		vo.setB_NO(2);
		vo.setTitle("떡볶이");
		vo.setNickName("떡볶아줌마");
		vo.setRegdate("2023-07-26");
		vo.setUpdatedate("2023-07-28");
		vo.setBoomup(2);
		vo.setIntro("매우맛있는 떡볶이에요 한번 만들어보세요");
		vo.setCookTip("떡은 미리 물에 불려놔주세요!!");
		vo.setViewCnt(0);
		vo.setStar(0);
		vo.setC_NO(0);
		vo.setMno(1);
		
		int res = mapper.insert(vo);
		assertEquals(1, res);
	}
}
