<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" errorPage="error.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="model.BoardDAO" />
<jsp:useBean id="vo" class="model.BoardVO" />
<jsp:setProperty property="*" name="vo"/>
<%
   // index C에게 main페이지 요청
   // C main페이지는 ... 데이터가 있어야되는데...
   //       M 데이터 가져와.
   //       DB연동하여 데이터가져옴
   // C main페이지 완성됬으니까 가져가서보여줘
   // V main페이지 사용자에게 보여줌(브라우저V)
   
   String action=request.getParameter("action");

   if(action.equals("main")){
      ArrayList<BoardVO> datas=dao.selectAll();
      // 1. M에게서 데이터를 확보
      request.setAttribute("datas", datas);
      // 2. V한테 데이터를 전달
      pageContext.forward("main.jsp");
   }
   else if(action.equals("board")){
      // 상세페이지보여줘!
      // 1. M에게서 데이터를 확보
      BoardVO data=dao.selectOne(vo);
      // 2. V한테 데이터를 전달
      System.out.println("로그 : " + data);
      /*if(data==null){
    	  response.sendRedirect("controller.jsp?action=main");
      }else{*/
      request.setAttribute("data", data);
      pageContext.forward("board.jsp");
      /*}*/
      
   }else if(action.equals("insert")){
	 if(dao.insert(vo)){
		 //다음페이지로
		 response.sendRedirect("controller.jsp?action=main");
		 
	 };
	 	throw new Exception("insert 수행중에 오류 발생!");
	   
   }else if(action.equals("delete")){
		 if(dao.delete(vo)){
			 response.sendRedirect("controller.jsp?action=main");
			 
		 };
		 	throw new Exception("delete 수행중에 오류 발생!");
   }else if(action.equals("update")){
		 if(dao.update(vo)){ //CRUD 비지니스 메서드의 인자로 VO 객체를 사용하는 것은 Spring 식
			 response.sendRedirect("controller.jsp?action=main");
			 
		 };
		 	throw new Exception("update수행중에 오류 발생!");
		 	}else{
      out.println("<script>alert('action파라미터의 값이 올바르지않습니다!')</script>");
   }
%>