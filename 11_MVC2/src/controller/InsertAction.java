package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.BoardDAO;
import model.BoardVO;

public class InsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		
		BoardDAO dao = new BoardDAO();		
		dao.insert(vo);
		
		ArrayList<BoardVO> datas = dao.selectAll(); // main.jsp 로 바로 보내기에 필요한 로직 
		request.setAttribute("datas",datas);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");//forward.setPath("main.do"); 로 설정하면 로직상 틀린 것은 아니지만 fc를 거치면서 요청헤더정보가 변경될 수 있음.//Spring에서는 요청해더정보를 유지해주는 api가 존재
		forward.setRedirect(false); 
		return forward;
	}
}
