package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;

public class DeleteBAction implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      BoardDAO dao=new BoardDAO();
      BoardVO vo=new BoardVO();
      vo.setBid(Integer.parseInt(request.getParameter("bid")));
      dao.delete(vo);
      
      ActionForward forward=new ActionForward();
      forward.setPath("main.do");
      forward.setRedirect(false);
      return forward;
   }
   
}