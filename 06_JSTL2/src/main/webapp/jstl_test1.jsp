<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL TEST(변수)</h2>
	<c:set var="name" value="홍길동" scope="page"/>
	<c:out value="${name}"/>
	<!--  $를 출력하고 싶을 때에는 \$ 또는 $dollar;를 사용한 -->
	<br>
	<hr>
	<c:set var="nation" scope="session">한국</c:set>
	<c:remove var="nation" scope="session"/>
	nation 삭제 후 값은 >> [<c:out value="${nation}" default="미국"/>] >> 변수 값이 삭제 
	<br>
	
	<c:set var="data1" value="10"/>
	<c:set vat="data2" value="20"/>
	
	
		
</body>
</html>