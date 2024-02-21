<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14 FN</title>
</head>
<body>
<%
	String[] messages = "HI_ Hello@ welcome!".split(" ");
	String message = "I am Twice";
	out.print("문자열의 길이 : " + message.length() + "<br>");
	out.print("문자열 am의 위치 : " + message.indexOf("am") + "<br>");
	out.print("문자열 대문자로 변경 : " + message.toUpperCase() + "<br>");
	out.print("특정 위치 3 문자 가져오기 : " + message.charAt(3) + "<br>");
	out.print("특정 문자열 am 포함 여부 : " + message.contains("am") + "<br>");
	out.print("특정 문자열 are 포함 여부 : " + message.contains("are") + "<br>");
	out.print("특정 문자열을 다른 문자열로 치환 : " + message.replace("Twice", "Viviz"));
	
	out.print("문자열 공백으로 split 결과 : " + messages[0] + "," + messages[1] + "," + messages[2]);
	
	pageContext.setAttribute("msg", message);
	pageContext.setAttribute("msgArr", messages);
%>
	<h3>위와 같은 문자열의 메소드를 실행하는 함수 fn 테스트</h3>
	<hr>
	<p>
		core, fmt 라이브러리는 태그를 제공하고 fn 라이브러리는 함수를 사용할 수 있게 합니다.
		<br>
		문자열 메소드의 결과값이 태그 안에서 출력되도록 합니다.
	</p>
	<ul>
		<li> <c:out value="${fn:length(msg)}" /> </li>
		<li> <c:out value="${fn:indexOf(msg, 'am')}" /> </li>
		<li> <c:out value="${fn:toUpperCase(msg)}" /> </li>
		<li> <c:out value="${fn:substring(msg, 3, 6)}" /> </li>
		<li> <c:out value="${fn:contains(msg, 'am')}" /> </li>
		<li> <c:out value="${fn:contains(msg, 'are')}" /> </li>
		<li> <c:out value="${fn:replace(msg, 'Twice', 'Viviz')}" /> </li>
		<c:set value="he                          llo               ! !" var="temp" />
		<li>
			<c:out value="${temp}"></c:out>
				=> html 문서에서는 공백이 하나만 반영됩니다. 연속된 공백을 모두 출력하려면 &nbsp;를 사용해야 합니다.
		</li>
		<li> ${fn:replace(temp, ' ', '&nbsp;')} </li>
	</ul>
	<hr>
	<h4>msgArr 배열 애트리뷰트 하나씩 출력하기</h4>
	<ul>
		<c:forEach items="${msgArr}" var="ele">
			<li> <c:out value="${ele}" /> </li>
		</c:forEach>
		<c:set value="${fn:split(msg, ' ')}" var="temps" />
		<c:forEach items="${temps}" var="ele">
			<li> <c:out value="${ele}" /> </li>
		</c:forEach>
	</ul>
</body>
</html>