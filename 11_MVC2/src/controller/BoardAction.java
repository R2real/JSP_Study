package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class BoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO();
		
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO dao = new BoardDAO();   
		BoardVO data = dao.selectOne(vo);
		
		request.setAttribute("data",data);
		
		ActionForward forward = new ActionForward();
		forward.setPath("board.jsp"); //경로 
		forward.setRedirect(false);  //방식 
		return forward;
	}

}
