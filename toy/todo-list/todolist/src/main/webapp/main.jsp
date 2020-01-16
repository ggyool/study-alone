<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
				<ul id="ul-todo">
				<c:forEach items="${todoList}" var="dto">
					<li>
						<div id="li-title">${dto.title}</div>
						<div>
							<div id="li-content">등록날짜:${dto.regdate}, ${dto.name}, 우선순위 ${dto.sequence}</div>
							<input class="li-button" onclick="clickCallback(this, '${dto.id}')"
							type="button" value="→">
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
			<div id="content-body-doing">
				<h1>DOING</h1>
				<ul id="ul-doing">
				<c:forEach items="${doingList}" var="dto">
					<li>
						<div id="li-title">${dto.title}</div>
						<div>
							<div id="li-content">등록날짜:${dto.regdate}, ${dto.name}, 우선순위 ${dto.sequence}</div>
							<input class="li-button" onclick="clickCallback(this, '${dto.id}')"
							type="button" value="→" >
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
			<div id="content-body-done">
				<h1>DONE</h1>		
				<ul id="ul-done">
				<c:forEach items="${doneList}" var="dto">
					<li>
						<div id="li-title">${dto.title}</div>
						<div>
							<div id="li-content">등록날짜:${dto.regdate}, ${dto.name}, 우선순위 ${dto.sequence}</div>
							<input class="li-button" onclick="clickCallback(this, '${dto.id}')"
							type="button" value="→">
						</div>
					</li>
				</c:forEach>
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
		width : 75%;
		background-color : rgb(255, 255, 255);
		margin : auto;
		padding-bottom : 5rem;	
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
		transform: rotate(-35deg); 
		overflow: hidden;
		padding-top : 2rem;
	}
	#content-header-registerbtn{
		font-size : 1.2rem;
		background-color : rgb(59,164,245);
		color : white;
		float : right;
		padding : 10px 25px;
		margin-right : 6rem;
	}
	#content-body{
		clear : both;
		margin-left : 8.5rem;
	}
	#content-body > div{
		display : inline-block;	
		vertical-align : top;
	}
	#content-body > div > h1{
		font-size : 1.8rem;
		font-weight : bold;
		background-color : rgb(0,50,70);
		color : white;
		width : 27rem;
		height : 5rem;
		line-height : 5rem;
		margin-top : 2rem;
		margin-bottom : 0px;
		margin-left : 0.75rem;
		padding-left : 2rem;
		box-sizing:border-box;
	}
	
	#content-body > div > ul{
		width : 27rem;
		padding : 0px 0px;
		margin : 0px 0px;
		position : relative;
	}
	#content-body > div > ul >li{
		background-color : rgba(89,193,235,0.3);
		list-style-type: none;
		padding : 0px 0px;
		width : 27rem;
		height : 7rem;
		margin-top : 0.75rem;
		margin-left : 0.75rem;
		padding-left : 2rem;
		box-sizing:border-box;
	}	
	#li-title{
		font-size : 1.5rem;
		font-weight : bold;
		padding-top : 1.5rem;
		padding-bottom : 0.5rem;
	}
	#li-content{
		display : inline-block;
	}
	.li-button{
		position : absolute;
		right : 0.25rem;
		font-size : 1.2rem;
	}
</style>

<script>
	var registerBtn = document.getElementById("content-header-registerbtn");
	registerBtn.addEventListener("click", function(){
		location.href = "../todo";
	});
	var inputBtn;
	function clickCallback(btn, dtoId){
		var dtoType = btn.parentElement.parentElement.parentElement.previousElementSibling.innerText.toLowerCase();
		inputBtn = btn;
		httpRequest = new XMLHttpRequest(); 
		
		httpRequest.onreadystatechange = responsCallback;
		
		httpRequest.open("GET", "/TodoTypeServlet?id=" + dtoId + "&type=" + dtoType);
		httpRequest.send();
	}
	
	function responsCallback(){
		if (this.readyState === XMLHttpRequest.DONE) {
			if (this.status === 200){
				var obj = eval('(' + this.responseText + ')');
				var type = obj["type"].toLowerCase();
				var liEle = inputBtn.parentElement.parentElement;
				console.log('obj:', obj);
				console.log('type:', type);
				console.log('liEle:', liEle);
				if(type==="erase"){
					liEle.parentNode.removeChild(liEle);
				}
				else{
					var ulEle = document.getElementById("ul-"+type);
					ulEle.appendChild(liEle);
				}
			}
			else {
				alert('request에 뭔가 문제가 있어요.');
			}
		}
	}
</script>
</html>









