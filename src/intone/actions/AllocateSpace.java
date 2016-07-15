package intone.actions;

import intone.DAO.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllocateSpace
 */
@WebServlet("/AllocateSpace")
public class AllocateSpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateSpace() {
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
		int userid=Integer.parseInt(request.getParameter("userid"));
		System.out.println("I am in allocate space");
		System.out.println("userid="+userid);
		int aspace=Integer.parseInt(request.getParameter("aspace"));
		UserDAO dao=new UserDAO();
		boolean flag=dao.updateSpace(userid,aspace);
		if(flag)
		{
			request.setAttribute("message", "User Allocated Space Successfully");
			request.getRequestDispatcher("/userAllocatedSpace.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("message", "User Space Allocation UnSuccessfull");
			request.getRequestDispatcher("/userAllocatedSpace.jsp").forward(request, response);
		}
	}

}
