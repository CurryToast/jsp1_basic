<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1 Customers</title>
<link rel="stylesheet" href="assets/css/day3.css">
</head>
<body>
	<h3>고객 전체 조회</h3>
	<hr>
	<!-- list라는 이름의 애트리뷰트가 필요함 => 애트리뷰트 저장은 서블릿에서 합니다. -->
	<ul>
		<li>
			<ul class="customers list-header">
				<li> 고객 아이디 </li>
				<li> 이름 </li>
				<li> 나이 </li>
				<li> 이메일 </li>
				<li> 등록일 </li>
			</ul>
		</li>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<li>
				<ul class="customers">
					<li> <c:out value="${vo.customId}"></c:out> </li>
					<li> <c:out value="${vo.name}"></c:out> </li>
					<li> <c:out value="${vo.age}"></c:out> </li>
					<li> <c:out value="${vo.email}"></c:out> </li>
					<li> <fmt:formatDate value="${vo.reg_date}" pattern="yyyy-MM-dd"/> </li>
				</ul>
			</li>
		</c:forEach>
	</ul>
</body>
</html>