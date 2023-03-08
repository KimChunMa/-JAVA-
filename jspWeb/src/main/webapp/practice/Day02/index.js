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
			//console.log(result);
			//document.querySelector('.ex1_box').innerHTML = result;
			
			let html = `<table border="1px solid black">
								<tr>
									<th> data1 </th> <th> data2 </th> <th> data3 </th> 
									<th> data4 </th> <th> data5 </th> <th> data6 </th> 
									<th> data7 </th> <th> data8 </th> <th> data9 </th> 
									<th> data10 </th> 
								</tr>
							`
			
			result.forEach( (o,i) => {
				html += `
							<tr>
								<td> ${o.data1} </td> <td> ${o.data2} </td> <td> ${o.data3} </td> 
								<td> ${o.data4} </td> <td> ${o.data5} </td> <td> ${o.data6} </td> 
								<td> ${o.data7} </td> <td> ${o.data8} </td> <td> ${o.data9} </td> 
								<td> ${o.data10} </td> 
							</tr>
						
						`
			})//foreach e	
			html += `</table>`
			document.querySelector('.ex1_box').innerHTML = html;
		}
	})
}
