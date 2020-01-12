<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> list = new ArrayList<>();
	list.add("hello");
	list.add("world");
	list.add("!@#$%");
	request.setAttribute("list",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- "${list }" 쌍따옴표에 주의 --%>
<c:forEach var="item" items="${list }" begin="1" end="2"> 
	${item } <br>
</c:forEach>
</body>
</html>