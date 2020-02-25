document.addEventListener("DOMContentLoaded", function(){
	
	var displayInfoResponse;
	var imageObj = {
		imageList : [],
		init : function (){
			var productImages = displayInfoResponse.productImages;
			productImages.forEach(function(image){
				if(image.type === "et" || image.type === "ma"){
					Array.prototype.push.call(imageObj.imageList, image);
				}
			});	
		}
	};
	
	var animationObj = {
		imageList : [],
		current : 0,
		total : 0,
		init : function(){
			this.imageList = imageObj.imageList;
			this.setTotal(this.imageList.length);
			this.setCurrent(1);
			var firstImage = this.imageList[0];
			var lastImage = this.imageList[this.total-1];
			// 마지막 항목을 가장 앞에 추가
			this.imageList = [lastImage].concat(this.imageList);
			//처음 항목을 마지막에 추가
			Array.prototype.push.call(this.imageList, firstImage);
			this.imageLoad();
		},
		imageLoad : function(){
			var container = document.querySelector(".container_visual .visual_img");
			var template = document.querySelector("#imageItem").innerText;
			var bindingTemplate = Handlebars.compile(template);
			width = container.offsetWidth;
			container.style.width = width * (this.getTotal()+2);
			this.imageList.forEach(function(image){
				image.saveFileName = "/" + image.saveFileName;
				container.innerHTML += bindingTemplate(image);
			});
		},
		printList : function(){
			this.imageList.forEach(function(image){
				console.log(image);
			});
		},
		getCurrent : function(){
			return parseInt(document.querySelector(".pagination .num"));	
		},
		setCurrent : function(num){
			this.current = num;
			document.querySelector(".pagination .num").innerText = num;
		},
		getTotal : function(){
			return parseInt(document.querySelector(".pagination .num.off span"));
		},
		setTotal : function(num){
			this.total = num; 
			document.querySelector(".pagination .num.off span").innerText = num;
		}
	};
	
	(function init(){
		var locationPath = location.pathname;
		var url = "/api" + locationPath;
		fetch(url).then(function(response){
			if(response.status===200 || response.status===201){
				response.json().then( json => {
					displayInfoResponse = json;
					imageObj.init();
					animationObj.init();
				});
			}
		});
	})();
	
});
