package com.momo.comboard;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.ComReplyMapper;
import com.momo.vo.ComBoardVO;
import com.momo.vo.ComReplyVO;
import com.momo.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class comReplyMapperTest {
	
	@Autowired
	ComReplyMapper mapper;
	
	@Test
	public void getlist() {
		List<ComReplyVO> list = mapper.getList();
		list.forEach(vo ->{
			log.info("ComReplyVO============");
			log.info(vo.getR_NO());
			log.info(vo.getReply());
			log.info(vo.getReplydate());
			log.info(vo.getUpdatedate());
			log.info(vo.getCom_bno());
			log.info(vo.getMno());
			
		});
		
	}
		
		
		
		
		
	
	@Test
	public void insertTest() {
		ComReplyVO vo = new ComReplyVO();
		
		vo.setReply("캬캬캬캬캬캬ㅑ!!");
		vo.setCom_bno(166);
		vo.setMno(1);
		
		
		int res = mapper.insert(vo);
		
		assertEquals(res, 1);
	}
	
	@Test
	public void deleteTest() {	
		int rno = 17;
		int res = mapper.delete(rno);
		
		assertEquals(1, res);
	}
	
	@Test
	public void updateTest() {
	    

	    // 업데이트할 데이터 설정
	    ComReplyVO vo = new ComReplyVO();
	    vo.setR_NO(21);
	    vo.setReply("tttttttttt");

	    // 업데이트 수행
	    int res = mapper.update(vo);
	    assertEquals(1, res); // 업데이트가 성공적으로 이루어졌는지 확인
	    
	} 
	
	
	
	
	
	
	@Test
	public void totalCnt() {
		int res = mapper.getTotalCnt();
		
		System.out.println("======== 총 댓글수 : " + res);
	} 
	
	@Test
	public void getCom_bnoCnt() {
	    int rno = 11;

	    // 테스트 쿼리 실행
	    int res = mapper.getCom_bnoCnt(rno);

	    // 테스트 결과 검증
	    System.out.println("========" + rno+ "번 게시물  댓글수 : " + res);
	}
	

}
