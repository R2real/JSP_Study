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
	<h2>JSTL TEST(출력의 종류)</h2>
	
	${"<script>alert('안녕');</script>"} 
	<!--el식 안의 명령문이 그대로 실행  -->
	<c:out value="<script>alert('안녕');</script>"></c:out> 
	<!--c:out안의 명령문이 String 형태로 나옴 -->
	 
</body>
</html>