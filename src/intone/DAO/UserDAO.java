package intone.DAO;

import intone.bean.RequestBean;
import intone.bean.UserBean;
import intone.connection.MyConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.Part;

public class UserDAO {
	
	public int ValidateUser(String uname, String passwd)
	{
		PreparedStatement ps=null;
		int retval=0;
		System.out.println("uname="+uname);
		System.out.println("passwd="+passwd);
		try {
			Connection con=MyConnection.getConnection();
			ps=con.prepareStatement("select * from useraccounts where username=? and password=?");
			System.out.println(ps);
			ps.setString(1,uname);
			ps.setString(2,passwd);
			ResultSet res=ps.executeQuery();
			//System.out.println("res="+res);
		
			int count=0;
			if(res.next())
			{
				System.out.println("hello");
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3));
				count=res.getInt(1);
				//System.out.println("count="+count);
				
			}
			
			if(count>0)
			{
				
				retval=res.getInt(1);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retval;
		
	}
	
	public ArrayList<UserBean> getUserDetails(String uname)
	{
		Connection con;
		PreparedStatement ps=null;
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		UserBean ub=new UserBean();
		try {
		con=MyConnection.getConnection();
		ps=con.prepareStatement("select username,password,firstname,lastname,email,contactNo,Address from useraccounts where username=?");
		ps.setString(1, uname);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			
				ub.setUname(rs.getString(1));
				ub.setPasswd(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setContactNo(rs.getString(6));
				ub.setAddress(rs.getString(7));
				list.add(ub);
			
		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
		}
	
	public Vector CheckBeforeRequest(int userid)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int aspace=0;
		int rspace=0;
		int nouser=-1;
		System.out.println("in check b req userid="+userid);
		Vector v=new Vector();
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("select requestedspace,allocatedspace from requestprocess where userid=?");
			ps.setInt(1,userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				rspace=rs.getInt(1);
				aspace=rs.getInt(2);
				System.out.println("rspace="+rspace);
				System.out.println("aspace="+aspace);
				v.add(rspace);
				v.add(aspace);
			
			}
			else
			{
				v.add(aspace);
				v.add(rspace);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	public boolean UpdateExistingSpace(int userid,int reqspace,String reqdate)
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean flag=false;
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("update requestprocess set requestedspace=?,requestdate=?,request=? where userid=?");
			ps.setInt(1, reqspace);
			ps.setString(2, reqdate);
			ps.setString(3, "Accept");
			ps.setInt(4, userid);
			int res=ps.executeUpdate();
			if(res>0)
			{
				flag=true;
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public int CheckRequestStatus(int userid,String uname)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs,rs1=null;
		boolean flag=false;
		int aspace;
		int rspace;
		int retval=-1;
		System.out.println("iam in check request status");
		con=MyConnection.getConnection();
		try
		{
			
			ps=con.prepareStatement("select requestedspace,allocatedspace from requestprocess where userid=?");
			ps.setInt(1, userid);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				rspace=rs.getInt(1);
				aspace=rs.getInt(2);
				if(aspace>0 &&rspace==0)
				{
					retval=1;
					
				}
				else if(rspace>0 && (aspace==0||aspace>0))
				{
					retval=0;
					
				}
				
			}
		//	System.out.println("aspace="+rs.getInt(1));
			
			
					
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return retval;
	}
	
	public boolean makeRequest(int userid,String reqdate,int reqspace,int aspace)
	{
	System.out.println("aspace="+aspace);
		Connection con=null;
		PreparedStatement ps=null;
		boolean flag=false;
		con=MyConnection.getConnection();
		try {
			
			ps=con.prepareStatement("insert into requestprocess values(seq_request.nextval,?,?,?,?,?)");
		
			ps.setInt(1,userid);
			ps.setString(2,reqdate);
			ps.setInt(3, reqspace);
			ps.setInt(4, 0);
			ps.setString(5,"Accept");
			int res=ps.executeUpdate();
			if(res>0)
			{
				System.out.println("Requested submitted");
				flag=true;
			}
			else
			{
			
				System.out.println("Error");
				flag=false;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public boolean CheckUserSpace(int userid)
	{
		System.out.println(" am in Check user space="+userid);
		Connection con=null;
		PreparedStatement ps=null;
		boolean flag=false;
		try
		{
			con=MyConnection.getConnection();
						
			ps=con.prepareStatement("select allocatedspace from userspaces where userid=?");
			ps.setInt(1, userid);
			ResultSet rs=ps.executeQuery();
			
			int aspace=0;
			if(rs.next())
			{
				aspace=rs.getInt(1);
				System.out.println("aspace="+aspace);
				if(aspace>0)
				{
					flag=true;
				}
				
			}
					
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public boolean InsertFile(int userid,Part filepart,InputStream inputstream,String filename)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		boolean flag=false;
		int aspace=0;
		int dspace=0;
		try
		{
			con=MyConnection.getConnection();
			ps1=con.prepareStatement("select allocatedspace from userspaces where userid=?");
			ps1.setInt(1, userid);
			ResultSet rs=ps1.executeQuery();
			if(rs.next())
			{
				aspace=rs.getInt(1);
				if(aspace>filepart.getSize())
				{
			
					ps=con.prepareStatement("insert into userstorage values(seq_userstorage.nextval,?,?,?,?)");
					ps.setInt(1, userid);
					ps.setString(2,filename);
					ps.setDouble(3,filepart.getSize());
					ps.setBinaryStream(4,inputstream,(int)filepart.getSize());
					int res=ps.executeUpdate();
					if(res>0)
					{
						dspace=aspace-(int)filepart.getSize();
						ps2=con.prepareStatement("update set r.allocatedspace=?,u.allocatedspace=? from requestprocess r,userspaces u where (r.userid=u.userid)=?");
						ps2.setInt(1,dspace);
						ps2.setInt(2,dspace);
						ps2.setInt(3, userid);
						int res1=ps2.executeUpdate();
						if(res1>0)
						{						
							flag=true;
						}
					}
					
				}
				else
				{
					flag=false;
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<RequestBean> getAllUserRequests()
	{
		ArrayList<RequestBean> list=new ArrayList<RequestBean>();
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("select * from requestprocess where request=?");
			ps.setString(1, "Accept");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				RequestBean bean=new RequestBean();
				bean.setReqid(rs.getInt(1));
				bean.setUserid(rs.getInt(2));
				bean.setRequestdate(rs.getString(3));
				bean.setRequestedspace(rs.getInt(4));
				bean.setAllocatedspace(rs.getInt(5));
				bean.setRequest(rs.getString(6));
				list.add(bean);
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<RequestBean> getAllReqsCompleted()
	{
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<RequestBean> list=new ArrayList<RequestBean>();
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("select * from requestprocess where request=?");
			ps.setString(1, "Accepted");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				RequestBean bean=new RequestBean();
				bean.setReqid(rs.getInt(1));
				bean.setUserid(rs.getInt(2));
				bean.setRequestdate(rs.getString(3));
				bean.setRequestedspace(rs.getInt(4));
				bean.setAllocatedspace(rs.getInt(5));
				bean.setRequest(rs.getString(6));
				list.add(bean);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean checkAdminLogin(String uname,String passwd)
	{
		Connection con=null;
		PreparedStatement ps=null;
		boolean flag=false;
		String dbuname = null;
		String dbpwd=null;
		System.out.println("un="+uname+ " "+passwd);
		try
		{System.out.println("I am in checkadminlogin");
			con=MyConnection.getConnection();
			ps=con.prepareStatement("select count(*) from adminaccount where username=? and password=?");
			ps.setString(1,uname);
			ps.setString(2,passwd);
			ResultSet rs=ps.executeQuery();
			
		/*	//if(rs.next())
			//{
				dbuname=rs.getString(1);
				dbpwd=rs.getString(2);
			//}
			System.out.println("db="+dbuname+" "+dbpwd);
			if(dbuname.equals(uname) && dbpwd.equals(passwd))
			{
				flag=true;
			}*/
			int count=0;
			while(rs.next())
			{
				System.out.println("result="+rs.getInt(1));
				count=rs.getInt(1);
			}
			if(count>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean updateSpace(int userid,int aspace)
	{
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		boolean flag=false;
		
		try
		{
			con=MyConnection.getConnection();
			ps=con.prepareStatement("update requestprocess set allocatedspace=?,request=?,requestedspace=? where userid=?");
			ps.setInt(1, aspace);
			ps.setString(2, "Accepted");
			ps.setInt(3, 0);
			ps.setInt(4,userid);
			int res=ps.executeUpdate();
			if(res>0)
			{
				ps2=con.prepareStatement("insert into userspaces values(?,?)");
				ps2.setInt(1,userid);
				ps2.setInt(2, aspace);
				int res1=ps2.executeUpdate();
				if(res1>0)
				{
					flag=true;
				}
			}
			
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	

}
