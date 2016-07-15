<%@page import="intone.connection.MyConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GetUserFiles</title>
</head>
<body>
<jsp:include page="UserEditPage.jsp"></jsp:include>
<%String msg=String.valueOf(request.getAttribute("message"));
if(msg==null)
{%>document.getElementById("mainbody").style.display="block";
<%}else{out.println(msg);} %>
<div align="center" style="display:none">
<table border="1">
<tr>
<th>UserId</th>
<th>FileName</th>
<th>FileSize</th>
<th>FileData</th>
</tr>
<%Connection con=null;
PreparedStatement ps=null;
con=MyConnection.getConnection();
ps=con.prepareStatement("select userid,filename,filesize from userstorage");
ResultSet rs=ps.executeQuery();
while(rs.next())
{int id=rs.getInt(1);%>
<tr>
<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getFloat(3) %></td>
<td><a href="Filedownload.jsp?id=<%=id %>">view</a></td>
</tr>
<%} %>
</table>
</div>

</body>
</html>