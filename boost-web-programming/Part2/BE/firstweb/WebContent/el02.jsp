<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "true" %>
<%
request.setAttribute("k", 10);
request.setAttribute("m", true);
int a = 10;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	k : ${k } <br>
	k + 5: ${k+5 } <br>
	k / 5: ${k / 5 } <br>
	k / 5: ${k div 5 } <br>
	
	m : ${m } <br>
	m : ${!m } <br>
	a : <%=a %> <br>
</body>
</html>
