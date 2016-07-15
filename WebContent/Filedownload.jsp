<%@page import="intone.connection.MyConnection"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Connection con=null;
PreparedStatement ps=null;
con=MyConnection.getConnection();
int userid=Integer.parseInt(request.getParameter("id"));
ps=con.prepareStatement("select filedata,filename from userstorage where userid=?");
ps.setInt(1,userid);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
Blob b=rs.getBlob(1);
String name=rs.getString(2);
String filename=null;
filename+=".doc";
byte[] ba=b.getBytes(1,(int)b.length());
response.setContentType("application/msword");
response.setHeader("content-Disposition","attachment:filename=\""+filename+"\"");
OutputStream os=response.getOutputStream();
os.write(ba);
os.close();
ba=null;}%>
</body>
</html>