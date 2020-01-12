<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--request.setAttribute("n", "10") --%>
<c:set var="n" scope="request" value="10" /> <%-- 꼭문자열 10을 줘여한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${n == 0 }">
	n과 0 은 같습니다.
</c:if>
<br>
<c:if test="${n == 10 }">
	n과 10 은 같습니다.
</c:if>
</body>
</html>