<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1 - Buys</title>
<link rel="stylesheet" href="assets/css/day3.css">
</head>
<body>
	<h3>구매 전체 조회</h3>
	<hr>
	<ul>
		<li class="list-header">
			<ul class="buys">
				<li>구매코드</li>
				<li>상품코드</li>
				<li>상품명</li>
				<li>상품가격</li>
				<li>구매수량</li>
				<li>구매일시</li>
			</ul>
		</li>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<li>
				<ul class="buys">
					<li> <c:out value="${vo.buy_idx}"></c:out> </li>
					<li> <c:out value="${vo.pcode}"></c:out> </li>
					<li> <c:out value="${vo.pname}"></c:out> </li>
					<li> <c:out value="${vo.price}"></c:out> </li>
					<li> <c:out value="${vo.quantity}"></c:out> </li>
					<li> <fmt:formatDate value="${vo.buy_date}" pattern="yyyy-MM-dd"/> </li>
				</ul>
			</li>
		</c:forEach>
	</ul>
</body>
</html>