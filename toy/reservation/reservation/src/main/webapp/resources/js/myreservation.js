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

function isPastDate(date){
	var cur = new Date();
	return cur-date>=0?true:false;
}

document.addEventListener("DOMContentLoaded", function(){
	// Card 객체보다 이녀석을 더 이전에 만들어서 분리되어 있는데,
	// 리팩토링 한다면 card 객체들을 이용할수도 있겠다. 
	function SummaryBoard(){
		this.activeId = "total";
		this.registerEvent();
	}
	SummaryBoard.prototype = {
		refresh : function(confirmedLen, usedLen, canceledLen){
			var container = document.querySelector(".summary_board");
			var totalLabel = container.querySelector("li:nth-of-type(1) span");
			var confirmedLabel = container.querySelector("li:nth-of-type(2) span");
			var usedLabel = container.querySelector("li:nth-of-type(3) span");
			var canceledLabel = container.querySelector("li:nth-of-type(4) span");
			var total = confirmedLen + usedLen + canceledLen;
			totalLabel.innerText = total;
			confirmedLabel.innerText = confirmedLen;
			usedLabel.innerText = usedLen;
			canceledLabel.innerText = canceledLen;
			this.refreshCard(this.activeId);
		},
		 refreshCard : function(id){
			if(id==="total"){
				var totalLen = parseInt(document.querySelector(".summary_board #total span").innerText);
				if(totalLen === 0) {
					this.hideCardAll();
					this.showNoneCard();
				}
				else {
					this.showCardAll();
					this.hideNoneCard();
				}
			}else{
				this.showAndHideOthers(id);
			}
		},
		registerEvent : function(){
			var container = document.querySelector(".summary_board");
			container.addEventListener("click", function(evt){
				var curActive = document.querySelector(`.summary_board #${this.activeId} .link_summary_board`);
				deleteClassName(curActive, "on");
				var li = evt.target.closest("li");
				var id = li.id;
				this.activeId = id;
				var newActive = document.querySelector(`.summary_board #${this.activeId} .link_summary_board`);
				addClassName(newActive, "on");
				this.refreshCard(id);
			}.bind(this));
		},
		showAndHideOthers : function(id){
			var cards = container.querySelectorAll(".list_cards .card");
			cards.forEach(function(card){
				if(card.id === id+"Card"){
					if(this.isExist(id)) {
						card.style.display = "block";
						this.hideNoneCard();
					}
					else{
						card.style.display = "none";
						this.showNoneCard();
					}
				}
				else {
					card.style.display = "none";
				}
			}.bind(this));
		},
		showCardAll : function(){
			var cards = container.querySelectorAll(".list_cards .card");
			cards.forEach(function(card){
				var cardId = card.id;
				var id = cardId.slice(0, cardId.length-"Card".length);
				if(this.isExist(id)){
					card.style.display = "block";
				}else{
					card.style.display = "none";
				}
			}.bind(this));
		},
		hideCardAll : function(){
			var cards = container.querySelectorAll(".list_cards .card");
			cards.forEach(function(card){
				card.style.display = "none";
			});
		},
		isExist : function(id){
			var len = parseInt(document.querySelector(`.summary_board #${id} span`).innerText); 
			return len > 0;
		},
		showNoneCard : function(){
			var noneCard = document.querySelector(".err");
			noneCard.style.display = "block";
		},
		hideNoneCard : function(){
			var noneCard = document.querySelector(".err");
			noneCard.style.display = "none";
		}
	};
	function Card(id){
		this.id = id;
		this.card = document.querySelector(`.list_cards #${id}Card`);
	}
	Card.prototype = {
		show : function(){
			this.card.style.display = "block";
		},
		hide : function(){
			this.card.style.display = "none";
		},
		clearItem : function(){
			var items = this.card.querySelectorAll("article");
			items.forEach(function(item){
				this.card.removeChild(item);
			}.bind(this));
		}
	};
	
	// 만들고 보니 상속 안해도 되지만 공부한김에 남겨두었음 
	function ExtendsCard(id){
		// Card의 멤버 가져오기 
		Card.call(this,id);	
		this.registerEvent();
	}
	ExtendsCard.prototype = Object.create(Card.prototype);
	// constructor 안바뀌므로 직접 바꿔줌
	ExtendsCard.prototype.constructor = ExtendsCard;
	ExtendsCard.prototype.refresh = function(confirmedList){
		var template = document.querySelector("#cardItem").innerText;
		var bindingTemplate = Handlebars.compile(template);
		this.clearItem();
		confirmedList.forEach(function(reservation){
			if(this.id === "confirmed") reservation.isConfirmed = true;
			else reservation.isConfirmed = false;
			if(this.id === "used") reservation.isUsed = true;
			else reservation.isUsed = false;
			reservation.totalPrice = reservation.totalPrice.toLocaleString();
			this.card.insertAdjacentHTML("beforeend", bindingTemplate(reservation));
		}.bind(this));
	}; // 세미콜론 꼭 찍어야 한다.
	ExtendsCard.prototype.registerEvent = function(){
		this.card.addEventListener("click", function(evt){
			var tagName = evt.target.tagName;
			if(tagName === "BUTTON" || tagName==="SPAN"){
				var div = evt.target.closest("div");
				if(div.className === "booking_cancel"){
					var reservationInfoId = div.querySelector(".reservationInfoId").innerText;
					sendAjaxPut(reservationInfoId).then(function(){
						// 성능 낭비이긴 한데 확실하고 편하게 호출하였음
						sendAjaxAndrefresh();
					});
				}else{
					var productId = div.querySelector(".productId").innerText; 
					location.href = `/products/${productId}/review`;
				}
			}
		});
	};
	
	var summaryObj = new SummaryBoard();
	var confirmedObj = new ExtendsCard("confirmed");
	var usedObj = new ExtendsCard("used");
	var canceledObj = new ExtendsCard("cancel");
	
	(function main(){
		initRegisterChkButton();
		sendAjaxAndrefresh();
	})();
	
	function initRegisterChkButton(){
		// 예약확인 버튼 
		var myReservationBtn = document.querySelector(".header_tit .btn_my");
		myReservationBtn.addEventListener("click", function(){
			var emailLabel = document.querySelector(".viewReservation");
			if(emailLabel.innerText === "예약확인"){
				location.href = "/login";
			}else{
				location.href = "/reservations/me";
			}
		});
	}
	
	function sendAjaxAndrefresh(){
		sendAjaxGet().then(function(json){
			var reservationInfoResponse = json;
			var reservations = reservationInfoResponse.reservations;
			var size = reservationInfoResponse.size;
			var confirmedList = [];
			var usedList = [];
			var canceledList = [];
			reservations.forEach(function(reservation){
				if(reservation.cancelYn){
					canceledList.push(reservation);
				}else if(isPastDate(Date.parse(reservation.reservationDate))){
					usedList.push(reservation);
				}else{
					confirmedList.push(reservation);
				}				
			});
			var confirmedLen = confirmedList.length;
			var usedLen = usedList.length;
			var canceledLen = canceledList.length;
			confirmedObj.refresh(confirmedList);
			usedObj.refresh(usedList);
			canceledObj.refresh(canceledList);
			summaryObj.refresh(confirmedLen, usedLen, canceledLen);
		});
	}
	
	function sendAjaxGet(){
		var url = "/api/reservations?reservationEmail=";
		var email = document.querySelector(".header .viewReservation").innerText;
		url += email;
		return fetch(url).then(function(response){
			if(response.status===200 || response.status===201){
				return response.json();
			}else{				
				// fail
			}
		}).catch(function(){
			// catch
		});		
	};
	
	function sendAjaxPut(reservationInfoId){
		var url = "/api/reservations/" + reservationInfoId;
		var data = {
			method: "PUT",
			headers: {
	            "Content-Type": "application/json; charset=utf-8"
	        }
		};
		return fetch(url, data).then(function(response){
			if(response.status===200 || response.status===201){
				return response.json();
			}else{
				
			}
		}).catch(function(error){
			
		});
	}
});











	