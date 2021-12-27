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

	<form>
		<select name="sel">
			<option>-</option>
			<option ${param.sel=='apple'?'selected':''}>apple</option>
			<option ${param.sel=='banana'?'selected':''}>banana</option>
			<option ${param.sel=='kiwi'?'selected':''}>kiwi</option>
		</select>
		<input type="submit" value="보내기">
	</form>
	<hr>
	<c:choose>
		<c:when test="${param.sel=='apple'}">
			사과
		</c:when>
		<c:when test="${param.sel=='banana'}">
			바나나
		</c:when>
		<c:when test="${param.sel=='kiwi'}">
			키위
		</c:when>
		<c:otherwise>
			선택사항 없음!
		</c:otherwise>
	</c:choose>


</body>
</html>