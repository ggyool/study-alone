document.addEventListener("DOMContentLoaded", function(){
	var preBtn = document.getElementById("prev-button");
		preBtn.addEventListener("click", function(){
			history.back();
	})
});

