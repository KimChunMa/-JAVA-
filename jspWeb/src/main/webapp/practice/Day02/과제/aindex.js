function ex1(){

	let info = {
	data1 : document.querySelector('.data1').value,
	data2 : document.querySelector('.data2').value,
	data3 : document.querySelector('.data3').value,
	data4 : document.querySelector('.data4').value,
	data5 : document.querySelector('.data5').value,
	data7 : document.querySelector('input[ name="data7" ]:checked').value,
	data8 : document.querySelector('.data8').checked,
	data9 : document.querySelector('.data9').value,
	data10 : document.querySelector('.data10').value,
	}

	
	$.ajax({
		url:"/jspWeb/AEx",
		method:"post",
		data : info,
		success: function(result){
				if(result == 'true'){
					alert('등록성공');  getData();
				}else{alert('등록 실패')}
		}
	})
}

getData();

function getData(){
	$.ajax({
		url: "/jspWeb/AEx",		
		method: "get",
		
		success: function(result){
		
			let html = `<table border="1px solid black">
								<tr>
									<th> 이름 </th> <th> 전화번호 </th> <th> 키 </th> 
									<th> 나이 </th> <th> 등록일 </th> <th> 성별 </th> 
									<th> 동의 </th> <th> 지역 </th> <th> 소개 </th> 
								</tr>
							`
			
			result.forEach( (o,i) => {
				html += `
							<tr>
								<td> ${o.name} </td> <td> ${o.tel} </td> <td> ${o.tall} </td> 
								<td> ${o.age} </td> <td> ${o.submit} </td> <td> ${o.sex} </td> 
								<td> ${o.agree} </td> <td> ${o.region} </td> <td> ${o.introduce} </td> 
							</tr>
						`
			})//foreach e	
			html += `</table>`
			document.querySelector('.box').innerHTML = html;
		}
	})
}

