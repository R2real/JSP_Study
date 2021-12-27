package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController2
 */
@WebServlet("/FrontController2")
public class FrontController2 extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController2() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request,response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request,response);
   }

   private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String uri=request.getRequestURI();
      String cp=request.getContextPath();
      String command=uri.substring(cp.length());
      
      ActionForward forward=null;
      if(command.equals("/new.mem")) {
        try {
			forward=new NewAction().execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
      else if(command.equals("/login.mem")) {
         try {
            forward=new LoginAction().execute(request, response);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      else if(command.equals("/logout.mem")) {
    	  try {
			forward=new LogoutAction().execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
      }
      
      if(forward!=null) {
         if(forward.isRedirect()) {
            response.sendRedirect(forward.getPath());
         }
         else {
            RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
         }
      }
      
   }
   
}