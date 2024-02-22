<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<div>
		<h3>상품 등록</h3>
		<form action="productReg.cc" method="post">
			<div>
				<p>상품코드</p>
				<input type="text" name="pcode" />
			</div>
			<div>
				<p>카테고리</p>
				<input type="text" name="category" />
			</div>
			<div>
				<p>상품명</p>
				<input type="text" name="pname" />
			</div>
			<div>
				<p>가격</p>
				<input type="number" name="price" min="0" max="999999999" />
			</div>
			<div>
				<button type="button" id="proreg">
					상품 등록
				</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="assets/js/productReg.js"></script>
</body>
</html>