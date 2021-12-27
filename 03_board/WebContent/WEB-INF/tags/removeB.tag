<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="rmid" %>
<%@ attribute name="bid" %>

<c:if test="${rmid==mid}">
	<a href="deleteB.do?bid=${bid}">[삭제]</a>
</c:if>
&nbsp;&nbsp;<a href="fav.do?cnt=${cnt}&bid=${bid}">♥</a>