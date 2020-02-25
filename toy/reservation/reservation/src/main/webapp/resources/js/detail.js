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
		width : 0,
		init : function(){
			this.imageList = imageObj.imageList;
			this.imageList.forEach(image=>image.saveFileName = "/" + image.saveFileName);
			this.setTotal(this.imageList.length);
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
			this.width = container.offsetWidth;
			container.style.height = container.offsetHeight;
			container.style.width = this.width * (this.total+2);
			this.imageList.forEach(function(image){
				container.innerHTML += bindingTemplate(image);
			});
			this.setAnimationTime(0);
			this.slideLeft();
			this.eventInit();
		},
		printList : function(){
			this.imageList.forEach(function(image){
				console.log(image);
			});
		},
		setPage : function(){
			var page = this.current;
			if(page===0) page = this.total;
			if(page>this.total) page = 1;
			document.querySelector(".pagination .num").innerText = page;
			
		},
		setTotal : function(num){
			this.total = num; 
			document.querySelector(".pagination .num.off span").innerText = num;
		},
		slideLeft : function(evt){
			var container = document.querySelector(".container_visual .visual_img");
			this.current += 1;
			console.log(this.current);
			if(this.current>this.total){
				this.current = 0;
				this.setAnimationTime(0);
				container.style.transform = `translateX(0px)`;
				//debugger;
				window.setTimeout(this.slideLeft.bind(this), 0);
			}else{
				this.setAnimationTime(1);
				this.setPage(this.current);
				container.style.transform = `translateX(${-this.current*this.width}px)`;
			}
		},
		slideRight : function(){
			this.setCurrent(1);
		},
		setAnimationTime : function(sec){
			var container = document.querySelector(".container_visual .visual_img");
			container.style.transition = `${sec}s`;
		},
		eventInit : function(){
			var container = document.querySelector(".container_visual .visual_img");
			var btnNext = document.querySelector(".btn_nxt");
			var btnPrev = document.querySelector(".btn_prev");
			btnNext.addEventListener("click", this.slideLeft.bind(this));
//			container.addEventListener("transitionstart", function(evt){
//				if(this.current >= this.total){
//					this.setAnimationTime(0);
//					container.style.transform = `translateX(0px)`;
//				}
//			}.bind(this));
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



