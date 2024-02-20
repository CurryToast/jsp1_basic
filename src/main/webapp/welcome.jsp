<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- language="java" : java 언어로 컴파일 된다. -->
<!-- contentType="text/html" : 응답으로 만들어질 형식은 html이다.  -->
<!DOCTYPE html>
<html>
<head>
<title>회원 가입 - Welcome!</title>
</head>
<body>
	<h1>WELCOME</h1>
    <h3>회원 가입이 완료되었습니다.</h3>
    <hr>
<!-- 자바 프로그래밍을 하는 스크립트 작성 부분입니다.(스크립트릿) -->
<%
	// form 태그 안의 입력양식이 서버로 제출될 때, 그 값을 받아 저장하는 코드입니다.
	// input 요소의 name 속성 값을 인자로 합니다.
	request.setCharacterEncoding("utf-8"); // 한글 깨지는 문제 수정
	String id = request.getParameter("id"); // 아이디.
	String password = request.getParameter("password"); // 패스워드
	String name = request.getParameter("name"); // 이름
	out.print("<h3>아이디</h3>");
	out.print(id);
	out.print("<h3>비밀번호</h3>");
	out.print(password);
	out.print("<h3>이름</h3>");
	out.print(name);
%>
	<hr>
    <p>form 제출 확인 페이지 입니다.</p>
</body>
</html>
<!--
	jsp는 서버측에서 컴파일되고 실행됩니다.
	-> 컴파일 전에는 .java 파일로 변경되고
	-> .java를 컴파일해서 .class를 생성합니다.
	-> 웹페이지를 요청한 클라이언트에게는 .class 파일로 html 문서를 작성합니다. 
-->
<!--
	이클립스는 jsp에 대한 소스파일이 여기에 있습니다.
	D:\hyeonbeom\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jsp1\org\apache\jsp
	실제 실행환경에서는 tomcat 폴더 안에서 바로 찾을 수 있습니다.
	
	webapp 폴더에 저장된 파일들은 jsp 제외하고 여기에 있습니다.
	D:\hyeonbeom\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
	실제 실행환경에서는 tomcat 폴더 안에서 바로 찾을 수 있습니다.
-->
