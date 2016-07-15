<%@ page language="java" import="java.util.*,intone.bean.UserBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<UserBean> list=(ArrayList)request.getAttribute("list");
Iterator<UserBean> ite=list.iterator();%>



<jsp:include page="UserEditPage.jsp"/>
<div align="center">
<form method="post" action="./updateProfile">
<table>


<% while(ite.hasNext())
{
	UserBean ub=ite.next();%>

<tr><td>FirstName:</td><td><input type="text" value="<%=ub.getFname() %>" name="fname"/></td></tr>
<tr><td>LastName:</td><td><input type="text" value="<%=ub.getLname() %>" name="lname"/></td></tr>
<tr><td>E-mail ID:</td><td><input type="email" value="<%=ub.getEmail() %>" name="email" /></td></tr>
<tr><td>ContactNo:</td><td><input type="text" value="<%=ub.getContactNo()%>" name="contactNo" pattern="[0-9]{10}"/> </td></tr>
<tr><td>Address:</td><td><input type="text" value="<%=ub.getAddress()%>" name="addr" /></td></tr>
<tr><td><input type="submit" value="Update"></input></td></tr>

<%}%>
</table>
</form>
</div>
</body>
</html>