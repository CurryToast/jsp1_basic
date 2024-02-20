<%@page import="project.vo.CustomerVo"%>
<%@page import="java.util.List"%>
<%@page import="project.dao.TblCustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6 Select By</title>
</head>
<body>
	<h2>조회 결과</h2>
	<%
		TblCustomerDao dao = new TblCustomerDao();
		List<CustomerVo> list = null;

		String name = request.getParameter("name");
		String temp = request.getParameter("age");
		
		if (
				name != null && name.length() > 0 &&
				temp != null && temp.length() > 0
		) {
			int age = Integer.parseInt(temp);
			list = dao.getCustomerBy(name, age);

			if (list.size() > 0) {
				for (CustomerVo vo : list) {
					out.print("<h4>customer id</h4>");
					out.print(vo.getCustomId());

					out.print("<h4>name</h4>");
					out.print(vo.getName());

					out.print("<h4>age</h4>");
					out.print(vo.getAge());
					
					out.print("<h4>email</h4>");
					out.print(vo.getEmail());
					
					out.print("<h4>regdate</h4>");
					out.print(vo.getReg_date());
					
					out.print("<hr>");
				}
			} else {
				out.print("<h4>조회 결과가 없습니다.</h4>");
			}
		} else {
			out.print("<h3>모든 파라미터 값을 입력하세요.</h3>");
		}
	%>
</body>
</html>