document.addEventListener("DOMContentLoaded", function(){
	function categoryLoadFunc(evt){
		if(evt.currentTarget.readyState === XMLHttpRequest.DONE){
			if(evt.currentTarget.status === 200){
				var categoryList = JSON.parse(evt.currentTarget.responseText).items;
				var categoryTemplate = document.querySelector("#categoryList").innerHTML;
				var parent = document.querySelector(".event_tab_lst, .tab_lst_min");
				var totalCount = 0;
				categoryList.forEach(function(category){
					var resHTML = categoryTemplate.replace("{category.id}", category.id)
												.replace("{category.name}", category.name);
					parent.innerHTML += resHTML;
					totalCount += category.count;
				});
			    var span = document.querySelector(".event_lst_txt > .pink")
			    console.log(totalCount);
				span.innerText = totalCount + "개";
			}
		}
	}
	
	var categoryHttpRequest = new XMLHttpRequest();
	categoryHttpRequest.open("GET", "api/categories")
	categoryHttpRequest.onreadystatechange = categoryLoadFunc;
	categoryHttpRequest.send();
});
