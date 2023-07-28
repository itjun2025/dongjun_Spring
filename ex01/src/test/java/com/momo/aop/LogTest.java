package com.momo.aop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.board.boardTest;
import com.momo.mapper.LogMapper;
import com.momo.vo.BoardVO;
import com.momo.vo.LogVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LogTest {
	
	@Autowired
	LogMapper logMapper;
	
	@Test
	public void test() {
		LogVO logVO = new LogVO();
		logVO.setClassname("클래스22");
		logVO.setMethodname("asfasdfsd");
		logVO.setParams("파람");
		logVO.setErrmsg("메세지");
		
		
		int res = logMapper.insert(logVO);
		
		System.out.println("res : " +res);
		assertEquals(res, 1);
		
		
		
}
	
}
