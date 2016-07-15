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
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String AdminUname=request.getParameter("adminUname");
		String AdminPwd=request.getParameter("adminPwd");
		UserDAO dao=new UserDAO();
		HttpSession session=request.getSession();
		boolean flag=dao.checkAdminLogin(AdminUname,AdminPwd);
		System.out.println("flag="+flag);
		if(flag)
		{
			session.setAttribute("AdminUname", AdminUname);
			request.getRequestDispatcher("/AdminPage.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
