package com.momo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.momo.mapper.MemberMapper;
import com.momo.vo.Member;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public Member login(Member paramMember) {
		// 사용자 정보조회
		Member member =  memberMapper.login(paramMember);
		if(member != null) {
			// 사용자가 입력한 비밀번호가 일치하는지 확인
			// 사용자가 입력한 비밀번호, 데이터베이스에 암호화되어 저장된 비밀번호
			boolean res = encoder.matches(paramMember.getPw(),member.getPw());
			
			// 비밀번호 인증이 성공하면 member객체를 반환
			if(res) {
				return member;
			}else {
				return null;
			}
		}
		
		return memberMapper.login(member);
	}

	@Override
	public int insert(Member member) {
		// 비밀번호 암호화
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		member.setPw(encoder.encode(member.getPw()));
		
		return memberMapper.insert(member);
	}

	@Override
	public int idCheck(Member member) {
		return memberMapper.idCheck(member);
	}
	
	@Autowired
	ApiExamMemberProfile apiExam;
	
	@Override
	public void naverLogin(HttpServletRequest request, Model model) {
		try {
			// callback 처리 -> access_token 얻기
			Map<String, String> callbackRes =  callback(request);
			
			String access_token = callbackRes.get("access_token");
			// access_token -> 사용자 정보조회
			Map<String, Object> responseBody =  apiExam.getMemberProfile(access_token);
			
			Map<String, String> response =  (Map<String, String>) responseBody.get("response");
			
			System.out.println("=============== naverLogin ===");
			System.out.println(response.get("name")); 
			System.out.println(response.get("id"));
			
			System.out.println("==============================");
			
			// 세션에 저장
			model.addAttribute("id" , response.get("id"));
			model.addAttribute("name" , response.get("name"));
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public Map<String, String> callback(HttpServletRequest request) throws Exception{
		
		String clientId = "D0IUDrzMDtxXuChewLgy";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "qTYKCzw7KR";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    try {
	    String redirectURI = URLEncoder.encode("http://localhost:8080/login/naver_callback", "UTF-8");
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	      URL url = new URL(apiURL); // url 호출
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        System.out.println("token요청 " + res.toString());
	        // json문자열을 Map으로 변환
	        Map<String, String> map = new HashMap<String, String>();
	        ObjectMapper objectMapper = new ObjectMapper();
	        map = objectMapper.readValue(res.toString(), Map.class);
	        return map;
	      }else {
	    	  throw new Exception("callback 반환코드 : " + responseCode);
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	      throw new Exception("callback 처리중 오류가 발생했습니다.");
	    }
	}
	
}
