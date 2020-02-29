<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	count : ${count} <br>
	answer : ${answer }<br>
	userInput : ${userInput}<br>
	<c:if test="${count eq 0}">	
		<h1>안녕! 1~100 숫자를 뽑았어. 맞춰봐!</h1><br>
	</c:if>
	
	<c:if test="${not (count eq 0)}">
		<c:if test="${answer eq userInput}">
			<h1>정답이야!  ${count}번 걸렸어!</h1>
			<% session.invalidate(); %>
		</c:if>
		<c:if test="${answer gt userInput}">
			<h1>정답보다 작아!</h1>
		</c:if>
		<c:if test="${answer lt userInput}">
			<h1>정답보다 커!</h1>
		</c:if>
		<br>
	</c:if>
	
	<h2>숫자를 입력해<br></h2>
	<form method="post" action="/guess">
		<input type="text" name="userInput" />
		<input type="submit" />
	</form>
	
	<a href="/guess">다시 하기</a> 
	
</body>
</html>