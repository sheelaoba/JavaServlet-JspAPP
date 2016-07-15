<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="UserEditPage.jsp"/>
<div align="center">
<form method="post" action="./uploadFile" enctype="multipart/form-data">
<table>
<tr><td>Enter FileName:</td><td><input type="text" value="" name="filename" required/></td></tr>
<tr><td>Choose File:</td><td><input type="file" name="profile" required/></td></tr>
<tr><td><input type="submit" value="submit"/></td></tr>
</table>
</form>
</div>
</body>
</html>