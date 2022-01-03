<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<sql:query var="rs" dataSource="jdbc/mysql">
   select * from member
</sql:query>

<h2>데이터 목록</h2>
<hr>
<c:forEach var="v" items="${rs.rows}">
   mid: ${v.mid} <br>
   mpw: ${v.mpw} <br>
   mname: ${v.mname} <hr>
</c:forEach>

</body>
</html>