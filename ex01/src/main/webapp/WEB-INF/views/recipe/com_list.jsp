<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.dd{
	border: 1px solid red;
}

.dd1{
	border: 1px solid green;
}

</style>
</head>

<%@ include file="../common2/header.jsp" %>
<body>

<section id="main" style="border: 3px dashed #ed786a;">
<h1 style="text-align: center">리스트 페이지</h1>
<a  href="/ex/comboard/write" role="button">글쓰기 &raquo;</a>
 
			<div class="panel-body">

                           <table  width="100%" class="table" id="dataTables-example">
                               <thead>
                                  <tr>
							        <th class="dd">게시글 번호</th>
							        <th class="dd">닉네임</th>
							        <th class="dd">제목</th>
							        <th class="dd">내용</th>
							        <th class="dd">등록일</th>
							        <th class="dd">수정일</th>
							        <th class="dd">조회수</th>
							        <th class="dd">회원번호</th>
							    </tr>
							</thead>
							<tbody>
							    <c:forEach items="${list }" var="vo">
							        <tr class="odd gradeX">
							            <td class="dd1"><a href="/ex/comboard/view?com_bno=${vo.com_bno}">${vo.com_bno}</a></td>
							            <td class="dd1">${vo.nickName }</td>
							            <td class="dd1">${vo.com_title }</td>
							            <td class="dd1">${vo.com_content }</td>
							            <td class="dd1">${vo.regdate }</td>
							            <td class="dd1">${vo.update_date }</td>
							            <td class="dd1">${vo.replycnt }</td>
							            <td class="dd1">${vo.mno }</td>
							        </tr>
                               </c:forEach>
                               </tbody>
                                   
                           </table>
                           
                           
                           
   
   
                           
                        </div>
                        </section>
                        
                        
             <%@ include file="../common2/footer.jsp" %>
                        
                        
</body>
</html>