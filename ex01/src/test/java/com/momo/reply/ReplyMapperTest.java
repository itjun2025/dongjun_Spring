package com.momo.reply;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.ReplyMapper;
import com.momo.vo.Criteria;
import com.momo.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	
	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void test() {
		assertNotNull(mapper);
		Criteria cri = new Criteria();
		cri.setAmount(5);
		cri.setPageNo(1);
		
		List<ReplyVO> list = mapper.getList(83, cri);
		log.info("======================");
		log.info("list : " + list);
	}
	
	@Test
	public void insertTest() {
		ReplyVO vo = new ReplyVO();
		
		vo.setBno(50);
		vo.setReply("댓글을 달아 보아요");
		vo.setReplyer("작성자");
		
		int res = mapper.insert(vo);
		
		assertEquals(res, 1);
	}
	
	@Test
	public void deleteTest() {	
		int rno = 15;
		int res = mapper.delete(rno);
		
		assertEquals(1, res);
	}
	
	@Test
	public void updateTest() {
		ReplyVO vo = new ReplyVO();
		
		vo.setBno(20);
		vo.setReply("으하하하ㅏ하핳");
		vo.setReplyer("코끼리");
		
		int res = mapper.update(vo);
		
		assertEquals(res, 1);
	}
	
	@Test
	public void totalCnt() {
		int res = mapper.totalCnt(50);
		
		System.out.println("======== totalCnt : " + res);
	}
}











