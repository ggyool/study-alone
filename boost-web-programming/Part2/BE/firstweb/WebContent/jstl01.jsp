<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="value1" scope="request" value="request value">
</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
value1 : ${value1 } <br>
<c:remove var="value1" scope="request" />
value1 : ${value1 } <br>
</body>
</html>