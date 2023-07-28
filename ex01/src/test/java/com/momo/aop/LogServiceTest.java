package com.momo.aop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.aop.LogServiceTest;
import com.momo.service.LogService;
import com.momo.vo.LogVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LogServiceTest {

	@Autowired
	LogService logService;
	
	@Test
	public void test() {
		LogVO vo = new LogVO();
		vo.setClassname("11111");
		vo.setMethodname("1111111111");
		vo.setParams("1111111");
		vo.setErrmsg("11111111");
		
		
		int res = logService.insert(vo);
		
		System.out.println("res : " +res);
		assertEquals(res, 1);
}
	
	
	
}
