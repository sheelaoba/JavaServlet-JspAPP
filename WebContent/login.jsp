<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.html"/>
<br><br>

<div align="center">
<form action="./loginservlet" method="post">
<table>
<tr>User Login</tr>
<tr><td>Username:</td><td><input type="text" value="" name="uname" required/></td>
<tr><td>Password:</td><td><input type="password" value="" name="passwd" required/></td>
<tr><td></td><td><input type="submit" value="submit"/></td></tr>

</table>

</form>
</div>
</body>
</html>