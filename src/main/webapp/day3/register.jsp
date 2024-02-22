<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1 - Register</title>
<!-- css파일 위치는 context path /jsp1/ (webapp폴더) 기준으로 합니다. -->
<link rel="stylesheet" href="assets/css/customerRegister.css">
</head>
<body>
  <div class="container">
  	<c:if test="${customerCols.size() > 0}">
	  	<form action="register.cc" method="post">
	  		<c:forEach items="${customerCols}" var="vo" varStatus="status">
		  		<p id="${vo.key}-cap"><c:out value="${vo.value}" /></p>
		  		<input name="${vo.key}"/>
	  		</c:forEach>
	  		<div class="submit-container">
		  		<button type="button" id="join">
		  			고객 등록
		  		</button>
	  		</div>
	  	</form>
  	</c:if>
  </div>
  <c:if test="${registerResult > 0}">
  	<div>등록 성공!</div>
  </c:if>
  <c:if test="${registerResult == 0}">
  	<div>등록 실패</div>
  </c:if>
  <script src="assets/js/customerRegister.js"></script>
</body>
</html>