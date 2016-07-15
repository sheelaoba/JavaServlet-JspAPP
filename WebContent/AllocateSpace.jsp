<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int userid=Integer.parseInt(request.getParameter("userid")); %>
<jsp:include page="AdminPage.jsp"/>
<br><br>
<div align="center">
<form method="post" action="./spaceAllocate">
<table>
<tr><td>Allocate Space:</td><td><input type="number" value="" name="aspace"/></td></tr>
<tr><td></td><td><input type="submit" value="submit"/></td></tr>
<tr><td><input type="hidden" value="<%=userid %>" name="userid"/>
</table>
</form>


</div>
</body>
</html>