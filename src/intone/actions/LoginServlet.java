package intone.actions;

import intone.DAO.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("hello");
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("passwd");
		UserDAO dao=new UserDAO();
	
		HttpSession session=request.getSession();
		System.out.println("i am in loginvalidate servlet");
		int userid=dao.ValidateUser(uname,passwd);
		System.out.println("flag="+userid);
		if(userid>0)
		{
		//	session.setAttribute("message","Welcome");
			session.setAttribute("username", uname);
			session.setAttribute("userid", userid);
			
			response.sendRedirect("UserEditPage.jsp");
		}
		
		else
		{
		//	message="Invalid Username/Password";
			response.sendRedirect("InvalidUser.html");
		}
		
	}
	

}
