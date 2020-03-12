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
					if(totalLen === 0) this.hideCardAll();
					else this.showCardAll();
				}else{
					this.showAndHideOthers(id);
				}
			}.bind(this));
		},
		showAndHideOthers : function(id){
			var cards = container.querySelectorAll(".list_cards .card");
			cards.forEach(function(card){
				if(card.id === id+"Card"){
					this.showCard(id);
				}
				else this.hideCard(card.id);
			}.bind(this));
		},
		showCardAll : function(){
				this.hideNoneCard();
				var cards = container.querySelectorAll(".list_cards .card");
				cards.forEach(function(card){
					card.style.display = "block";
				});
		},
		hideCardAll : function(){
			this.showNoneCard();
			var cards = container.querySelectorAll(".list_cards .card");
			cards.forEach(function(card){
				card.style.display = "none";
			});
		},
		showCard : function(id){
			var len = parseInt(document.querySelector(`.summary_board #${id} span`).innerText); 
			var card = document.querySelector(`#${id}Card.card`);
			if(len === 0) {
				this.showNoneCard();
				card.style.display = "none";
			}else{
				this.hideNoneCard();
				card.style.display = "block";
			}
		},
		hideCard : function(cardId){
			var card = document.querySelector(`#${cardId}.card`);
			card.style.display = "none";
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
	
	//var summaryObj;
	(function init(){
		var summaryObj = new SummaryBoard();
		sendAjaxAndrefresh(summaryObj);
	})();
	
	
	function sendAjaxAndrefresh(summaryObj){
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

	