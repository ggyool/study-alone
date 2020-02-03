document.addEventListener("DOMContentLoaded", function(){
	function categoryLoadFunc(evt){
		console.log(evt);
		if(evt.currentTarget.readyState === XMLHttpRequest.DONE){
			if(evt.currentTarget.status === 200){
				var categoryList = JSON.parse(evt.currentTarget.responseText).items;
				var categoryTemplate = document.querySelector("#categoryList").innerHTML;
				var parent = document.querySelector(".event_tab_lst, .tab_lst_min");
				categoryList.forEach(function(category){
					var resHTML = categoryTemplate.replace("{category.id}", category.id)
												.replace("{category.name}", category.name);
					parent.innerHTML += resHTML;
				});
			}
		}
	}
	
	var categoryHttpRequest = new XMLHttpRequest();
	categoryHttpRequest.open("GET", "api/categories")
	categoryHttpRequest.onreadystatechange = categoryLoadFunc;
	categoryHttpRequest.send();
});