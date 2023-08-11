package com.momo.recboard;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.CateMapper;
import com.momo.mapper.RecMatMapper;
import com.momo.mapper.RecStepMapper;
import com.momo.vo.CategoryVO;
import com.momo.vo.RecBoardVO;
import com.momo.vo.RecMatVO;
import com.momo.vo.RecStepVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class cateMapperTest {
	
	@Autowired
	CateMapper mapper;
	
	@Autowired
	RecStepMapper mapper2;
	
	@Autowired
	RecMatMapper mapper3;
	
	
	@Test
	public void insert2() {
		
		RecStepVO vo = new RecStepVO();
		vo.setStep_content("마늘2큰술넣습니다");
		int res = mapper2.insert(vo);
		assertEquals(1, res);
	}
	
	@Test
	public void insert3() {
		
		RecMatVO vo = new RecMatVO();
		vo.setMaterialCnt("2큰술");
		vo.setI_NAME("고춧가루");
		
		
		int res = mapper3.insert(vo);
		assertEquals(1, res);
	}


	
	
	
	
	
	
	
	
	@Test
	public void getlist() {
		List<CategoryVO> list = mapper.getlist();
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
		
		vo.setBigcate("대분류3");
		vo.setMidcate("중분류3");
		vo.setSmcate("소분류3");
		
		
		int res = mapper.insert(vo);
		assertEquals(1, res);
	}

}
