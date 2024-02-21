<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12 fmt(format)</title>
</head>
<body>
	<h3>주로 사용되는 fmt 태그의 서식 테스트</h3>
	<hr>
	<!-- formatNumber는 서식 있는 출력과 저장 동작 , value에는 값을 직접 또는 el -->
    <fmt:formatNumber  value="9999999"/> <br>  
    <!-- fmt:parseNumber는 변수에 저장.  -->
    <fmt:parseNumber var="test"  value="8888888"/> 
    test : <c:out value="${test}"/> <br>  <!-- 서식 없는 출력 -->
    <!-- 현재 locale : ko_kr 표기는 언어_국가 형식 ￦ -->
    <fmt:formatNumber  value="9999999"  type="currency"/><br> 
    <!--  locale 변경 : en_us -->
    <fmt:setLocale value="en_us"/>  
    <fmt:formatNumber  value="9999999"  type="currency"/><br> 
    <!-- type: 화폐단위 , 퍼센트(percent) 등 표시 , 
        pattern : 직접 소수점 이하, 전체 자리수 지정-->
    <!-- 789,789.123 기본패턴:소수점 최대 3자리 -->
    <fmt:formatNumber value="789789.12345" /><br>  
     <!-- 789,789.12 -->
    <fmt:formatNumber value="789789.12345" pattern="#,###.##"/><br> 
    <fmt:formatNumber value="789789.123" pattern="0000,000,000.00000"/><br>
    <!-- fmt:formatXXXX : 출력과 변수에 저장-->
    <!-- fmt:parseXXXX : 변수에 저장 -->
    
    <hr>
   
    <!-- 화폐, 날짜는 locale에 다라 출력이 다릅니다. -->
    <!-- 날짜 패턴에 대소문자 유의 : 일 dd, 월 MM , 분 mm , 시(12) hh , 시(24) HH -->
    <!-- now 어트리뷰트 값 : 여기서는 테스트 위해서 자바 객체로 생성합니다. -->
    <fmt:setLocale value="ko_kr"/>
	<c:set var="now" value="<%= new java.util.Date() %>" />
    <fmt:formatDate value="${now}" /><br>  
    <!--
    	parseDate의 pattern은 value 값의 형식을 알려줍니다.
    	패턴이 없으면 날짜 타입으로 변환을 못합니다. (문자열을 날짜 타입으로 캐스팅)
    -->
    <fmt:parseDate value="2022-11-03 20:14" var="datetime1" 
               pattern="yyyy-MM-dd HH:mm"/> 
     현재시간과 날짜 : <c:out value="${datetime1}"/> <br>
    <fmt:formatDate value="${datetime1}" type="date"/><br>
    <fmt:formatDate value="${datetime1}" type="time"/><br>
    <fmt:formatDate value="${datetime1}" type="both"/><br>
    <fmt:formatDate value="${datetime1}" pattern="yyyy-MM-dd HH:mm:ss"/><br> 
    <!-- 시간이 24시 기준(HH)-->
    <fmt:formatDate value="${datetime1}" pattern="yyyy-MM-dd a hh:mm:ss"/><br>
    <!-- 시간이 12시 기준(hh). a는 오전/오후 표시-->
</body>
</html>