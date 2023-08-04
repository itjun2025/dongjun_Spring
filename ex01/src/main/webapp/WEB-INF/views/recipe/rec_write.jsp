<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 등록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
	
<!-- Bootstrap JavaScript 로드 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
   
	// 재료추가버튼 함수
	   function addMaterial() {
	        var ul = document.getElementById('material');
	        var newLi = document.createElement('li');
	     	// 새롭게 추가
	        newLi.innerHTML = 
	        `
	          <input type="text" name="material[]"  
	          				style="display: inline-block; width: 280px;" placeholder="예) 간마늘">
	          
	          <input type="text" name="material[]"  
	          				style="display: inline-block; width: 280px;" placeholder="예) 2큰술">
	        `;
	        ul.appendChild(newLi);
	      }
    
    
    
	// 순서추가버튼 함수
	function addCookStep() {
			var cookStep = document.getElementById('cookStep');
			var newCookstep = document.createElement('div'); // 새로운 cookstep div를 생성
		 	 

			  // 새롭게 추가
			  newCookstep.innerHTML =
			  `
			    <p>step</p>
			    <textarea placeholder="예) 떡볶이는 미리 물에 담궈놔 주세요~" 
			    				style="display: inline-block; width: 450px; resize: none;">
			    </textarea>     
			    <input type="file" name="files" style="display: inline-block;"><br>
			  `;
	
			  // 새로운 cookstep div를 기존 cookStep 맨 뒤에 추가
			  cookStep.appendChild(newCookstep);
		  
		}
	// 페이지 다시생성
	function redirectToRecipeWrite() {
	    window.location.href = "http://localhost:8080/recipe1/write"; // 새로운 페이지로 이동할 URL을 입력하세요.
	  }
    
 
   
    
  </script>
</head>
<body>
	<!-- Header -->
	<%@ include file="../common2/header.jsp"%>

	<!-- Main -->
	<section id="main" style="border: 3px dashed #ed786a;">

		<!-- 타이틀 제목 -->
		<div
			style="text-align: center; font-size: 30px; font-weight: bold; margin-bottom: 20px; color: pink;">
			♡♡♡ 레시피 게시판 ♡♡♡
		</div>


		<form class="form-control" method="post" action="/recipe1/postWrite">	

		<!-- 제목 입력란  -->
			<div class="rec_title">
				<label>레시피 제목 </label> 
				<input type="text" name="title" placeholder="예) 학교앞 분식집 떡볶이 만들기" value="${board.title}">
			</div>
			
			<br><br>

		<!-- 요리소개  -->
			<div class="rec_intro">
				<label >요리 소개</label>
				<textarea
					placeholder="이 레시피의 탄생배경을 적어주세요. 예)어릴적 학교앞 분식집에서 먹던 떡볶이 맛이 그리우셨다면 한번 만들어보세요~"
					name="intro" style="resize: none;">${board.intro }</textarea>
			</div>
			
			<br><br>
			
			
			
			
			
		<!-- 대표사진 파일첨부  -->
			<div>
				<label style="display: inline;">대표사진설정하기</label>
				<i class="bi bi-image" style="display: inline; color: pink;"></i>
				<input type="file" name="photos" id="photoInput" class="form-control" 
					 >
			</div>
			
		
			
			<br><br>
			
		<!-- 동영상 링크  -->
			<div>
				<label  style="display: inline;">동영상</label>
				<i class="bi bi-camera-reels" style="display: inline; color: pink;"></i>
			</div>
			<textarea
				placeholder="동영상이 있으면 주소를 입력하세요. 예)http://youtu.be/lA0Bxo3IZmM"
				style="height: 100px; width: 380px; resize: none;"></textarea>
				
				
			<br><br>
			
		<!-- 카테고리 / 대,중,소 분류  -->
				
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


			<br><br>
			
			<!-- 재료 ( 재료명 / 계량 ) -->

				<div>
					<label for="exampleFormControlInput1" 
						   style="display: inline">재료 (재료이름과 정확한계량을 입력해주세요!!)
					</label>
					<i class="bi bi-egg-fried" style="display: inline; color:pink;"></i>
					<ul id="material" >
					
						<li >
							<input type="text"
							name="material1_1" id="material1_1"
							style="display: inline-block; width: 280px;"
							placeholder="예) 돼지고기"> 
							
							<input type="text"
							name="material1_2" id="material1_2"
							style="display: inline-block; width: 280px;"
							placeholder="예) 300g">
						</li>
						
						
						<li>
							<input type="text"
							name="material2_1" id="material2_1"
							style="display: inline-block; width: 280px;"
							placeholder="예) 양배추"> 
							
							<input type="text"
							name="material2_2" id="material2_2"
							style="display: inline-block; width: 280px;"
							placeholder="예) 1/2개">
						</li>
							
						<li>
							<input type="text"
							name="material3_1" id="material3_1"
							style="display: inline-block; width: 280px;"
							placeholder="예) 참기름"> 
							
							<input type="text"
							name="material3_1" id="material3_2"
							style="display: inline-block; width: 280px;"
							placeholder="예) 1T">
						</li>
						
					</ul>
				
					<!-- 재료추가 버튼을 누르면 박스2개 생성! -->
					<button type="button" onclick="addMaterial()">
						<span >재료추가</span>
					</button>

				</div>



			<!-- 요리순서 -->
			
    <label>요리순서</label>
    		
    		
			
			    <div id="cookStep" >
			        <p>step 1</p>
			        <textarea placeholder="예) 떡볶이는 미리 물에 담궈놔 주세요~" 
			        		  style="display: inline-block; width: 450px; resize: none;"></textarea>
			        <input type="file" name="files" style="display: inline-block;"><br>
			    </div>
		
			

			<!-- 순서추가 버튼 -->
			<div>
				<button type="button" onclick="addCookStep()">순서추가</button>
			</div>


			<br><br>
			
			
			<!--  요리팁  -->
			<div>
				<label>요리팁</label> <input type="text" 	
					placeholder="떡이 얼려져있다면 미리 해동시켜주세요!!">
			</div>
			
			
			<br><br>
			
			
			<!--  태그 -->
			<div>
				<label>태그</label> <input type="text"
					placeholder="예) #떡볶이  #어묵  #고추장 ">
			</div>


			<br><br>


			
			
			<!-- 등록, 미리보기 , 취소 버튼 -->			
			<div style="text-align: center;">
				<button type="submit" class="btn btn-success">등록</button>
				<button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#previewModal">미리보기</button>
				<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#cancelModal">취소</button>
			</div>
			
			<!-- 미리보기용 모달 창 -->
			<div class="modal fade" id="previewModal" tabindex="-1" aria-labelledby="previewModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="previewModalLabel">레시피 미리보기</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<!-- 미리보기 내용 -->
							<iframe src="http://localhost:8080/recipe1/write" width="100%" height="600"></iframe>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 취소 확인 모달 창 -->
			<div class="modal fade" id="cancelModal" tabindex="-1" aria-labelledby="cancelModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="cancelModalLabel">정말 취소하시겠습니까?</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
			        <button type="button" class="btn btn-danger" onclick="redirectToRecipeWrite()">확인</button>
			      </div>
			    </div>
			  </div>
			</div>
			



		</form>


	</section>

	<!-- Footer -->
	<%@ include file="../common2/footer.jsp"%>

	
</body>
</html>