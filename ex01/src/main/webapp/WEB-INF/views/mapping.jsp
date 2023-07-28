<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name : ${name }<br>
age  : ${age }<br>
=====================
<h3>vo출력</h3>
${member.name }<br>
${member.age }<br>
${member.dueDate }<br>
${message }<br>
======================
<h3>배열 출력</h3>
${ids }<br>
<a href="/mapping/requestMapping">requestMapping 호출</a><br>

<a href="/mapping/getMapping?name=동준 &age=27">requestMapping 호출</a><br>

<a href="/mapping/getMappingVO?name=동준 &age=27&dueDate=2023/07/03">requestMappingVO 호출</a><br>

<a href="/mapping/getMappingArr?ids=id1&ids=id2&ids=id3&">requestMappingArr 호출</a><br>

<a href="/mapping/getMappingList?ids=id1&ids=id2&ids=id3&">requestMappingList 호출</a><br>

<h3>객체 리스트를 파라메터로 전달해봅시다</h3>
	파라메터 전달방법 :
	list[0].name=momo&list[0].age=123&list[1].name=admin&list[1].age=120<br>

<script>
	function voList(){
		let url = "/mapping/getMappingMemberList?list[0].name=momo&list[0].age=123&list[1].name=admin&list[1].age=120"
				
			url = encodeURI(url);
			alert(url)
			location.href=url;
	}
</script>

<a href="#" onclick="voList()">객체리스트 전달</a>

<form action="/mapping/requestMapping" method="post">
	<input type="submit" value="전송"><br>
</form>
</body>
</html>