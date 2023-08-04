<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form class="form-control" method="post" action="/recipe1/cateWrite">

<div class="cont_line">
				<label style="display: inline;">카테고리</label>
				<i class="bi bi-tags" style="display: inline; color: pink;"></i><br>
				
				
				<input type="text" name="C_NO" value="${vo.C_NO}"><br><br>
				
				
				<select name="bigcate" id="bigcate" style="width:200px; height:50px; display: inline;">
					<option value="대분류">대분류</option>
					<option value="한식">한식</option>
					<option value="중식">중식</option>
					<option value="양식">양식</option>
					<option value="일식">일식</option>
					<option value="다이어트식">다이어트식</option>
					<option value="기타음식">기타음식</option>
				</select> 
				
				
				<select name="midcate" id="midcate" style="width:200px; height:50px; display: inline;">
					<option value="중분류">중분류</option>
					<option value="밥요리">밥요리</option>
					<option value=국,찌개>국,찌개</option>
					<option value="면요리">면요리</option>
					<option value="샐러드">샐러드</option>
					<option value="고기고기">고기고기</option>
					<option value="기타">기타</option>
				</select> 
				
				<select name="smcate" id="smcate" style="width:200px; height:50px; display: inline;">
					<option value="소분류">소분류</option>
					<option value="재료별">재료별</option>
					<option value="소고기">소고기</option>
					<option value="돼지고기">돼지고기</option>
					<option value="닭고기">닭고기</option>
					<option value="육류">육류</option>
					<option value="채소류">채소류</option>
					<option value="해물류">해물류</option>
					<option value="달걀/유제품">달걀/유제품</option>
					<option value="가공식품류">가공식품류</option>
					<option value="쌀">쌀</option>
					<option value="밀가루">밀가루</option>
					<option value="건어물류">건어물류</option>
					<option value="버섯류">버섯류</option>
					<option value="과일류">과일류</option>
					<option value="콩/견과류">콩/견과류</option>
					<option value="곡류">곡류</option>
					<option value="기타">기타</option>
				</select>
			</div>
			
			<!-- 등록, 미리보기 , 취소 버튼 -->			
			<div style="text-align: center;">
				<button type="submit" class="btn btn-success">등록</button>
				
			</div>

</form>
</body>
</html>