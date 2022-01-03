<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
<jsp:useBean id="mdao" class="model.MemberDAO" />
<jsp:useBean id="mvo" class="model.MemberVO" />
<jsp:setProperty property="*" name="mvo"/>
 
<%
   request.setCharacterEncoding("UTF-8");
   String action=request.getParameter("action");

   if(action.equals("insert")){
      if(mdao.insert(mvo)){
         response.sendRedirect("testController.jsp?action=main");
      }
      else{
         System.out.println("insert 액션에서 문제발생!");
      }
   }
   else if(action.equals("main")){
      ArrayList<MemberVO> datas=mdao.select(mvo);
      request.setAttribute("datas", datas);
      pageContext.forward("test2.jsp");
   }
%>