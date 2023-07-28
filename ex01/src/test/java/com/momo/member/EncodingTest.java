package com.momo.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.mapper.MemberMapper;
import com.momo.vo.Member;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class EncodingTest {
   /**
    *  스프링 시큐리티 모듈에서 제공하는 비밀번호 암호화 및 인증 기능
    *  (Spring security)에서 제공하는 비밀번호를 암호화하는데 사용할 수 있는 메서드를 가진 클래스이다.
    */
   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
   
   @Autowired
   MemberMapper memberMapper;
   
   
   @Test
   public void test() {
      String pw = "안녕하세유";
      
      for(int i = 0; i < 10; i++) {
         // 암호화할 때마다 새로운 문자열을 반환하며, 복호화가 불가능
         String encodePw = encoder.encode(pw);
         System.out.println("암호화 : " + encodePw);
         
         // 첫 번째 매개변수는 일치여부를 확인하고자 하는 인코딩 되지 않은 패스워드
         // 두 번째 매개변수는 인코딩된 패스워드를 입력한다.
         
         //제출된 인코딩 괴지 않는 패스워드(일치여부를 확인하고자 하는 패스워드)와 
         // 인코딩 된 패스워드의 일치여부를 확인한다.
         boolean matches = encoder.matches(pw, encodePw);
         System.out.println("인증 결과 : " + matches);
      }
      
   }
   
   @Test
   public void testInsert() {
      Member member = new Member();
      
      member.setId("사용자0714");
      member.setPw("1234");
      member.setName("사용자");
      
      int res = memberMapper.insert(member);
   }
   @Test
   public void testIdCheck() {
      Member member = new Member();
      
      member.setId("사용자0714");

      
      int res = memberMapper.idCheck(member);
      assertEquals(1, res);
   }
}