package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.member.MemberDAO;
import model.member.MemberVO;

public class NewAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      MemberDAO dao=new MemberDAO();
      MemberVO vo=new MemberVO();
      vo.setMid(request.getParameter("mid"));
      vo.setMname(request.getParameter("mname"));
      vo.setMpw(request.getParameter("mpw"));
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out=response.getWriter();
      if(dao.insert(vo)) {
         out.println("<script>alert('회원가입성공! 로그인하여 이용해주세요!:D');window.close();</script>");
      }
      else {
         out.println("<script>alert('회원가입실패!');history.go(-1);</script>");
      }      
      return null;
   }

}