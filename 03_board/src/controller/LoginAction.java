package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      MemberDAO dao=new MemberDAO();
      MemberVO vo=new MemberVO();
      vo.setMid(request.getParameter("mid"));
      vo.setMpw(request.getParameter("mpw"));
      
      ActionForward forward=null;
      if(dao.selectOne(vo)) {
         HttpSession session=request.getSession();
         session.setAttribute("mid", vo.getMid());
         
         forward=new ActionForward();
         forward.setPath("main.do");
         forward.setRedirect(false);
      }
      else {
    	 response.setContentType("text/html; charset=UTF-8");
         PrintWriter out=response.getWriter();
         out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
      }
      
      return forward;
   }

}
