<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO List</title>
<link rel="stylesheet" href="./main.css">
</head>
<body>
	<div id="content">
		<div id="content-blank"></div>
		<div id="content-header">
			<span id="content-header-title">
				나의 해야할 일들
			</span>
			<input type="button" value="새로운 TODO 등록" id="content-header-registerbtn">
		</div>
		<div id="content-body">
			<div id="content-body-todo">
				<h1>TODO</h1>
				<ul id="ul-todo">
				
				</ul>
			</div>
			<div id="content-body-doing">
				<h1>DOING</h1>
				<ul id="ul-doing">
				
				</ul>
			</div>
			<div id="content-body-done">
				<h1>DONE</h1>		
				<ul id="ul-done">
				
				</ul>
			</div>
		</div>
	</div>
	<script>
		var todoList = JSON.parse('${todoList}');
		var doingList = JSON.parse('${doingList}');
		var doneList =JSON.parse('${doneList}');
	</script>
	<script src="./main.js"></script>
	<script id="li-template" type="text/template">
		<li>
			<div id="li-title">{dto.title}</div>
			<div>
				<div id="li-content">등록날짜:{dto.regdate}, {dto.name}, 우선순위 {dto.sequence}</div>
				<input class="li-button" onclick="clickCallback(this, '{dto.id}')" type="button" value="→">
			</div>
		</li>
	</script>
</body>
</html>