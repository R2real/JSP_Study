<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입 페이지</h2>
<form action="new.mem" method="post"> 
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid" required></td>
			<!-- 중복확인 비동기처리(페이지전환없이) ajax -->
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw" required></td>
			<!-- 비밀번호 이중체크,보안강도검사  비동기처리 유효성검사(정규식) -->
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="mname" required></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>