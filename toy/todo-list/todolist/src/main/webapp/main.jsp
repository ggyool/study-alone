<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO List</title>
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
				<ul>
					<li>aaaa</li>
					<li>bbbb</li>
					<li>cccc</li>
				</ul>
			</div>
			<div id="content-body-doing">
				<h1>DOING</h1>
				<ul>
					<li>aaaa</li>
					<li>bbbb</li>
					<li>cccc</li>
				</ul>
			</div>
			<div id="content-body-done">
				<h1>DONE</h1>
				<ul>
					<li>aaaa</li>
					<li>bbbb</li>
					<li>cccc</li>
				</ul>
			</div>
		</div>
	</div>
</body>

<style>
	body{
		background-color : rgb(235, 235, 235);
	}
	#content{
		width : 80%;
		background-color : rgb(255, 255, 255);
		margin : auto;
		height : 1000px;
	}
	#content-blank{
		height : 3.3rem;
	}
	#content-header{
		background-color : green;
	}
	#content-header-title{
		font-size : 2rem;
		font-weight : bold;
		color : rgb(0,50,70);
		float : left;
		transform: rotate(-30deg); 
		overflow: hidden;
	}
	#content-header-registerbtn{
		font-size : 1.2rem;
		background-color : rgb(59,164,245);
		color : white;
		float : right;
		padding : 10px 25px;
		margin-right : 2%;
	}
	#content-body{
		clear : both;
	}
	#content-body h1{
		font-size : 1.2rem;
		font-weight : bold;
		background-color : rgb(0,50,70);
		color : white;
		width : 25rem;
		height : 5rem;
	}
	#content-body > div{
		display : inline-block;
	}
</style>
</html>