function b(){
	
	let data = document.querySelector('.intext').value;
	
	$.ajax({
		url : "http://192.168.17.34:8080/jspWeb/s1",
		method: "post",
		data : {"data" : data},
		success : function(result){
			console.log(result);
		}
	});
}

print();
function print(){
	$.ajax({
		url : "http://192.168.17.34:8080/jspWeb/s1",
		method: "get",
		
		success : function(result){
			document.querySelector('.box').innerHTML = result;
		}
	});
}