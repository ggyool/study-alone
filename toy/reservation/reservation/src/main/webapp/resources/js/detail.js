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
			var titleInImage = document.querySelector(".visual_txt_tit span");
			titleInImage.innerText = displayInfoResponse.displayInfo.productDescription;
		}
	};
	var animationObj = {
		imageList : [],
		current : 1,
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
			container.style.width = this.width * (this.total+2);
			this.imageList.forEach(function(image){
				container.innerHTML += bindingTemplate(image);
			});
			this.setPage();
			container.style.transform = `translateX(${-this.width}px)`;
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
		slideLeft : function(){
			var container = document.querySelector(".container_visual .visual_img");
			this.current += 1;
			if(this.current>this.total+1){
				this.current = 1;
				this.setAnimationTime(0);
				container.style.transform = `translateX(${-this.current*this.width}px)`;
				window.setTimeout(this.slideLeft.bind(this), 0);
			}else{
				this.setAnimationTime(1);
				this.setPage(this.current);
				container.style.transform = `translateX(${-this.current*this.width}px)`;
			}
		},
		slideRight : function(){
			var container = document.querySelector(".container_visual .visual_img");
			this.current -= 1;
			if(this.current<0){
				this.current = this.total;
				this.setAnimationTime(0);
				container.style.transform = `translateX(${-this.current*this.width}px)`;
				window.setTimeout(this.slideRight.bind(this), 0);
			}else{
				this.setAnimationTime(1);
				this.setPage(this.current);
				container.style.transform = `translateX(${-this.current*this.width}px)`;
			}
		},
		setAnimationTime : function(sec){
			var container = document.querySelector(".container_visual .visual_img");
			container.style.transition = `${sec}s`;
		},
		eventInit : function(){
			var container = document.querySelector(".container_visual .visual_img");
			var btnNext = document.querySelector(".btn_nxt");
			var btnPrev = document.querySelector(".btn_prev");
			if(this.total === 1) {
				btnNext.querySelector("i").style.visibility = "hidden";			
				btnPrev.querySelector("i").style.visibility = "hidden";
				return;
			}
			btnNext.querySelector("i").style.visibility = "visible";			
			btnPrev.querySelector("i").style.visibility = "visible";
			btnNext.addEventListener("click", this.slideLeft.bind(this));
			btnPrev.addEventListener("click", this.slideRight.bind(this));
		}
	};
	var shortInfoObj = {
		init : function(){
			var displayInfo = displayInfoResponse.displayInfo;
			var contentLabel = document.querySelector(".section_store_details .dsc");
			contentLabel.innerText = displayInfo.productContent;
			this.eventInit();
		},
		eventInit : function(){
			var moreBtn = document.querySelector(".bk_more._open");
			var foldBtn = document.querySelector(".bk_more._close");
			var stretchLabel = document.querySelector(".section_store_details .store_details");
			moreBtn.addEventListener("click", function(){
				moreBtn.style.display = "none";
				foldBtn.style.display = "block";
				stretchLabel.className = "store_details";
			});
			foldBtn.addEventListener("click", function(){
				moreBtn.style.display = "block";
				foldBtn.style.display = "none";
				stretchLabel.className = "store_details close3";
			});
		}
	};
	var reviewObj = {
		init : function(){
			this.gradeLoad();
			this.commentLoad();
		},
		gradeLoad : function(){
			var averageScore = displayInfoResponse.averageScore;
			if(averageScore === null) averageScore = 0;
			var starGraph = document.querySelector(".grade_area .graph_value");
			var gradeLabel = document.querySelector(".grade_area .text_value span");
			starGraph.style.width = `${averageScore*20}%`;
			gradeLabel.innerText = averageScore;
		},
		commentLoad : function(){
			var commentList = displayInfoResponse.comments;
			var len = commentList.length;
			var totalLabel = document.querySelector(".grade_area .join_count .green");
			totalLabel.innerText = `${len}건`;
			var container = document.querySelector(".list_short_review");
			var template = document.querySelector("#commentItem").innerText;
			var bindingTemplate = Handlebars.compile(template);
			for(var i=0; i<len; ++i){
				if(i>=3) break;
				var commentObj = commentList[i];
				var templateObj = this.makeTemplateObject(commentObj);
				container.innerHTML += bindingTemplate(templateObj);
			}
		},
		makeTemplateObject : function(commentObj){
			var commentImage = commentObj.commentImages[0];
			var email = commentObj.reservationEmail;
			var day = commentObj.reservationDate;
			var obj = {};
			if(commentImage) {
				obj.fileName = "/" + commentImage.saveFileName;
				obj.visible = "";
			}else{
				obj.visible = "none";
			}
			obj.comment = commentObj.comment;
			obj.score = commentObj.score;
			obj.userId = "";
			obj.visitDate = day.split(" ")[0] + " 방문";
			obj.userId += email.slice(0,4) + "****";
			return obj;
		}
	};
	var detailInfoObj = {
		init : function(){
			this.contentLoad();
			this.eventInit();
		},
		contentLoad : function(){
			var displayInfo = displayInfoResponse.displayInfo;
			var content = displayInfo.productContent;
			var infoLabel = document.querySelector(".detail_info .in_dsc");
			infoLabel.innerText = content;
			
			var titleLabel = document.querySelector(".detail_location .store_name");
			var placeStreetLabel = document.querySelector(".detail_location .store_addr_bold");
			var placeLotLabel = document.querySelector(".detail_location .addr_old_detail");
			var placeDetailLabel = document.querySelector(".detail_location .addr_detail");
			var placeTelLabel = document.querySelector(".detail_location .store_tel");
			titleLabel.innerText = displayInfo.productDescription;
			placeStreetLabel.innerText = displayInfo.placeStreet;
			placeLotLabel.innerText = displayInfo.placeLot;
			placeDetailLabel.innerText = displayInfo.placeName;
			placeTelLabel.innerText = displayInfo.tel;
			placeTelLabel.href = "tel:" + displayInfo.tel;
		},
		eventInit : function(){
			var infoTab = document.querySelector(".info_tab_lst ._detail");
			var infoAnchor = infoTab.querySelector(".anchor");
			var pathTab = document.querySelector(".info_tab_lst ._path");
			var pathAnchor = pathTab.querySelector(".anchor");
			var infoWrap = document.querySelector(".detail_area_wrap");
			var pathWrap = document.querySelector(".detail_location");
			infoTab.addEventListener("click", function(){
				infoAnchor.className = "anchor active";
				pathAnchor.className = "anchor";
				infoWrap.className = "detail_area_wrap";
				pathWrap.className = "detail_location hide";
			});
			pathTab.addEventListener("click", function(){
				pathAnchor.className = "anchor active";
				infoAnchor.className = "anchor";
				infoWrap.className = "detail_area_wrap hide";
				pathWrap.className = "detail_location";
			});
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
					shortInfoObj.init();
					reviewObj.init();
					detailInfoObj.init();
				});
			}
		});
	})();
	
});


