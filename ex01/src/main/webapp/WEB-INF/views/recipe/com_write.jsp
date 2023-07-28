<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티게시판</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />

<body>
 <!-- Header -->
	<%@ include file="../common2/header.jsp" %>
	
	<section id="main" style="border: 3px dashed #ed786a;">
	
	<!-- 가운데로 "망한요리게시판" 크게 표시 -->
    <div style="text-align: center; font-size: 30px; font-weight: bold; margin-bottom: 20px; color: darkred;">
        ♨♨♨ 망한요리게시판 ♨♨♨
    </div>
<form action='<c:url value='/board/boardInsert'/>' method="post" enctype="multipart/form-data">	
 
        <div class="form-group">
              <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="제목을 작성해주세요.">
          </div>
       
          <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" name="contents" rows="10" placeholder="내용을 작성해주세요. 비속어는 삼가해주세요 ㅠ"></textarea>
          </div>
          
          
           <div>
		        <label for="exampleFormControlInput1">사진 추가</label>
		        <input type="file" name="photos" id="photoInput" class="form-control" accept="image/jpeg, image/png" multiple>
    	   </div>
    
    <!-- 썸네일을 보여줄 컨테이너 -->
    <div id="thumbnailContainer" style="display: flex; flex-wrap: wrap;"></div>
    
    
          
          
          
          <div style="text-align: center;">
        <button type="submit" >등록</button>
        <button type="button" >취소</button>
          </div>
          
           
    
    
   
    
          
          
    </form>
	</section>
<!-- Footer -->
	<%@ include file="../common2/footer.jsp" %>
	
	
	<script>
    // 파일 선택 시 썸네일 미리보기 생성
    const photoInput = document.getElementById('photoInput');
    const thumbnailContainer = document.getElementById('thumbnailContainer');

    photoInput.addEventListener('change', function (event) {
        thumbnailContainer.innerHTML = ''; // 이전 썸네일 제거

        // 선택한 파일들에 대해 썸네일 생성
        for (const file of event.target.files) {
            const thumbnail = document.createElement('img');
            thumbnail.style.width = '100px'; // 썸네일 크기 조정 (원하는 크기로 변경 가능)
            thumbnail.style.height = '100px';
            thumbnail.src = URL.createObjectURL(file); // 파일로부터 썸네일 URL 생성
            thumbnailContainer.appendChild(thumbnail);
        }
    });
</script>
	
</body>
</html>