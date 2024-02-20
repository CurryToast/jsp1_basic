<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7 Parameter Form</title>
</head>
<body>
	<h3>테이블 행 조회에 필요한 조건 값을 input에 입력하고 전송하기</h3>
	<hr>
	<form action="6_selectBy.jsp">
		<input type="text" name="name" placeholder="이름을 입력하시오." required>
		<input type="number" name="age" placeholder="나이를 입력하시오." required>
		<button>조회</button>
		<!-- 
			method="get"(기본값)이면 파라미터가 url에 포함됩니다. (조회)
		 -->
	</form>
</body>
</html>