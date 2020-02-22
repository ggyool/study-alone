document.addEventListener("DOMContentLoaded", function(){
	var displayInfoResponse;
	(function init(){
		var locationPath = location.pathname;
		var url = "/api" + locationPath;
		var initXhr = new XMLHttpRequest();
		console.log(url);
		initXhr.open("GET", url);
		initXhr.onreadystatechange = dataLoad;
		initXhr.send();
	})();
	
	function dataLoad(){
		if(this.readyState === XMLHttpRequest.DONE){
			if(this.status === 200){
				displayInfoResponse = JSON.parse(this.responseText);
			}
		}
	}
	
});
