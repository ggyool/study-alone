var data = [{title : "aaa",content : "간지철철", price : 12000000000},
            {title : "bbb",content : "괜춘한 상품", price : 5500000000},
            {title : "ccc",content : "쩌는상품", price : 1200}];

var filteredData = data.filter(function(v) {
  return v.price > 5000;
}).map(function(v) {
  v.price = (''+v.price).replace(/^(\d+)(\d{3})$/, "$1,$2원");
  return v;
});

console.table(data);
function printFunc(v){
	console.table(v);
}

// 이렇게 하면 원본이 변경 된다.
function mapFunc(v){
	v.price *= 1.1;
	return v;
}

// 이렇게 해도 원본이 변경된다.
function mapFunc2(v){
	var obj = v;
	obj.price *= 1.1;
	return obj;
}

// 원본이 변경되지 않는다.
function mapFunc3(v){
	var obj = {}
	obj.title = v.title;
	obj.content = v.content;
	obj.price = v.price * 1.1;
	return obj;
}

function filterFunc(v){
	return v.price > 5000;
}

// data(원본) 도 바뀌어 있다.
var newData = data.filter(filterFunc).map(mapFunc);

console.table(data);
console.table(newData);
