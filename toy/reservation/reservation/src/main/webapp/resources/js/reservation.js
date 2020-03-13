document.addEventListener("DOMContentLoaded", function(){
	
	var displayInfoResponse;
	
	(function init(){
		var locationPath = location.pathname;
		var list = locationPath.split('/');
		list = list.filter(s=>s); // 비어있는것을 버린다.
		var url = "/api/products/" + list[list.length - 1];
		fetch(url).then(function(response){
			if(response.status===200 || response.status===201){
				return response.json();
			}
		}).then(function(json){
			displayInfoResponse = json;
			var myPriceObj = new MyPrice();
			var validateObj = new Validate();
			new TopTitle();
			new GroupVisual();
			new StoreDetail(myPriceObj);
			new BookingTicket(myPriceObj);
			new BookingForm(validateObj);
			new AgreementSection();
			new ReservationPost(validateObj);
		});
	})();
	
	function addClassName(element, name){
		var list = element.className.split(' ');
		list.push(name);
		element.className = list.join(' ');
	}
	function deleteClassName(element, name){
		var list = element.className.split(' ');
		var idx = list.indexOf(name);
		if(idx!=-1){
			list.pop(idx);
		}
		element.className = list.join(' ');
	}
	function hasClassName(element, name){
		var list = element.className.split(' ');
		return list.some(s=>s===name);
	}
	function getNowWithString(){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		var ret = year;
		ret += `-${month<10?0:''}${month}`
		ret += `-${day<10?0:''}${day}`; 
		ret += ` ${hour<10?0:''}${hour}`;
		ret += `:${minute<10?0:''}${minute}`;
		ret += `:${second<10?0:''}${second}`;
		return ret;
	}
	
	// 어렵.. 잘 모르겠음
	// validation 떠서 properties->javascript->Exclude path에 추가하였음
	async function sendAjaxPost(url, bodyObj, success, fail){
		var data = {
			method: "POST",
			headers: {
	            "Content-Type": "application/json; charset=utf-8"
	        },
			body: JSON.stringify(bodyObj)
		};
		return fetch(url, data).then(function(response){
			if(response.status===200 || response.status===201){
				success();
				return response.json();
			}else{
				fail();
			}
		}).then(function(json){
			responseObj = json;
		}).catch(function(error){
			console.log(error);
		});
	}
	
	
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
 					if(this.isPlusButton(evt.target)){
 						this.countUp(countLabel);
 					}else if(!this.isDisabled(evt.target)){
 						this.countDown(countLabel);
 					}
 					this.refreshTotalPrice(myPriceObj);
 				}
 			}.bind(this));
		},
		isPlusButton : function(element){
			return hasClassName(element, "ico_plus3");
		},
		isDisabled : function(element){
			return hasClassName(element, "disabled");
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
			addClassName(minusButton, "disabled");
			addClassName(countLabel, "disabled");
		},	
		setAbled : function(countLabel){
			var qty = countLabel.closest(".qty");
			var minusButton = qty.querySelector(".ico_minus3");
			deleteClassName(minusButton, "disabled");
			deleteClassName(countLabel, "disabled");
		},
		updateCountLabel(countLabel, count){
			countLabel.value = count;
		},
		refreshTotalPrice : function(myPriceObj){
			var qtys = document.querySelectorAll(".ticket_body .qty");	
			var totalPriceLabel = document.querySelector(".booking_form_wrap #totalPrice");	
			var totalCountLabel = document.querySelector(".booking_form_wrap #totalCount");	
			var totalPrice = 0;
			var totalCount = 0;
			qtys.forEach(function(qty, idx){
				var countLabel = qty.querySelector(".count_control_input");
				var indexLabel = qty.querySelector(".index");
				var qtyPriceLabel = qty.querySelector(".total_price");
				var count = parseInt(countLabel.value);
				var index = parseInt(indexLabel.innerText);
				var qtyPrice = count * myPriceObj.discountPrices[index];
				qtyPriceLabel.innerText = qtyPrice.toLocaleString();
				totalCount += count;
				totalPrice += qtyPrice; 
			});
			totalPriceLabel.innerText = totalPrice.toLocaleString();
			totalCountLabel.innerText = totalCount.toLocaleString();
		}
	};
	
	// 유효성 체크하는 객체
	function Validate(){
		
	}
	Validate.prototype = {
		// 한글 또는 영만 가능
		checkName : function(name){
			return name.match(/^[가-힣a-zA-z]+$/);
		},
		checkTelephone : function(telephone){
			return telephone.match(/010\d{7,8}$|010-\d{3,4}-\d{4}$/);
		},
		checkEmail : function(email){
			return email.match(/^[a-z0-9A-Z-+_.]+@[a-z0-9A-Z-]+\.[a-zA-Z]{2,4}$/);
		},
		hasHyphenInTelephone : function(telephone){
			return telephone.indexOf('-') != -1;
		},
		addHyphenInTelephone : function(telephone){
			var firstSlice, secondSlice;
			if(telephone.length === 10){
				firstSlice = telephone.slice(3,6);
				secondSlice = telephone.slice(6);
			}else{
				firstSlice = telephone.slice(3,7);
				secondSlice = telephone.slice(7);
			}
			return `010-${firstSlice}-${secondSlice}`;
		}
	};
	
	function BookingForm(validateObj){
		this.registerEvent(validateObj);
	}
	BookingForm.prototype = {
		registerEvent : function(validateObj){
			var nameInput = document.querySelector(".inline_control #name");
			var telInput = document.querySelector(".inline_control #tel");
			var emailInput = document.querySelector(".inline_control #email");
			nameInput.addEventListener("change", function(){
				var name = nameInput.value;
				if(!validateObj.checkName(name)){
					this.nextElementSibling.style.visibility = "visible";
				}
			});
			telInput.addEventListener("change", function(){
				var tel = telInput.value;
				if(!validateObj.checkTelephone(tel)){
					this.nextElementSibling.style.visibility = "visible";
				}
			});
			emailInput.addEventListener("change", function(){
				var email = emailInput.value;
				if(!validateObj.checkEmail(email)){
					this.nextElementSibling.style.visibility = "visible";
				}
			});
			var warningMessages = document.querySelectorAll(".inline_control .warning_msg");
			warningMessages.forEach(function(warningMessage){
				warningMessage.addEventListener("click", function(){
					this.style.visibility = "hidden";
				});
			});
		}
	};
	
	function AgreementSection(){
		this.registerEvent();
	}
	AgreementSection.prototype = {
		registerEvent : function(){
			var agreementButtons = document.querySelectorAll(".section_booking_agreement .btn_agreement");
			agreementButtons.forEach(function(agreementButton){
				agreementButton.addEventListener("click", function(){
					var agreement = agreementButton.closest(".agreement");
					if(hasClassName(agreement, "open")){
						deleteClassName(agreement, "open");
					}else{
						addClassName(agreement, "open");
					}
				});
			});
			var checkAgree = document.querySelector(".section_booking_agreement .chk_agree");
			checkAgree.addEventListener("click", function(){
				var reservationButton = document.querySelector(".box_bk_btn .bk_btn_wrap");
				if(checkAgree.checked){
					deleteClassName(reservationButton, "disable");			
				}else{
					addClassName(reservationButton, "disable");
				}
			});
		}
	};
	
	function ReservationPost(validateObj){
		this.registerEvent(validateObj);
	}
	ReservationPost.prototype = {
		registerEvent : function(validateObj){
			var reservationButton = document.querySelector(".bk_btn_wrap");
			reservationButton.addEventListener("click", function(){
				if(hasClassName(reservationButton, "disable")) {
					alert("약관에 동의하셔야 됩니다.");
					return;
				}
				var reservationParam = this.makeReservationParam();
				var error = this.checkValadation(reservationParam, validateObj);
				if(!error){
					var url = "/api/reservations";
					sendAjaxPost(url, reservationParam, this.successAction, this.failAction);
				}else{
					alert(error);
				}
			}.bind(this));
		},
		successAction(){
			alert("예매에 성공했습니다.");
			var displayInfoId = displayInfoResponse.displayInfo.displayInfoId;
			location.href = "/products/" + displayInfoId;
		},
		failAction(){
			alert("예매에 실패했습니다. 잠시 후 다시 시도해주세요.");
		},
		checkValadation : function(reservationParam, validateObj){
			if(reservationParam.prices.length === 0){
				return "예약 수량을 확인하세요.";
			}
			if(!validateObj.checkName(reservationParam.reservationName)){
				return "입력하신 이름에 문제가 있습니다.";
			}
			if(!validateObj.checkTelephone(reservationParam.reservationTelephone)){
				return "입력하신 연락처에 문제가 있습니다.";
			}
			if(!validateObj.hasHyphenInTelephone(reservationParam.reservationTelephone)){
				var modifyTelephone = validateObj.addHyphenInTelephone(reservationParam.reservationTelephone);
				reservationParam.reservationTelephone = modifyTelephone;
			}
			if(!validateObj.checkEmail(reservationParam.reservationEmail)){
				return "입력하신 이메일에 문제가 있습니다.";
			}
			return '';
		},
		makeReservationParam : function(){
			var reservationParam = {
				displayInfoId : displayInfoResponse.displayInfo.displayInfoId,
				prices : this.getPrices(),
				productId : displayInfoResponse.displayInfo.productId,
				reservationEmail : this.getEmail(),
				reservationName : this.getName(),
				reservationTelephone : this.getTelephone(),
				reservationYearMonthDay : getNowWithString()
			};
			return reservationParam;
		},
		getName : function(){
			var nameInput = document.querySelector(".inline_control #name");
			return nameInput.value;
		},
		getTelephone : function(){
			var telInput = document.querySelector(".inline_control #tel");
			return telInput.value;
		},
		getEmail : function(){
			var emailInput = document.querySelector(".inline_control #email");
			return emailInput.value;
		},
		getPrices : function(){
			var prices = [];
			var qtys = document.querySelectorAll(".ticket_body .qty");
			qtys.forEach(function(qty){
				var id = parseInt(qty.querySelector(".id").innerText);
				var countInput = parseInt(qty.querySelector(".count_control_input").value);
				var price = {
					count : countInput, 
					productPriceId : id,
					reservationInfoId : 0,
					reservationInfoPriceId : 0
				};
				if(price.count>0) prices.push(price);
			});
			return prices;
		},
	};
});




			


