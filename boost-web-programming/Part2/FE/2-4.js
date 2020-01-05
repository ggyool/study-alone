var oReq;
var btn = document.getElementById("btn");
btn.addEventListener("click", function(){
	oReq = new XMLHttpRequest();
	oReq.open("GET", "http://localhost:8080/aboutme/");
	oReq.send();
})

