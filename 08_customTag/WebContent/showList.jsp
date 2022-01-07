<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="nl" class="customTag.Selection" />
<form action="showResult.jsp" method="post">
   <select name="cname">
      <%
         for(String v:nl.getNameList()){
            out.println("<option>"+v+"</option>");
         }
      %>
   </select>
   <input type="submit" value="캐릭터 선택완료">
</form>

</body>
</html>