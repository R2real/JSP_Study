package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		
		BoardDAO dao = new BoardDAO();
		dao.update(vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do"); //경로 
		forward.setRedirect(true);  //방식 
		return forward;
	}
}
