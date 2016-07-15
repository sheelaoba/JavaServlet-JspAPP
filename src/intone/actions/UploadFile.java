package intone.actions;

import intone.DAO.UserDAO;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@MultipartConfig(maxFileSize=16177215)
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
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
		HttpSession session =request.getSession();
		int userid=Integer.parseInt(String.valueOf(session.getAttribute("userid")));
		String filename=request.getParameter("filename");
		Part filepart=request.getPart("profile");
		
		InputStream is=filepart.getInputStream();
		
	
		UserDAO dao=new UserDAO();
		boolean flag=dao.InsertFile(userid,filepart,is,filename);
		
		if(flag)
		{
			request.getRequestDispatcher("/GetUserFiles.jsp").forward(request, response);
		}
		else
		{
			System.out.println("cannot upload");
			request.setAttribute("message", "You have no enough space.Please make a request to admin");
			request.getRequestDispatcher("/GetUserFiles.jsp").forward(request, response);
		}
	}

	

}
