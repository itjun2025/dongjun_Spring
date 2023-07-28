package com.momo.fileupload;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.service.Fileuploadservice;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class serviceTest {

	@Autowired
	Fileuploadservice service;
	
	@Test
	public void test() {
		int res = service.delete(83, "97768083-1eea-44f4-8570-750df5ed6f7e");
		assertEquals(res, 1);
	}
}
