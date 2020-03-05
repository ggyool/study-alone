document.addEventListener("DOMContentLoaded", function(){
	
	var displayInfoResponse;
	(function init(){
		var locationPath = location.pathname;
		var list = locationPath.split('/');
		list = list.filter(s=>s); // 비어있는것을 버린다.
		var url = "/api/products/" + list[list.length - 1];
		fetch(url).then(function(response){
			if(response.status===200 || response.status===201){
				response.json().then( json => {
					displayInfoResponse = json;	
					var myPriceObj = new MyPrice();
					new TopTitle();
					new GroupVisual();
					new StoreDetail(myPriceObj);
					new BookingTicket(myPriceObj);
				});
			}
		});
	})();
	
	// product_price 테이블의 가격을 찾아보면 어떤것은 할인이 들어가있고, 어떤것은 안 들어가있다.
	// 실제 시스템이라면 db에는 본래 가격과 할인율을 넣는게 맞다고 생각. (할인율이 유동적으로 바뀌어야 하기 때문)
	// 결론 : 애매해서 내 마음대로 함
	function MyPrice(){
		this.length = 0;
		this.discountPrices = [];
		this.typeNames = [];
		this.init();
	}
	MyPrice.prototype={
		// D,S,B가 겹쳐 마음대로 정함
		typeToKorean : {
			A:"성인(만 19~64세)", Y:"청소년(만 13~18세)", B:"어린이(만 4~12세)", C:"지역주민", E:"얼리버드",
			V:"VIP", R:"R석", S:"S석", D:"평일"
		},
		init : function(){
			var productPrices = displayInfoResponse.productPrices;
			this.length = productPrices.length;
			productPrices.forEach(function(productPrice){
				var type = productPrice.priceTypeName;
				Array.prototype.push.call(this.typeNames, this.typeToKorean[type])
				var price = parseInt(productPrice.price);
				var discountRate = parseInt(productPrice.discountRate);
				price = this.convertPrice(price, discountRate);
				Array.prototype.push.call(this.discountPrices, price)
			}.bind(this));
		}, 
		
		// 할인율 적용하여 10의자리에서 반올림
		convertPrice : function(price, discountRate){
			discountRate /= 100;
			price *= (1-discountRate);
			price = Math.round(price/100);
			price *= 100;	
			return price;
		}
	};
	
	function TopTitle(){
		this.loadTitle();
		this.registerEvent();
	}
	TopTitle.prototype = {
			loadTitle : function(){
			var titleLabel = document.querySelector(".top_title .title");;
			var title = displayInfoResponse.displayInfo.productDescription;
			titleLabel.innerText = title;
		},
		registerEvent : function(){
			var backBtn = document.querySelector(".top_title .btn_back");
			backBtn.addEventListener("click", function(){
				var displayInfoId = displayInfoResponse.displayInfo.displayInfoId;
				location.href = "/products/" + displayInfoId;
			});
		}
	};
	
	function GroupVisual(){
		this.loadImage();
		this.loadTitle();
	}
	GroupVisual.prototype = {
		loadImage : function(){
			var thumbImg = document.querySelector(".group_visual .img_thumb");
			var productImages = displayInfoResponse.productImages;
			productImages.forEach(function(image){
				if(image.type === "th"){
					thumbImg.src = '/' + image.saveFileName;
				}
			});
		},
		loadTitle : function(){
			var titleLabel = document.querySelector(".group_visual .preview_txt_tit");
			var title = displayInfoResponse.displayInfo.productDescription;
			titleLabel.innerText = title;			
		}
	};
	
	function StoreDetail(myPriceObj){
		this.loadText(myPriceObj);
	}
	StoreDetail.prototype = {
 		loadText : function(myPriceObj){
 			var detailLabels = document.querySelectorAll(".section_store_details .dsc");
 			var placelabel = detailLabels[0];
 			var openingHoursLabel = detailLabels[1];
 			var priceLabel = detailLabels[2];
 			
 			var placeStreet = displayInfoResponse.displayInfo.placeStreet;
 			placelabel.innerText = placeStreet;	 			
 			var openingHours = displayInfoResponse.displayInfo.openingHours;
 			openingHoursLabel.innerText = openingHours;
 			var typeNames = myPriceObj.typeNames;
 			var prices = myPriceObj.discountPrices;
 			var priceLen = myPriceObj.length;
 			var priceStr = "";
 			for(var i=0; i<priceLen; ++i){
 				priceStr += typeNames[i];
 				priceStr += " ";
 				priceStr += prices[i].toLocaleString();
 				priceStr += "원";
 				if(i<priceLen-1) priceStr += " / ";
 			}
 			priceLabel.innerText = priceStr;
 		}
	};
	
	function BookingTicket(myPriceObj){
		this.contentLoad(myPriceObj);
		this.registerEvent(myPriceObj);
	}
	BookingTicket.prototype = {
		contentLoad : function(myPriceObj){
			var productPrices = displayInfoResponse.productPrices;
			var typeNames = myPriceObj.typeNames;
 			var prices = myPriceObj.discountPrices;
 			var priceLen = myPriceObj.length;
 			var container = document.querySelector(".ticket_body");
 			var template = document.querySelector("#bookingItem").innerText;
			var bindingTemplate = Handlebars.compile(template);
 			for(var i=0; i<priceLen; ++i){
 				container.innerHTML += bindingTemplate(this.makeTemplateObject(typeNames[i], prices[i], productPrices[i], i));
 			}
		},
		makeTemplateObject : function(typeName, price, productPrice, i){
			var idx = typeName.indexOf('(');
			if(idx!=-1){
				typeName = typeName.slice(0, idx);
			}
			price = price.toLocaleString();
			var obj = {};
			obj.productPriceId =  productPrice.productPriceId;
			obj.typeName = typeName;
			obj.price = price;
			obj.discountRate = productPrice.discountRate;
			obj.index = i;
			return obj;
		},
		registerEvent : function(myPriceObj){
 			var container = document.querySelector(".ticket_body");
 			container.addEventListener("click", function(evt){
 				if(evt.target.tagName === 'A'){
 					var qty = evt.target.closest(".qty");
 					var countLabel = qty.querySelector(".count_control_input");
 					if(this.isPlusButton(evt.target.className)){
 						this.countUp(countLabel);
 					}else if(!this.isDisabled(evt.target.className)){
 						this.countDown(countLabel);
 					}
 					this.refreshTotalPrice(qty, myPriceObj);
 				}
 			}.bind(this));
		},
		isPlusButton : function(className){
			var list = className.split(' ');
			return list.some(s=>s==="ico_plus3");
		},
		isDisabled : function(className){
			var list = className.split(' ');
			return list.some(s=>s==="disabled");
		},
		countUp : function(countLabel){
			var count = countLabel.value;
			count = parseInt(count) + 1;
			if(count === 1) this.setAbled(countLabel);
			this.updateCountLabel(countLabel, count);
		},
		countDown : function(countLabel){
			var count = countLabel.value;
			count = parseInt(count) - 1;
			if(count === 0) this.setDisabled(countLabel);
			this.updateCountLabel(countLabel, count);
		},
		setDisabled : function(countLabel){
			var qty = countLabel.closest(".qty");
			var minusButton = qty.querySelector(".ico_minus3");
			this.addClassName(minusButton, "disabled");
			this.addClassName(countLabel, "disabled");
		},	
		setAbled : function(countLabel){
			var qty = countLabel.closest(".qty");
			var minusButton = qty.querySelector(".ico_minus3");
			this.deleteClassName(minusButton, "disabled");
			this.deleteClassName(countLabel, "disabled");
		},
		addClassName : function(element, name){
			var list = element.className.split(' ');
			list.push(name);
			element.className = list.join(' ');
		},
		deleteClassName : function(element, name){
			var list = element.className.split(' ');
			var idx = list.indexOf(name);
			if(idx!=-1){
				list.pop(idx);
			}
			element.className = list.join(' ');
		},
		updateCountLabel(countLabel, count){
			countLabel.value = count;
		},
		refreshTotalPrice : function(qty, myPriceObj){
			var countLabel = qty.querySelector(".count_control_input");
			var indexLabel = qty.querySelector(".index");
			var totaPriceLabel = qty.querySelector(".total_price");
			var count = parseInt(countLabel.value);
			var index = parseInt(indexLabel.innerText);
			var totalPrice = count * myPriceObj.discountPrices[index];
			totaPriceLabel.innerText = totalPrice;
		}
	};
});






