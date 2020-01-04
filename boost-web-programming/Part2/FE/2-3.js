var el = document.querySelector(".outside");

el.addEventListener("click", function(e){
	var target = e.target;
	console.log(target.className);
	console.log(target.nodeName);
});
