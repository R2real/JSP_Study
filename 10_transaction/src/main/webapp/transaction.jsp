<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="b1" class="model.Bank1"/>
<jsp:useBean id="b2" class="model.Bank2"/>

<%
	if(request.getMethod().equals("POST")){
			//get방식으로(==url요청으로) 호출한 것이 아닐때에만 계좌이체 수행!!
			if(b1.transfer(Integer.parseInt(request.getParameter("balance")))){
				out.println("<script>alert('이체성공!')</script>");
			}else{
				out.println("<script>alert('이체패 ! 잔액을 확인해보세요!!')</script>");
			}
	}

	b1.select();
	b2.select();
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${b1.name} 계좌상태</h2>
	잔액 : ${b1.balance}원
	<hr>

	<h2>${b2.name} 계좌상태</h2>
	잔액 : ${b2.balance}원
	<hr>

	<form method="post">
		계좌이체할 금액 :
		<input type="text" name="balance">
		<input type="submit" value="계좌이체!">
	</form>
</body>
</html>