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


document.addEventListener("DOMContentLoaded", function(){
	
	function Rating(){
		this.curScore = 0;
		this.stars = document.querySelectorAll(".rating_rdo");
		this.registerEvent();
	}
	Rating.prototype = {
		registerEvent : function(){
			var ratingBar = document.querySelector(".rating");
			ratingBar.addEventListener("click", function(evt){
				var tagName = evt.target.tagName;
				if(tagName === "INPUT"){
					var clickScore = parseInt(evt.target.value); 
					if(clickScore > this.curScore){
						this.checkStar(this.curScore+1, clickScore);
						this.curScore = clickScore;
						this.updateLabel();
					}else if(clickScore < this.curScore){
						this.unCheckStar(clickScore + 1, this.curScore);
						this.curScore = clickScore;
						this.updateLabel();
					}
				}
			}.bind(this));
		},
		checkStar : function(start, end){
			for(var i=start; i<=end; ++i){
				addClassName(this.stars[i-1], "checked");
			}
		},
		unCheckStar : function(start, end){
			for(var i=start; i<=end; ++i){
				deleteClassName(this.stars[i-1], "checked");
			}
		},	
		updateLabel : function(){
			var scoreLabel = document.querySelector(".star_rank");
			if(hasClassName(scoreLabel, "gray_star"))
				deleteClassName(scoreLabel, "gray_star");
			scoreLabel.innerText = this.curScore;
		},
		getScore : function(){
			return this.curScore;
		}
	};
	
	function ReviewWrite(){
		this.MIN_LENGTH = 5;
		this.MAX_LENGTH = 400;
		this.init();
		this.registerEvent();
	}
	ReviewWrite.prototype = {
		init : function(){
			var textArea = document.querySelector(".review_textarea");
			textArea.maxLength = this.MAX_LENGTH;
		},
		registerEvent : function(){
			var info = document.querySelector(".review_write_info");
			var textArea = document.querySelector(".review_textarea");
			var textCountLabel = document.querySelector(".guide_review span")
			info.addEventListener("click", function(evt){
				var tagName = evt.target.tagName;
				if(tagName === "A" || tagName === "SPAN"){
					info.style.display = "none";
					textArea.focus();
				}
			});
			textArea.addEventListener("input", function(evt){
				textCountLabel.innerText = textArea.textLength;
			});
			// focus 를 잃었을 때
			textArea.addEventListener("blur", function(evt){
				if(textArea.textLength == 0){
					info.style.display = "block";	
				}
			});
		},
		getComment : function(){
			var textArea = document.querySelector(".review_textarea");
			return textArea.value;
		},
		getMinLength : function(){
			return this.MIN_LENGTH;
		}
	};
	
	function ReviewImage(){
		this.registerEvent();
	}
	ReviewImage.prototype = {
		registerEvent : function(){
			var fileInput = document.querySelector("#reviewImageFileOpenInput");
			var imageContainer = document.querySelector(".review_photos .lst_thumb");
			fileInput.addEventListener("change", function(evt){
				const image = evt.target.files[0];	
				var template = document.querySelector("#imageItem").innerText;
				var bindingTemplate = Handlebars.compile(template);
				imageContainer.innerHTML = bindingTemplate({imageURL: window.URL.createObjectURL(image)}); 
			});
			
			imageContainer.addEventListener("click", function(evt){
				if(evt.target.className === "spr_book ico_del"){
					imageContainer.innerHTML = "";
					fileInput.value = "";
				}
			});
		}
	};
	
	function SubmitButton(rating, reviewWrite, reviewImage){
		this.registerEvent(rating, reviewWrite, reviewImage);
	}
	SubmitButton.prototype = {
		registerEvent : function(rating, reviewWrite, reviewImage){
			var btn = document.querySelector(".box_bk_btn .bk_btn");
			btn.addEventListener("click", function(){
				var errorMsg = this.checkValidation(rating, reviewWrite);
				if(errorMsg != null){
					alert(errorMsg);
				}else{
					// 처음에는 동적 form 생성해서 submit 했으나, response 받을 수 없어서 바꿨다.
					var xhr = new XMLHttpRequest();
					xhr.onload = function(){
						if (xhr.status === 200 || xhr.status === 201) {	  
							alert("리뷰 등록에 성공했습니다.");
							location.href = "/reservations/me";
						}else{
							alert("리뷰 등록에 실패했습니다. 잠시 후 다시 시도하세요.");
						}
					};
					var formData = this.makeFormData(rating, reviewWrite, reviewImage);
					xhr.open("POST", this.makeRequestURL());
					xhr.setRequestHeader("enctype", "multipart/form-data");
					xhr.send(formData);
				}
			}.bind(this));
		},
		checkValidation : function(rating, reviewWrite){
			var score = parseInt(rating.getScore());
			if(score===0) {
				return "별점을 등록하세요.";
			}
			var text = reviewWrite.getComment().trim();
			// 앞 뒤 trim, g(global)
			text = text.replace(/(^\s*)|(\s*$)/g, "");
			// 변수를 사용하려고 new 로 생성 
			var re = new RegExp('.{'+reviewWrite.getMinLength()+'}');
			if(!re.test(text)){
				return "글자수가 너무 짧습니다.";
			}
			return null;
		}, 
		makeFormData : function(rating, reviewWrite, reviewImage){
			var formData = new FormData();
			var productId = parseInt(document.querySelector("#productId").innerText);
			var comment = reviewWrite.getComment();
			var score = rating.getScore();
			var fileInput = document.querySelector("#reviewImageFileOpenInput");
			if(fileInput.value) formData.append("attachedImage", fileInput.files[0]);
			formData.append("productId", productId);
			formData.append("comment", comment);
			formData.append("score", score);
			return formData;
		},
		makeRequestURL : function(){
			var locationPath = location.pathname;
			var list = locationPath.split('/');
			list = list.filter(s=>s); // 비어있는것을 버린다.
			var reservationInfoId = parseInt(list[list.length - 2]);
			return `/api/reservations/${reservationInfoId}/comments`;
		}
		
	};
	
	(function main(){
		// 주소창 입력으로 들어온 경우
		if(!document.referrer){
			alert("잘못된 접근입니다.");
			history.back();
		}
		var rating = new Rating();
		var reviewWrite = new ReviewWrite();
		var reviewImage = new ReviewImage();
		var submitButton = new SubmitButton(rating, reviewWrite, reviewImage);
	})();

})


