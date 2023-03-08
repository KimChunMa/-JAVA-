function doGET(){
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"get",
		
		success:(result) => {}
	})
}

function doPOST(){
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"post",
		success:(result) => {}
	})
}

function doPUT(){
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"put",
		success:(result) => {}
	})
}

function doDELETE(){
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"delete",
		success:(result) => {}
	})
}

//------------------------------------------------------
function onwrite(){
	
	let info={
		content: document.querySelector('.content').value,
		writer: document.querySelector('.writer').value,
	}
	
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"post",
		data : info,
		success:(r) => {
			if(r == 'true'){//문자로 받으면
				alert('등록성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value ='';
				onlist();
			}else{
				alert('실패');
			}
		}
	})
	
	
}


//출력
onlist();
function onlist(){
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"get",
		success:(r) => {
			console.log(r);
			
			let html = `<table border="1"> 
							<tr>
								<th> 게시물 번호 </th> 
								<th> 게시물 내용 </th> 
								<th> 게시물 작성자 </th> 
								<th> 게시물 날짜 </th>
								<th> 수정/삭제 </th>
							</tr>`;
							
			r.forEach( (o,i)=>{
				html += `
							<tr>
								<td> ${o.bno} </td> 
								<td> ${o.bcontent} </td> 
								<td> ${o.bwriter} </td> 
								<td> ${o.bdate} </td>
								<td> <button onclick="onEdit(${o.bno})">수정 </button> 
									 <button onclick="onDel(${o.bno})">삭제 </button> 
								</td>
							</tr>`
			})
			
			html += `</table`;
		document.querySelector('.log').innerHTML = html;
		}//success
	})
}// onlist

function onDel(bno){

	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"delete",
		data : {"bno":bno},
		success:(r) => {
			 onlist();
			
		}
	})
	
}//onDel e

function onEdit(bno){
	
	let newContent = prompt("수정할내용");
	$.ajax({
		url:"/jspWeb/Ex3/Board",
		method:"put",
		data : {"bno":bno , "newContent":newContent},
		success:(r) => {
			onlist();
		}
	})
}//onDel e


//--------------------------과제용-------------------------
//입력
function register(){
	
	let info={
		pname: document.querySelector('.pname').value,
		pprice: document.querySelector('.pprice').value
	}
	
		$.ajax({
		url:"/jspWeb/Ex3/Product",
		method:"post",
		data : info,
		success:(r) => {
			if(r=='true'){alert('성공!'); product_print();}
			else{alert('실패!');}
		}
	})
	
}

//출력
product_print()
function product_print(){
		$.ajax({
		url:"/jspWeb/Ex3/Product",
		method:"get",
		success:(r) => {
			console.log(r);
			let html = `<table border="1"> 
							<tr>
								<th> 제품 번호 </td>
								<th> 제품 이름 </td>
								<th> 제품 가격 </td>
								<th> 수정/삭제 </td>
							</tr>`;
							
			r.forEach((o)=>{
				html += `<tr>
							<td> ${o.pno} </td>
							<td> ${o.pname} </td>
							<td> ${o.pprice} </td>
							<td> <button type="button" onclick="product_edit(${o.pno})">수정 </button>
							 	<button type="button" onclick="product_delete(${o.pno})">삭제 </button>
							</td>
						</tr>`;
			})
			html +=`</table>`
			document.querySelector('.plist').innerHTML = html;
		}
	})//ajax
}

//삭제
function product_delete(pno){
		$.ajax({
		url:"/jspWeb/Ex3/Product",
		method:"delete",
		data:{"pno":pno},
		success:(r) => {
			if(r=='true'){alert('삭제성공!'); product_print();}
			else{alert('삭제 실패!')}
		}
	})
}	

//수정

function product_edit(pno){
	let newPrice = prompt('수정할 가격을 입력해주세요')
		$.ajax({
		url:"/jspWeb/Ex3/Product",
		method:"put",
		data:{"pno":pno,"newPrice":newPrice},
		success:(r) => {
			 product_print();
			
		}
	})
}


