<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register TODO</title>
<link rel="stylesheet" href="./todo.css">
</head>
<body>
	<div id="content">
		<div id="content-blank"></div>
		<div id="content-header">
			<h1 id="content-title">할일 등록</h1>
		</div>
		<div id="content-body-wrapper">
			<div id="content-body">
			<form method="post" action="../todo">
				<p class="content-question">어떤일인가요?</p>
				<input type="text" id="content-input-title" 
				name="title" maxlength=24 size=60 autofocus required>
				
				<p class="content-question">누가 할일인가요?</p>
				<input type="text" id="content-input-name" 
				name="name" maxlength=12 size=40 required>
				
				<p class="content-question">우선순위를 선택하세요</p>
				<input type="radio" name="sequence" value="1" checked="checked">
				<div class="radio-text">1순위</div>
				<input type="radio" name="sequence" value="2">
				<div class="radio-text">2순위</div>
				<input type="radio" name="sequence" value="3">
				<div class="radio-text">3순위</div>
				
				<div id="button-frame">
					<input type="button" value="<이전" id="prev-button">
					<input type="submit" value="제출" id="submit-button">
					<input type="reset" value="내용지우기" id="reset-button">
				</div>
			</form>
			</div>
		</div>
	</div>
	<script src="./todo.js/"></script>
</body>
</html>
