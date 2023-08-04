package com.momo.recboard;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.service.CateService;
import com.momo.vo.CategoryVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class cateServiceTest {

	
	@Autowired
	CateService service;
	
	@Test
	public void getlist() {
		List<CategoryVO> list = service.getlist();
		list.forEach(board -> {
			log.info("CategoryVO============");
			log.info(board.getC_NO());
			log.info(board.getBigcate());
			log.info(board.getMidcate());
			log.info(board.getSmcate());
			
			
		});	
		
	}
	
	@Test
	public void insert() {
		
		CategoryVO vo = new CategoryVO();
		vo.setC_NO(2);
		vo.setBigcate("대분류2");
		vo.setMidcate("중분류2");
		vo.setSmcate("소분류2");
		
		
		int res = service.insert(vo);
		assertEquals(1, res);
	}
}
