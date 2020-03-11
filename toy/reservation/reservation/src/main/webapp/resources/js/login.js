document.addEventListener("DOMContentLoaded", function(){
	
	function ConfirmForm(){
		this.registerEvent();
	}
	ConfirmForm.prototype = {
		registerEvent : function(){
			console.log("sad");
			var form = document.querySelector("#form1");
			var loginBtn = form.querySelector(".login_btn");
			loginBtn.addEventListener("click", function(evt){
				evt.preventDefault();
				var emailInput = form.querySelector(".login_input");
				var email = emailInput.value;
				if(this.checkEmail(email)){
					form.submit();
				}else{
					alert("올바르지 않은 이메일 형식입니다.")
				}
			}.bind(this));
		},
		checkEmail : function(email){
			return email.match(/^[a-z0-9A-Z-+_.]+@[a-z0-9A-Z-]+\.[a-zA-Z]{2,4}$/);
		}
	};
	
	(function init(){
		new ConfirmForm(); 
	})();
	
});

