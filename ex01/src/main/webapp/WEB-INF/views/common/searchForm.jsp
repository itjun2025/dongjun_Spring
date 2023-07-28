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
${pageDto }<br>
페이지 번호 : ${pageDto.cri.pageNo }<br>
검색필드 : ${pageDto.cri.searchField }<br>
검색어 : ${pageDto.cri.searchWord }

<form class="row g-3" action="/board/list" method="get" name="searchForm">
	
	<input type="text" name="bno" value="">
	<input type="text" name="pageNo" value="${pageDto.cri.pageNo }">
	<div class="row g-3 justify-content-center">
  <div class="col-auto">
    <select name="searchField" class="form-select" aria-label="Default select example">
		  <option value="title" <c:if test="${pageDto.cri.searchField == 'title'}">selected</c:if>>제목</option>
		  <option value="content"${pageDto.cri.searchField == 'content' ? 'selected' : ''}>내용</option>
		  <option value="writer"<c:if test="${pageDto.cri.searchField == 'writer'}">selected</c:if>>작성자</option>
	</select>
  </div>
  <div class="col-sm-6">
    <label for="searchWord" class="visually-hidden">Password</label>
    <input name="searchWord" type="text" class="form-control" id="searchWord" placeholder="검색어" value="${pageDto.cri.searchWord }">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">검색</button>
	</div>
  </div>
</form>
</body>
</html>