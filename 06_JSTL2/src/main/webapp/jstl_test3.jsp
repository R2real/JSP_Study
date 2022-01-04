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
	<h2>JSTL TEST(제어문-조건)</h2>

	<c:set var="id">admin</c:set>

	<c:if test="${id eq 'admin'}">
		<!--test 속성에 조건식 -->
	현재 로그인된 계정은 <c:out value="${id}"></c:out>계정 입니다.
	</c:if>

	<c:if test="${id=='member'}">
		현재 로그인 된 계정은 일반 계쩡입니다.
	</c:if>

	<c:set var="id">khu7697</c:set>

	<c:choose> <!-- swith문 -->
		<c:when test="${id=='admin'}">
			관리자 
		</c:when>
		<c:when test="${id=='member'}">
			 회원 
		</c:when>
		<c:ortherwise>
			비회원 
		</c:ortherwise>
	</c:choose>
	
	

</body>
</html>