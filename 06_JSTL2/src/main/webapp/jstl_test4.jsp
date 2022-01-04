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
	<h2>jstl_test(제어문-반복문)</h2>

	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"></c:out>&nbsp;&nbsp;
		</c:forEach>

	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i}"></c:out>&nbsp;&nbsp;
		</c:forEach>
	<br>
	<hr>
	<c:forEach var="i" begin="1" end="10" varStatus="status">
		index : <c:out value="${status.index}" />
		<br>
		count : <c:out value="${status.count}" />
		<br>
		begin : <c:out value="${status.begin}" />
		<br>
		end : <c:out value="${status.end}" />
		<br>
		step : <c:out value="${status.step}" />
		<br>
		first : <c:out value="${status.first}" />
		<br>
		<hr>
	</c:forEach>




</body>
</html>