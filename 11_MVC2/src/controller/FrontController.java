package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * Servlet implementation class FrontController
 */
//사용자의 모든 요청을 FC로 향하게 해야함 !! web.xml을 통해 frontController로 바꿔놓음 
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response); //모든 get 방식에 대해서 actionDO 로 오도록 설정
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response); //모든 post 방식에 대해서 actionDO 로 오도록 설정
	}

	
	private void actionDO (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1. 요청을 파악
	String uri = request.getRequestURI();
	String cp = request.getContextPath();
	String command = uri.substring(cp.length());// uri에서 ContextPath를 제거 
	
	ActionForward forward = null;
	
	// 2. 각 요청에 대한 Controller 처리를 수행 
	if(command.equals("/main.do")){
		try{
		forward = new MainAction().execute(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	else if(command.equals("/board.do")) {
		try{
			forward = new BoardAction().execute(request,response);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
	
	}
}
