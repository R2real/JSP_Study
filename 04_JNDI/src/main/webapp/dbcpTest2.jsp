<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,javax.sql.*,javax.naming.*"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   Connection conn=null;
   PreparedStatement pstmt=null;
   //JDBCUtil과 동일한 부분
   
   try{
   Context initContext=new InitialContext();
   Context envContext=(Context)initContext.lookup("java:comp/env");
   DataSource ds=(DataSource)envContext.lookup("jdbc/mysql");
   // 유지보수
   
   conn=ds.getConnection();
   if(request.getParameter("mid")!=null){ // 한 페이지내에서 코딩중이라서 추가된 부분!
      String sql="insert into member values(?,?,?)";
      pstmt=conn.prepareStatement(sql);
      pstmt.setString(1, request.getParameter("mid"));
      pstmt.setString(2, request.getParameter("mpw"));
      pstmt.setString(3, request.getParameter("mname"));
      pstmt.executeUpdate();
   }
   }catch(Exception e){
      System.out.println("예외발생!");
   }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>회원가입 페이지</h2>
<form action="dbcpTest2.jsp" method="post">
   <table border="1">
      <tr>
         <td>아이디</td>
         <td><input type="text" name="mid" required></td>
         <!-- 중복확인 비동기처리(페이지전환없이) ajax -->
      </tr>
      <tr>
         <td>비밀번호</td>
         <td><input type="password" name="mpw" required></td>
         <!-- 비밀번호 이중체크,보안강도검사  비동기처리 유효성검사(정규식) -->
      </tr>
      <tr>
         <td>이름</td>
         <td><input type="text" name="mname" required></td>
      </tr>
      <tr>
         <td colspan="2" align="right"><input type="submit" value="회원가입"></td>
      </tr>
   </table>
</form>
<br>
<hr>
<br>
<h2>데이터 목록</h2>
<hr>
<%
   try{
      String sql="select mname from member";
      pstmt=conn.prepareStatement(sql);
      ResultSet rs=pstmt.executeQuery();
      while(rs.next()){
         out.println(rs.getString(1)+"<br>");
      }
      
      rs.close();
      pstmt.close();
      conn.close();
   }catch(Exception e){
      System.out.println("예외발생!");
   }
%>

</body>
</html>