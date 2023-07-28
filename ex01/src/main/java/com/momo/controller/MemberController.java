package com.momo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.momo.service.MemberService;
import com.momo.vo.Member;

@Controller
public class MemberController extends CommonRestController{
	
	@Autowired
	MemberService service;
	
	@GetMapping("/login/naver")
	public void naverLogin() {
		
	}
	
	@GetMapping("/login/naver_callback")
	public String naverLogin_callback(HttpServletRequest request , Model model) {
		
		service.naverLogin(request,model);
		return "/login/naver";
	}
	
	/**
	 * 로그인 페이지로 이동
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	@PostMapping("/loginAction")
	public @ResponseBody Map<String, Object> loginAction(@RequestBody Member member
													     , Model model, HttpSession session ) {
		System.out.println("id : " + member.getId());
		System.out.println("pw : " + member.getPw());
		
		member = service.login(member);
		if(member != null) {
			session.setAttribute("member", member);
			session.setAttribute("userId", member.getId());
			return responseMap(1, "로그인되었습니다.");
		}else {
			return responseMap(0, "아이디와 비밀번호를 확인해주세요");
		}
		
		
	}
	
	@PostMapping("/idCheck")
	public @ResponseBody Map<String, Object> idCheck(@RequestBody Member member){
		
		int res = service.idCheck(member);
		// count = 1 실패
		// insert, delete, update > 0
		if(res == 0) {
			return responseMap(REST_SUCCESS, "사용 가능한 아이디입니다");
		}else {
			return responseMap(REST_FAIL, "이미 사용중인 아이디입니다");
		}
		
	}
	
	@PostMapping("/register")
	public @ResponseBody Map<String, Object> register( @RequestBody Member member){
		
		try {
			
		int res = service.insert(member);
		return responseWriteMap(res);
		} catch(Exception e){
			e.printStackTrace();
			return responseMap(REST_FAIL, "등록중 예외시항이 발생하였습니다");
		}
	}
}















