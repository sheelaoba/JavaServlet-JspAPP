package intone.actions;

import intone.connection.MyConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateUserProfile
 */
@WebServlet("/UpdateUserProfile")
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserProfile() {
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
		Connection con=null;
		PreparedStatement ps=null;
		HttpSession session=request.getSession();
		int userid=Integer.parseInt(String.valueOf(session.getAttribute("userid")));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String contactNo=request.getParameter("contactNo");
		String address=request.getParameter("addr");
		String message="";
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("update useraccounts set firstname=?,lastname=?,email=?,contactNo=?,address=? where userid=?");
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, contactNo);
			ps.setString(5, address);
			ps.setInt(6, userid);
			int res=ps.executeUpdate();
			if(res>0)
				message="updated successfully";
			else
				message="update failed";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			try {
				con.close();
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd=request.getRequestDispatcher("/UserProfileUpdateSuccess.jsp");
		rd.forward(request,response);
	}

}
