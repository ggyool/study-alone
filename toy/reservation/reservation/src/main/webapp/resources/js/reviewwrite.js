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
		}
	};
	
	
	(function main(){
		var rating = new Rating();
	})();

})


