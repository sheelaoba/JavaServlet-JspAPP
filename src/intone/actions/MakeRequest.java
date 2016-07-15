package intone.actions;

import intone.DAO.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MakeRequest
 */
@WebServlet("/MakeRequest")
public class MakeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("I am in make request servlet");
		
		HttpSession session=request.getSession();
		int userid=Integer.parseInt(String.valueOf( session.getAttribute("userid")));
		String uname=String.valueOf(session.getAttribute("username"));
		int reqspace=Integer.parseInt(request.getParameter("reqspace"));
		String reqdate=request.getParameter("reqdate");
		UserDAO dao=new UserDAO();
		int aspace=0;
		boolean flag=dao.makeRequest(userid,reqdate,reqspace,aspace);
			if(flag)
			{
				request.setAttribute("requeststatus", "request registered successfully");
				request.getRequestDispatcher("/reqRegistered.jsp").forward(request, response);
			}
			else
			{
				
			}
		}
		
		
	

}
