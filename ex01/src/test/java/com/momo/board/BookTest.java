package com.momo.board;

import static org.junit.Assume.assumeNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.BookMapper;
import com.momo.vo.BookVO;
import com.momo.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookTest {
	
	@Autowired
	BookMapper bookMapper;

	@Test
	public void getList() {
		assumeNotNull(bookMapper);
		Criteria cri = new Criteria();
		cri.setSearchField("title");
		cri.setSearchWord("제목");
		
		List<BookVO> list = bookMapper.getList(cri);
		list.forEach(book -> {
			log.info("bookVO==============");
			log.info(book.getNo());
			log.info(book.getTitle());
			log.info(book.getAuthor());
			log.info(book.getSfile());
			log.info(book.getOfile());
			log.info(book.getId());
			log.info(book.getRentyn());
			log.info(book.getRentynStr());
			log.info(book.getRentno());
			log.info(book.getStartDate());
			log.info(book.getEndDate());
			log.info(book.getReturnDate());
			
		});
		log.info(list);
		
		
		
	}
	
	@Test
	public void getTotalCnt() {
		assumeNotNull(bookMapper);
		int res = bookMapper.getTotalCnt(new Criteria());
		System.out.println("총건수 : " + res);
	}
	
	@Test
	public void getOne() {
		BookVO book = bookMapper.getOne(111);
		System.out.println(book);
	}
	
}
