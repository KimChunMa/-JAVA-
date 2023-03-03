function ex1(){
	//변수 10개 --------> 객체 {} 1개
	let info = {
	data1 : document.querySelector('.data1').value,
	data2 : document.querySelector('.data2').value,
	data3 : document.querySelector('.data3').value,
	data4 : document.querySelector('.data4').value,
	data5 : document.querySelector('.data5').value,
	data6 : document.querySelector('.data6').value,
	data7 : document.querySelector('input[ name="data7" ]:checked').value,
	data8 : document.querySelector('.data8').checked,
	data9 : document.querySelector('.data9').value,
	data10 : document.querySelector('.data10').value,
	}
	console.log(info);
	
	$.ajax({
		url: "/jspWeb/Ex2", 		
		method: "post",
		data: info,
		success: function(result){
				if(result == 'true'){
					alert('등록성공'); getData();
				}else{alert('등록 실패')}
			
			
		}
	})
}

getData();

function getData(){
	$.ajax({
		url: "/jspWeb/Ex2",		
		method: "get",
		
		success: function(result){
			console.log(result);
			document.querySelector('.ex1_box').innerHTML = result;	
		}
	})
}
