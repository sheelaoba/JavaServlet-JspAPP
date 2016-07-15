<%@ page language="java" import="java.util.*,intone.bean.RequestBean" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="AdminPage.jsp"/>
<br><br>
<div align="center">
<table border="1">
<tr>
<th>RequestID</th>
<th>UserID</th>
<th>AllocatedSpace</th>
<th>Request</th>
</tr>

<%ArrayList<RequestBean> list=(ArrayList)request.getAttribute("list"); 
Iterator<RequestBean> ite=list.iterator();
while(ite.hasNext()){
RequestBean bean=ite.next();%>

<tr>
<td><%=bean.getReqid() %></td>
<td><%=bean.getUserid() %></td>
<td><%=bean.getAllocatedspace() %></td>
<td><%=bean.getRequest() %></td>
</tr>
<%} %>
</table>
</div>
</body>
</html>