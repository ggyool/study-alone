var healthObj = {
  name : "달리기",
  lastTime : "PM10:12",
  showHealth : function() {
    setTimeout(function() {
        console.log(this, this.name, this.lastTime);      
    }, 1000)
  }
}
//달리기 PM10:12
healthObj.showHealth();