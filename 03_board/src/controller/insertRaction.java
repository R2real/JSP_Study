package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardVO;
import model.board.ReplyVO;

public class insertRaction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyVO rvo = new ReplyVO();
		rvo.setBid(Integer.parseInt(request.getParameter("bid")));
		rvo.setMid(request.getParameter("mid"));
		rvo.setRmsg(request.getParameter("rmsg"));
		
		BoardDAO dao = new BoardDAO();
		dao.insertR(rvo);
		
	      String cnt=request.getParameter("cnt");
	      int mcnt=2; // 최초에는 2개의 게시글을 볼수있음
	      if(cnt!=null){
	         mcnt=Integer.parseInt(cnt);
	      }
	      request.setAttribute("cnt", mcnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
