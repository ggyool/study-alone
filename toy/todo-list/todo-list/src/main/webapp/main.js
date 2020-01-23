

document.addEventListener("DOMContentLoaded", function(){
	var templateHTML = document.querySelector("#li-template").innerHTML;
	var todoUL = document.querySelector("#ul-todo");
	var doingUL = document.querySelector("#ul-doing");
	var doneUL = document.querySelector("#ul-done");
	var addBtn = document.querySelector("#content-header-registerbtn");
	
	todoList.forEach(function(dto){
		var resHTML = templateHTML.replace("{dto.title}", dto.title)
								  .replace("{dto.regdate}", dto.regdate)
								  .replace("{dto.name}", dto.name)
								  .replace("{dto.sequence}", dto.sequence);
		
		var li = document.createElement("li");
		li.innerHTML = resHTML;
		todoUL.appendChild(li);
		var btn = li.querySelector(".li-button");
		btn.addEventListener("click", function(){
			var httpRequest = new XMLHttpRequest(); 
			httpRequest.onreadystatechange = function(){
				if (httpRequest.readyState === XMLHttpRequest.DONE) {
					if (httpRequest.status === 200){
						if(httpRequest.responseText === "success"){
							var parentUL = btn.closest("ul");
							if(parentUL===todoUL){ 
								doingUL.appendChild(li);
								dto.type="DOING";
							}
							else if(parentUL===doingUL) {
								doneUL.appendChild(li);
								dto.type="DONE";
							}
							else parentUL.removeChild(li);
						}
					}
				}
			};
			httpRequest.open("POST", "/main");
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');	
			httpRequest.send("id=" + dto.id + "&type=" + dto.type);	
		});
	});
	
	doingList.forEach(function(dto){
		var resHTML = templateHTML.replace("{dto.title}", dto.title)
								  .replace("{dto.regdate}", dto.regdate)
								  .replace("{dto.name}", dto.name)
								  .replace("{dto.sequence}", dto.sequence);
		var li = document.createElement("li");
		li.innerHTML = resHTML;
		doingUL.appendChild(li);
		
		var btn = li.querySelector(".li-button");
		btn.addEventListener("click", function(){
			var httpRequest = new XMLHttpRequest(); 
			httpRequest.onreadystatechange = function(){
				if (httpRequest.readyState === XMLHttpRequest.DONE) {
					if (httpRequest.status === 200){
						if(httpRequest.responseText === "success"){
							var parentUL = btn.closest("ul");
							if(parentUL===todoUL){ 
								doingUL.appendChild(li);
								dto.type="DOING";
							}
							else if(parentUL===doingUL) {
								doneUL.appendChild(li);
								dto.type="DONE";
							}
							else parentUL.removeChild(li);
						}
					}
				}
			};
			httpRequest.open("POST", "/main");
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');	
			httpRequest.send("id=" + dto.id + "&type=" + dto.type);	
		});
	});
	
	doneList.forEach(function(dto){
		var resHTML = templateHTML.replace("{dto.title}", dto.title)
								  .replace("{dto.regdate}", dto.regdate)
								  .replace("{dto.name}", dto.name)
								  .replace("{dto.sequence}", dto.sequence);
		
		var li = document.createElement("li");
		li.innerHTML = resHTML;
		doneUL.appendChild(li);
		var btn = li.querySelector(".li-button");
		btn.addEventListener("click", function(){
			var httpRequest = new XMLHttpRequest(); 
			httpRequest.onreadystatechange = function(){
				if (httpRequest.readyState === XMLHttpRequest.DONE) {
					if (httpRequest.status === 200){
						if(httpRequest.responseText === "success"){
							var parentUL = btn.closest("ul");
							if(parentUL===todoUL){ 
								doingUL.appendChild(li);
								dto.type="DOING";
							}
							else if(parentUL===doingUL) {
								doneUL.appendChild(li);
								dto.type="DONE";
							}
							else parentUL.removeChild(li);
						}
					}
				}
			};
			httpRequest.open("POST", "/main");
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');	
			httpRequest.send("id=" + dto.id + "&type=" + dto.type);	
		});
	});
	
	addBtn.addEventListener("click", function(){
		location.href = "./todo";
	});
	
});

