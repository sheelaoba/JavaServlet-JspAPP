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
 * Servlet implementation class RequestStatus
 */
@WebServlet("/RequestStatus")
public class RequestStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in request status");
		HttpSession session=request.getSession();
		String uname=String.valueOf(session.getAttribute("username"));
		int userid=Integer.parseInt(String.valueOf(session.getAttribute("userid")));
		
		System.out.println("uid="+userid+ " "+"uname="+uname);
		UserDAO dao=new UserDAO();
		int retval=dao.CheckRequestStatus(userid,uname);
		System.out.println("Retval="+retval);
		if(retval==1)
		{
			request.setAttribute("requeststatus","Request Accepted");
			request.getRequestDispatcher("/reqRegistered.jsp").forward(request, response);
		}
		if(retval==0)
		{
			request.setAttribute("requeststatus","Request is under process");
			request.getRequestDispatcher("/reqRegistered.jsp").forward(request, response);
		}
		if(retval==-1)
		{
			request.setAttribute("requeststatus","No space allocared to user,please make a request to admin");
			request.getRequestDispatcher("/reqRegistered.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
