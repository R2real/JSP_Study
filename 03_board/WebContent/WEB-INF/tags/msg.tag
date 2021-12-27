<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="type" %>

 <!-- 코드의 유지보수에 대하여 확인하기!!! -->
<c:if test="${mid==null}">
   <c:choose>
      <c:when test="${type=='board'}">
         &nbsp;<input type="text" name="msg" disabled="disabled" value="로그인후에 글 등록이 가능합니다!" size="50">
      </c:when>
      <c:when test="${type=='reply'}">
         &nbsp;<input type="text" name="rmsg" disabled="disabled" value="로그인후에 댓글 등록이 가능합니다!" size="50">
      </c:when>
   </c:choose>
</c:if>

<c:if test="${mid!=null}">
   <c:choose>
      <c:when test="${type=='board'}">
         &nbsp;<input type="text" name="msg" placeholder="글 내용을 작성하세요." size="50">
         <input type="submit" value="글 등록">
      </c:when>
      <c:when test="${type=='reply'}">
         &nbsp;<input type="text" name="rmsg" placeholder="댓글 내용을 작성하세요." size="50">
         <input type="submit" value="댓글 등록">
      </c:when>
   </c:choose>
</c:if>