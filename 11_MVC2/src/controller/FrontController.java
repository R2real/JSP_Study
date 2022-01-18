package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response); // 모든 get 방식에 대해서 actionDO 로 오도록 설정
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDO(request, response); // 모든 post 방식에 대해서 actionDO 로 오도록 설정
	}

	private void actionDO(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 요청을 파악
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		String command = uri.substring(cp.length());// uri에서 ContextPath를 제거

		ActionForward forward = null; // return 이 안된 forward는 null

		// 2. 각 요청에 대한 Controller 처리를 수행
		if (command.equals("/main.do")) {
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/board.do")) {
			try {
				forward = new BoardAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/insert.do")) {
			try {
				forward = new InsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/update.do")) {
			try {
				forward = new UpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/delete.do")) {
			try {
				forward = new DeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) { // 예외가 발생하면 null 일수도 있음 !
			if (forward.isRedirect()) { // forward.isRedirect() 가 T 라면, //NullPointException 발생 가능성이 있
										// 유지해야할 데이터가 없기 때문에 response.sendRedirect 로...
				response.sendRedirect(forward.getPath());
			} else {
				// pageContext.forward(); A 페이지에서 B 페이지까지만 데이터를 넘겨준다
				// 전달해야할 정보가 존재함을 의미
				// [RequestDispatcher API 를 사용] : 요청 재지정 기능을 구현해 주는 API
				// == 클라이언트의 요청에 대하여 서버의 다른 자원들로 그 요청을 처리하도록 재지정하는 것

				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
}
