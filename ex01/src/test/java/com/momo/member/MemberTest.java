package com.momo.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.MemberMapper;
import com.momo.vo.Member;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberTest {

	@Autowired
	MemberMapper memberMapper;
	
		@Test
		public void getList() {
			assumeNotNull(memberMapper);
			List<Member> list = memberMapper.getList();
			
			list.forEach(mem -> {
				log.info("Member ============");
				log.info("멤버 아이디 : " + mem.getId());
				log.info("멤버 비빌번호 : " + mem.getPw());
				
			});	
	}
		
		@Test
		public void test() {
			Member member = new Member();
			member.setId("동준");
			member.setPw("1234");
			
			memberMapper.login(member);
			
			log.info(member);
			assertNotNull(member);
		}
		
		@Test
		public void testInsert() {
			Member member = new Member();
			member.setId("test1");
			member.setPw("1234");
			member.setName("서동준");
			
			int res = memberMapper.insert(member);
			
			assertEquals(1, res);
			
		}
		
		@Test
		public void testIdCheck() {
			Member member = new Member();
			member.setId("test1");
			
			int res = memberMapper.idCheck(member);
			
			assertEquals(1, res);
		}
}










