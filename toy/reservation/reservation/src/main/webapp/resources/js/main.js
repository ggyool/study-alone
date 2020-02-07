document.addEventListener("DOMContentLoaded", function(){
	var curCategory = 0;
	var end = -1;
	var moreBtn = document.querySelector(".btn_more_wrap");
	var categorySection = document.querySelector(".section_event_tab");
	var itemUlList = document.querySelectorAll(".lst_event_box");
	var countSpan = document.querySelector(".event_lst_txt > .pink")
	var promotionUL;
	var promotionList;
	var defaultWidth;
	var curPromotion = 0;
	var promotionLen;
	var slideTime = 1000;
	var slideDirection = 1;
	
	var initHttpRequest = new XMLHttpRequest();
	initHttpRequest.open("GET", "api/categories")
	initHttpRequest.onreadystatechange = initLoadFunc;
	initHttpRequest.send();
	
	var promotionsHttpRequest = new XMLHttpRequest();
	promotionsHttpRequest.open("GET", "api/promotions")
	promotionsHttpRequest.onreadystatechange = promotionLoadFunc;
	promotionsHttpRequest.send();
	window.setTimeout(animationFunc, slideTime);
	
	function initLoadFunc(evt){
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
				countSpan.innerText = totalCount + "개";
			    productsAjaxFunc(0);
			}
		}
	}
	
	function promotionLoadFunc(evt){
		if(evt.currentTarget.readyState === XMLHttpRequest.DONE){
			if(evt.currentTarget.status === 200){
				promotionList = JSON.parse(evt.currentTarget.responseText).items;
				plen = promotionList.length;
				promotionLen = plen;
				var cotainerDiv = document.querySelector(".container_visual");
				promotionUL = document.querySelector(".visual_img");
				defaultWidth = promotionUL.getBoundingClientRect().width;
				var defaultHeight = promotionUL.getBoundingClientRect().height;
				cotainerDiv.style.width = defaultWidth + "px";
				cotainerDiv.style.height = defaultHeight + "px";
				promotionUL.style.width = defaultWidth * plen + "px";;
				promotionList.forEach(function(promotion){
					li = document.createElement("li");
					img = document.createElement("img");
					img.style.width = defaultWidth + "px";
					img.src = promotion.productImageUrl;
					li.appendChild(img);
					promotionUL.appendChild(li);
				});
			}
		}
	}
	
	function animationFunc(){
		promotionUL.style.transform = "translate(" + String(-defaultWidth*curPromotion) + "px" + ",0px)";
		curPromotion += slideDirection;
		if(curPromotion === promotionLen - 1 || curPromotion === 0){
			slideDirection *= -1;
		}
		window.setTimeout(animationFunc, slideTime);
	}
	
	function productsAjaxFunc(categoryId){
		if(categoryId!==curCategory) {
			end = -1;
			if(moreBtn.style.display === "none")
				moreBtn.style.display = "";
		}
		var productsHttpRequest = new XMLHttpRequest();
		var url = "api/products";
		if(categoryId!==0 || end!==-1) url += '?';
		if(categoryId!==0) url += "categoryId=" + categoryId;
		if(end!==-1) url += "start=" + String(end+1);
		productsHttpRequest.categoryId = categoryId;
		productsHttpRequest.open("GET", url);
		productsHttpRequest.onreadystatechange = productsLoadFunc;
		productsHttpRequest.send();
	}
	
	
	function productsLoadFunc(evt){
		if(evt.currentTarget.readyState === XMLHttpRequest.DONE){
			if(evt.currentTarget.status === 200){
				var liList = document.querySelectorAll(".tab_lst_min > li");
				var categoryId = event.currentTarget.categoryId;
				liList.forEach(function(li){
					id = parseInt(li.getAttribute("data-category"));
					a = li.querySelector("a");
					if(id===categoryId){
						a.className = "anchor active";
					}else{
						a.className = "anchor";						
					}
				});
				var productsObj = JSON.parse(evt.currentTarget.responseText);
				var productsList = productsObj.items;
				var totalCount = productsObj.totalCount;
				countSpan.innerText = totalCount + "개";
				plen = productsList.length;
				end += plen;
				if(moreBtn.style.display === "" && end === totalCount-1){
					moreBtn.style.display = "none";
				}
				
				var productsTemplate = document.querySelector("#itemList").innerHTML;
				for(var i=0; i<plen; ++i){
					var resHTML = productsTemplate.replace("{productDescription}", productsList[i].productDescription)
												  .replace("{productImageUrl}", productsList[i].productImageUrl)
  												  .replace("{placeName}", productsList[i].placeName)
  												  .replace("{productContent}", productsList[i].productContent);
					itemUlList[i%2].innerHTML += resHTML;
				}
			}
		}
	}
	
	moreBtn.addEventListener("click", function(){
		productsAjaxFunc(curCategory);
	});
	
	categorySection.addEventListener("click", function(evt){
		var tagName = evt.target.tagName;
		var categoryId;
		if(tagName === "LI"){
			categoryId = evt.target.getAttribute("data-category");
		} else if(tagName==="SPAN" || tagName==="A"){
			var li = evt.target.closest("li");
			categoryId = li.getAttribute("data-category");
		}
		else return;
		productsAjaxFunc(parseInt(categoryId));
		end = -1;
		itemUlList[0].innerHTML = "";
		itemUlList[1].innerHTML = "";
	});
});



