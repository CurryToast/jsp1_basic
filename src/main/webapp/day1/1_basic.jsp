<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_Basic</title>
<style type="text/css">
	table {
		min-width: 500px;
	}
	th {
		min-width: 120px;
	}
</style>
</head>
<body>
<p>jsp에서는 html 태그와 함께 자바 명령어 작성, 변수 출력 등을 할 수 있습니다.</p>
<%
	String[] names = {"사나", "나연", "모모", "쯔위", "다현"};
	List<String> list = List.of("사나", "나연", "모모", "쯔위", "다현");
	CustomerVo vo = new CustomerVo("sana", "김사나", "sana@gmail.com", 23, null);
%>
	<h4>배열 names</h4>
	<ul>
		<!-- 여기에 names 배열 요소값을 자바 코드 사용하여 반복문 출력 -->
<%
	for(int i = 0; i < names.length; i++) { // for 시작
%>
	<li><%= names[i] %></li>
<%
	} // for 끝
%>
	</ul>
	<hr>
	<h3>컬렉션</h3>
	<ul>
<%
	for(int i = 0; i < list.size(); i++) { // for 시작
%>
	<li><%= list.get(i) %></li>
<%
	} // for 끝
%>
	</ul>
	<hr>
	<h4>CustomerVo 객체</h4>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>가입 날짜</th>
		</tr>
		<tr>
			<th><%= vo.getCustomId() %></th>
			<th><%= vo.getName() %></th>
			<th><%= vo.getEmail() %></th>
			<th><%= vo.getAge() %></th>
			<th><%= vo.getReg_date() %></th>
		</tr>
	</table>
</body>
</html>
<!--
	단축키
		ctrl + 스페이스바 (참조, import, 자동완성 등등)
		ctrl + d (한줄 삭제)
		ctrl + alt + 방향키 (한줄 복사)
		alt + 방향키 (줄이동)
		ctrl + shift + / (주석
		shift + 엔터 (다음 줄 이동)
 -->
