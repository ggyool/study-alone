<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<%
	Integer na = (Integer)request.getAttribute("na");
	Integer nb = (Integer)request.getAttribute("nb");
%>
	<h1>
		<%=na %> + <%=nb %> = <%=(na+nb) %>
	</h1>
--%>

 <%--<h1>  ${na } + ${nb } = ${na+nb } </h1> --%>

<%
Integer na = (Integer)session.getAttribute("na");
Integer nb = (Integer)session.getAttribute("nb");
%>
<h1>
	<%=na %> + <%=nb %> = <%=(na+nb) %>
</h1>
</body>
</html>