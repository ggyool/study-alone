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
	
	// 클릭이벤트, 각각 card 개수
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
			console.log(this);
			var items = this.card.querySelectorAll("article");
			items.forEach(function(item){
				console.log(this.card);
				this.card.removeChild(item);
			}.bind(this));
		}
	};
	
	// 만들고 보니 상속 안해도 되지만 공부한김에 남겨두었음 
	function ConfirmedCard(id){
		// Card의 멤버 가져오기 
		Card.call(this,id);	
	}
	ConfirmedCard.prototype = Object.create(Card.prototype);
	// constructor 안바뀌므로 직접 바꿔줌
	ConfirmedCard.prototype.constructor = ConfirmedCard;
	ConfirmedCard.prototype.refresh = function(confirmedList){
		var template = document.querySelector("#confirmedItem").innerText;
		var bindingTemplate = Handlebars.compile(template);
		this.clearItem();
		confirmedList.forEach(function(reservation){
			this.card.insertAdjacentHTML("beforeend", bindingTemplate(reservation));
		}.bind(this));
	}; // 세미콜론 꼭 찍어야 한다.

	(function main(){
		var summaryObj = new SummaryBoard();
		var confirmedObj = new ConfirmedCard("confirmed");
		sendAjaxAndrefresh(summaryObj, confirmedObj);
	
	})();
	
	function sendAjaxAndrefresh(summaryObj, confirmedObj){
		sendAjax().then(function(json){
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
			summaryObj.refresh(confirmedLen, usedLen, canceledLen);
			confirmedObj.refresh(confirmedList);
		});
	}
	
	function sendAjax(){
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
	
	
});

	