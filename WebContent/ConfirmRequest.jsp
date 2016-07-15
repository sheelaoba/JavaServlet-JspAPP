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
<br><br>
<div align="center">
<table>
<tr><td>You are allocated with space &nbsp;<%=request.getAttribute("aspace") %></td></tr>
<tr><td>Do You want to request Again.Please choose an option below.</td></tr>
<tr><td><input type="button" value="YES" onclick="showHidden()"/>&nbsp;&nbsp;
<a href="UserEditPage.jsp"/>Home</a></td></tr>
</table>
</div>
<br><br>

<div id="hiddenfield" align="center" style="display:none">
<form method="post" action="updateExisting">
<table>
<tr><td>Request Space:</td><td><input type="number" value="" name="reqspace"/></td></tr>
<tr><td>Request Date:</td><td><input type="text" value="" name="reqdate"/></td></tr>
<tr><td></td><td><input type="submit" value="submit"/></td></tr>
</table>
</form>
</div>

<script>
function showHidden()
{alert("hello");
	document.getElementById("hiddenfield").style.display="block";
	}
</script>
</body>
</html>