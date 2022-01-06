<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="lb" class="beans.LoginBean" />
<jsp:setProperty property="*" name="lb" />
<!-- setter 기능 자동화 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
	if(lb.check()){
		out.println("로그인 성공!");
	}else{
		out.println("<script>alert('로그인 실패!')</script>");
	}
	
	
	%>

	<!-- getter 두가지 방식 -->
	<jsp:getProperty property="uid" name="lb" /><br>
	<%=lb.getUpw()%>

</body>
</html>