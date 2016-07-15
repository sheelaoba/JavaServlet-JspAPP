package intone.actions;

import intone.DAO.UserDAO;

import java.io.IOException;


import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckBeforeRequest
 */
@WebServlet("/CheckBeforeRequest")
public class CheckBeforeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBeforeRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int userid=Integer.parseInt(String.valueOf(session.getAttribute("userid")));
		UserDAO dao=new UserDAO();
		Vector v=dao.CheckBeforeRequest(userid);
		int rspace=(int)v.get(0);
		int aspace=(int)v.get(1);
		System.out.println("rspace and aspace="+rspace+" "+aspace);
		if(rspace>0)
		{
			//request.setAttribute("message", "You Have a current Request under process");
			request.getRequestDispatcher("/ErrorRequest.jsp").forward(request, response);
			
		}
		if(aspace>0 && rspace==0)
		{
			request.setAttribute("aspace", aspace);
			request.getRequestDispatcher("/ConfirmRequest.jsp").forward(request, response);
		}
		else if(aspace==0 && rspace==0)
		{
			System.out.println("aspace is not allocated");
			request.getRequestDispatcher("/MakeRequest.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
