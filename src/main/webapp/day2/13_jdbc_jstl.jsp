<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>13 JDBC JSTL</title>
<style type="text/css">
	th, td {
		min-width: 150px;
	}
	
	th {
		color: lightgrey;
		background-color: orange;
		padding: 2px 10px;
		font-weight: 900;
	}
	
	tr:nth-child(2) > td {
		border-top: 1px solid black;
	}
	
	td {
		padding: 2px;
		text-align: center;
		border-right: 1px solid black;
		border-bottom: 1px solid black;
		font-weight: 400;
	}
	
	td:first-child {
		border-left: 1px solid black;
	}
</style>
</head>
<body>
	<h2>2번 소스파일의 스크립트릿과 출력식을 jstl과 el로 변경하기</h2>
	<hr>
	<%
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = dao.allCustomers();
		pageContext.setAttribute("list", list);
	%>
	<table>
		<tr>
			<th>고객 아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>이메일</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<tr>
				<td> <c:out value="${fn:toUpperCase(vo.customId)}"></c:out> </td>
				<td> <c:out value="${vo.name}"></c:out> </td>
				<td> <c:out value="${vo.age}"></c:out> </td>
				<td> <c:out value="${vo.email}"></c:out> </td>
				<td> <fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd"/> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>