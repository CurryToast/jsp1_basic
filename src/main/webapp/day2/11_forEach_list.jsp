<%@page import="java.util.List"%>
<%@page import="project.vo.CustomerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11 forEach List</title>
</head>
<body>
	<h5>자바 객체 컬렉션(리스트) 활용하기</h5>
	<%
		// jdbc로 sql 조회한 결과 List에 활용합니다.
		List<CustomerVo> list = List.of(
			new CustomerVo("momo12", "강모모", "momo12@daum.net", 29, null),
			new CustomerVo("momo13", "강모모", "momo13@daum.net", 29, null),
			new CustomerVo("momo14", "강모모", "momo14@daum.net", 29, null),
			new CustomerVo("momo15", "강모모", "momo15@daum.net", 29, null),
			new CustomerVo("momo16", "강모모", "momo16@daum.net", 29, null),
			new CustomerVo("momo17", "강모모", "momo17@daum.net", 29, null)
		);

		pageContext.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="vo" varStatus="status">
		<!-- varStatus 속성 index는 지금처럼 items로 컬렉션 다룰 때 사용합니다. -->
		<ul style="border: 1px solid black; width: fit-content; padding-right: 20px;">
			<li> index: <c:out value="${status.index}"/> </li>
			<li> customId: <c:out value="${vo.customId}"/> </li>
			<li> name: <c:out value="${vo.name}"/> </li>
			<li> email: <c:out value="${vo.email}"/> </li>
			<li> age: <c:out value="${vo.age}"/> </li>
		</ul>
	</c:forEach>
</body>
</html>