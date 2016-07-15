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
 * Servlet implementation class UpdateExistingUserSpace
 */
@WebServlet("/UpdateExistingUserSpace")
public class UpdateExistingUserSpace extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExistingUserSpace() {
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
		HttpSession session=request.getSession();
		int userid=(Integer.parseInt(String.valueOf(session.getAttribute("userid"))));
		int reqspace=Integer.parseInt(request.getParameter("reqspace"));
		String reqdate=request.getParameter("reqdate");
		UserDAO dao=new UserDAO();
		boolean flag=dao.UpdateExistingSpace(userid,reqspace,reqdate);
		if(flag)
		{
			request.setAttribute("message", "Success");
			request.getRequestDispatcher("/Success.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Failed");
		}
	}

}
