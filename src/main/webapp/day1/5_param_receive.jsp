<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5_Parameter_Receive</title>
</head>
<body>
	<h3>4번 url 주소에서 보낸 파라미터를 받아 값을 저장합니다. -> 조회에 사용합니다.</h3>
	<hr>
	<%
		String name = request.getParameter("name");
		String temp = request.getParameter("age");
		
		if (
				name != null && name.length() > 0 &&
				temp != null && temp.length() > 0
		) {
			int age = Integer.parseInt(temp);

			out.print("<h4>name</h4>");
			out.print(name);

			out.print("<h4>age</h4>");
			out.print(age);
		} else {
			out.print("<h3>모든 파라미터 값을 입력하세요.</h3>");
		}
	%>
</body>
</html>