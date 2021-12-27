<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<c:choose>
   <c:when test="${mid == null}">
      <form method="post" action="login.mem">
      ID: <input type="text" name="mid" required>  PW: <input type="password" name="mpw" required>  <input type="submit" value="LOGIN">
      </form>
   </c:when>
   <c:otherwise>
      <form method="post" action="logout.mem">
      ${mid}님 환영합니다! <input type="submit" value="LOGOUT">
      </form>
   </c:otherwise>
</c:choose>

<!-- 1. form을 각각의 상황에 대해 사용할수있도록 분리 -->
<!-- 2. action파라미터를 이용 -->