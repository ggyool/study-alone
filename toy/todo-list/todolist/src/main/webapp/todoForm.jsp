<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register TODO</title>
</head>
<body>
	<div id="content">
		<div id="content-blank"></div>
		<div id="content-header">
			<h1 id="content-title">할일 등록</h1>
		</div>
		<div id="content-body-wrapper">
			<div id="content-body">
			<form method="post" action="../TodoAddServlet">
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
</body>


<style>
	body{
		background-color : rgb(235, 235, 235);
	}
	#content-blank{
		height : 2rem;
	}
	#content{
		width : 75%;
		background-color : rgb(255, 255, 255);
		margin : auto;
		text-align : center;
	}
	#content-header{
		
	}
	#content-body-wrapper{
		width : 50rem;
		margin-left : 28rem;
	}
	#content-body{
		text-align : left;
	}
	#content-title{
		font-weight : bold;
	}
	#prev-button{
		text-decoration : underline;
	}
	.content-question{
		font-size : 1.25rem;
		color : rgb(100,100,100);
		margin-bottom : 0.25rem;
	}
	#button-frame{
		margin : 3rem 0px;
		padding-bottom : 3rem;
		width : 50rem;
	}
	#prev-button{
		font-size : 1.2rem;
		font-weight : bold;
		background-color : rgb(235,235,235);
		padding : 10px 0px;
		width : 10rem;
		margin-right : 6rem;
		background-color : white;
		border-style : solid;
		border-color : rgb(130,130,130);
	}
	
	#submit-button, #reset-button{
		font-size : 1.2rem;
		background-color : rgb(59,164,245);
		color : white;
		padding : 10px 0px;
		width : 10rem;
		margin-left : 1.75rem;
	}
	#content-input-title, #content-input-name{
		font-size : 1.2rem;
		height : 2rem;
		color : rgb(100,100,100);
		margin-bottom : 1rem;
	}
	.radio-text{
		display : inline-block;
		margin-right : 1rem;
		font-weight : bold;
	}
</style>

<script>
	var preBtn = document.getElementById("prev-button");
	preBtn.addEventListener("click", function(){
		history.back();
	})
</script>
	
</html>

