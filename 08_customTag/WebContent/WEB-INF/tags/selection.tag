<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<jsp:useBean id="sel" class="customTag.Selection" />

<h1><jsp:doBody /></h1>

<table border="${border}" bgcolor="${bgcolor}">
   <%
      for(String v:sel.getNameList()){
         out.println("<tr><td>"+v+"</tr></td>");
      }
   %>
</table>