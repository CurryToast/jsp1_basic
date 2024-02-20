<%@page import="project.dao.TblCustomerDao"%>
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

<%
	CustomerVo vo = new CustomerVo(
			"sanaa",
			"김사나",
			"sanaa@gmail.com",
			23,
			null
	);
	TblCustomerDao dao = new TblCustomerDao();
	dao.join(vo);
%>

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
	<a href="2_jdbc.jsp">전체 고객 조회</a>
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
