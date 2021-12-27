<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<c:forEach var="v" items="${datas}">
		<tr>
			<td><c:out value="${v.name}"/></td>
			<td><c:out value="${v.phone}" escapeXml="false"><font color="red">핸드폰번호가 기재되어있지않습니다!</c:out></td>			
		</tr>
		</c:forEach>
	</table>

</body>
</html>