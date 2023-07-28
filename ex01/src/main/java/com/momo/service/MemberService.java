package com.momo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.momo.vo.Member;


@Service
public interface MemberService {
	
	  Member login(Member member);
	  
	  public int insert(Member member);
		
	  public int idCheck(Member member);

	public void naverLogin(HttpServletRequest request, Model model);
}
