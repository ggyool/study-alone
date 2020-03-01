<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>${msg}</h1><br>
	<!-- 정답을 맞춘 경우 count를 지웠었다. -->
	<c:if test="${not empty sessionScope.count}">
		<h2>숫자를 입력해<br></h2>
		<form method="post" action="/guess">
			<input type="text" name="userInput" />
			<input type="submit" />
		</form>	
	</c:if>
	<a href="/guess">다시 하기</a> 
</body>
</html>