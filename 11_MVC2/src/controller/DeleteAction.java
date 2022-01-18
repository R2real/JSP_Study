package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();
		dao.delete(vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do"); //경로 
		forward.setRedirect(true);  //방식 
		return forward;
	}

}
