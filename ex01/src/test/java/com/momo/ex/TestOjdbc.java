package com.momo.ex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestOjdbc {
	
	@Test
	public void calcTest() {
		Calc calc = new Calc();
		int res = calc.add(1, 2);
		
		// res 가 4인지 묻는질문
		// assertEquals(예상결과값 , 실제결과값);
		// false이면 jUnit에 표시
		assertEquals(3,res);
	}
	
	
	@Test
	public void ojdbcTest() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "library";
		String pw = "1234";
		Connection conn = null;
		
				// 커넥션 생성
				try {
					// 1. 드라이버 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// 2. 커넥션 생성
					conn = DriverManager.getConnection(url,id,pw);
					
					ResultSet rs = conn.createStatement().executeQuery("SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') || '입니다' FROM dual");
					rs.next();
					
					System.out.println(rs.getString(1));
					System.out.println(conn);;
							
					assertNotNull(conn);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("라이브러리 로드중 오류가 발생 하였습니다.");
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}
}
