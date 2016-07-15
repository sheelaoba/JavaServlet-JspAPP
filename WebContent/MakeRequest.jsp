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
<form method="post" action="./makerequest">
<table>
<tr><td>Request Space:</td><td><input type="number" value="" name="reqspace"/></td></tr>
<tr><td>Request Date:</td><td><input type="text" value="" name="reqdate"/></td></tr>

<tr><td></td><td><input type="submit" value="submit"/></td></tr>
</table>
</form>

</div>
</body>
</html>