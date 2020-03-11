document.addEventListener("DOMContentLoaded", function(){
	var categoryId = 0;
	var start = 0;
	var width;
	var curPromotion = 1;
	var promotionLen;
	var slideTime = 2000;

	(function init(){
		var initHttpRequest = new XMLHttpRequest();
		initHttpRequest.open("GET", "api/categories")
		initHttpRequest.onreadystatechange = categoryLoadFunc;
		initHttpRequest.send();
		
		var promotionsHttpRequest = new XMLHttpRequest();
		promotionsHttpRequest.open("GET", "api/promotions")
		promotionsHttpRequest.onreadystatechange = promotionLoadFunc;
		promotionsHttpRequest.send();
		
		var promotionUL = document.querySelector(".visual_img");
		promotionUL.addEventListener("transitionend", function(){
			if(curPromotion >= promotionLen-1){
				curPromotion = 0;
				promotionUL.style.transition = '0s';
				promotionUL.style.transform = `translateX(0px)`;
			}
		});
		window.setTimeout(animationFunc, slideTime);
	})();
	
	function categoryLoadFunc(evt){
		if(evt.target.readyState === XMLHttpRequest.DONE){
			if(evt.target.status === 200){
				var categoryList = JSON.parse(evt.target.responseText).items;
				var categoryTemplate = document.querySelector("#categoryList").innerHTML;
				var totalCount = 0;
				categoryList.forEach(function(category){
					var resHTML = categoryTemplate.replace("{category.id}", category.id)
												.replace("{category.name}", category.name);
					document.querySelector(".event_tab_lst, .tab_lst_min").innerHTML += resHTML;
					totalCount += category.count;
				});
				refreshTotalSpan(totalCount);
			    productsAjaxFunc();
			}
		}
	}
	
	function promotionLoadFunc(evt){
		if(evt.target.readyState === XMLHttpRequest.DONE){
			if(evt.target.status === 200){
				var promotionList = JSON.parse(evt.target.responseText).items;
				var plen = promotionList.length;
				// 마지막 항목을 가장 앞에 추가
				promotionList = [promotionList[plen-1]].concat(promotionList);
				plen = promotionList.length;
				promotionLen = plen;
				
				initSize();
				
				var promotionUL = document.querySelector(".visual_img")
				width = promotionUL.getBoundingClientRect().width;
				promotionUL.style.transform = `translateX(${-width}px)`;
				promotionList.forEach(function(promotion){
					li = document.createElement("li");
					img = document.createElement("img");
					img.style.width = width + "px";
					img.src = promotion.productImageUrl;
					li.appendChild(img);
					promotionUL.appendChild(li);
				});
			}
		}
	}
	
	function initSize(){
		var cotainerDiv = document.querySelector(".container_visual");
		var promotionUL = document.querySelector(".visual_img");
		var defaultWidth = promotionUL.getBoundingClientRect().width;
		var defaultHeight = promotionUL.getBoundingClientRect().height;
		cotainerDiv.style.width = width + "px";
		cotainerDiv.style.height = defaultHeight + "px";
		promotionUL.style.width = width * promotionLen + "px";
	}
	
	function animationFunc(){
		var promotionUL = document.querySelector(".visual_img");
		promotionUL.style.transition = '1s';
		++curPromotion;
		promotionUL.style.transform = `translateX(${-curPromotion*width}px)`;
		window.setTimeout(animationFunc, slideTime);
	}
	
	function productsAjaxFunc(categoryId, start = 0){
		var productsHttpRequest = new XMLHttpRequest();
		var url;
		if(categoryId) url = `api/products?categoryId=${categoryId}&start=${start}`;
		else url = `api/products?start=${start}`;
		productsHttpRequest.start = start;
		productsHttpRequest.categoryId = categoryId;
		productsHttpRequest.open("GET", url);
		productsHttpRequest.onreadystatechange = productsLoadFunc;
		productsHttpRequest.send();
	}
	
	
	function productsLoadFunc(evt){
		if(evt.target.readyState === XMLHttpRequest.DONE){
			if(evt.target.status === 200){
				// 성공했으므로 global scope 변경
				start = evt.target.start;
				categoryId = evt.target.categoryId;
				var listProductUl = document.querySelectorAll(".lst_event_box");
				var productsObj = JSON.parse(evt.target.responseText);
				var productsList = productsObj.items;
				var totalCount = productsObj.totalCount;
				refreshTotalSpan(totalCount);
				chkAndHideMoreBtn(totalCount);
				var productsTemplate = document.querySelector("#itemList").innerHTML;
				productsList.forEach(function(product,i){
					var resHTML = productsTemplate
					  .replace("{displayInfoId}", product.displayInfoId)
					  .replace("{productDescription}", product.productDescription)
					  .replace("{productDescription}", product.productDescription)
					  .replace("{productImageUrl}", product.productImageUrl)
					  .replace("{placeName}", product.placeName)
					  .replace("{productContent}", product.productContent);
					listProductUl[i%2].innerHTML += resHTML;
				});
			}
		}
	}
	
	function chkAndHideMoreBtn(totalCount){
		var moreBtn = document.querySelector(".btn_more_wrap");
		if(start+4 >= totalCount){
			moreBtn.style.display = "none";
		}else{
			moreBtn.style.display = "";
		}
	}
	
	function refreshTotalSpan(totalCount){
		var countSpan = document.querySelector(".event_lst_txt .pink");
		countSpan.innerText = totalCount + "개";
	}
	
	// 더보기 버튼
	document.querySelector(".btn_more_wrap").addEventListener("click", function(){
		productsAjaxFunc(categoryId, start+4);
	});
	
	
	// 카테고리  선택
	document.querySelector(".section_event_tab").addEventListener("click", function(evt){
		var tagName = evt.target.tagName;
		var categoryId;
		if(tagName === "LI"){
			categoryId = evt.target.getAttribute("data-category");
		} else if(tagName==="SPAN" || tagName==="A"){
			var li = evt.target.closest("li");
			categoryId = li.getAttribute("data-category");
		}
		else return;
		removeActive();
		evt.target.closest("li").querySelector("a").className = "anchor active";
		start = 0;
		productsAjaxFunc(parseInt(categoryId, start));
		cleanProducts();
	});
	
	function removeActive(){
		var selectAnchor = document.querySelector(".tab_lst_min .active");
		selectAnchor.className = "anchor";
	}
	
	function cleanProducts(){
		var listProductUl = document.querySelectorAll(".lst_event_box");
		listProductUl[0].innerHTML = "";
		listProductUl[1].innerHTML = "";
	}	
	
	// 예약 확인 버튼 
	document.querySelector(".header_tit .viewReservation").addEventListener("click", function(){
		if(this.innerText === "예약확인"){
			location.href = "/login";
		}else{
			location.href = "/reservations/me";
		}
	});
});




