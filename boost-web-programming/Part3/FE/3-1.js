var origin = [1,2,3,4];
var change = [...origin, 2,3];

change.forEach(function(v,i,o){
    console.log(v,i,o);
})