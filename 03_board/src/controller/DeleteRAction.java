package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.ReplyVO;

public class DeleteRAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      BoardDAO dao=new BoardDAO();
      ReplyVO vo=new ReplyVO();
      vo.setRid(Integer.parseInt(request.getParameter("rid")));
      dao.deleteR(vo);
      
      String cnt=request.getParameter("cnt");
      int mcnt=2; // 최초에는 2개의 게시글을 볼수있음
      if(cnt!=null){
         mcnt=Integer.parseInt(cnt);
      }
      request.setAttribute("cnt", mcnt);
      
      ActionForward forward=new ActionForward();
      forward.setPath("main.do");
      forward.setRedirect(false);
      return forward;
   }

}