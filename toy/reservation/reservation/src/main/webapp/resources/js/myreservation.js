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
//	var reservationInfoResponse;
	(function init(){
		var url = "/api/reservations?reservationEmail=";
		var email = document.querySelector(".header .viewReservation").innerText;
		url += email;
		fetch(url).then(function(response){
			if(response.status===200 || response.status===201){
				return response.json();
			}else{				
				// fail
			}
		}).then(function(json){
			// main
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
			new SummaryBoard(confirmedList.length, usedList.length, canceledList.length);
			
			
		}).catch(function(){
			// catch
		});		
	})();
	
	// 클릭이벤트, 각각 card 개수
	function SummaryBoard(confirmedLen, usedLen, canceledLen){
		this.init(confirmedLen, usedLen, canceledLen);
	}
	SummaryBoard.prototype = {
		init : function(confirmedLen, usedLen, canceledLen){
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
		}
	};
});

	
/*	
	return response.json();
}).then(function(json){
	
})*/