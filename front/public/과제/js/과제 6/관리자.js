/* 1 */
/*버거 등록 (클릭시)*/
function Submit(){ 
let s_price = parseInt(document.querySelector('.s_price').value)
let s_category = document.querySelector('.s_category').value


	if(isNaN(s_price)) {alert('가격은 숫자를 입력해주세요')}
	else if (categoryList.indexOf(s_category)<0){alert('카테고리를 확인해주세요')}
	else{
	burgerList.push( { name: document.querySelector('.s_name').value, 
					   price:s_price,
					   img:`img/와퍼/${document.querySelector('.s_img').value}.png`,
					   category:s_category});
alert('등록되었습니다');

//등록된 제품의 카테고리 출력
let index= categoryList.indexOf(burgerList[burgerList.length-1].category)
	category_select(index)
}}


/*2 등록된 버거 현황 출력 (자동)*/
burgarList()
function burgarList(){ //버거리스트 순회 => 출력
	let html = `<tr> 
					<th>제품번호</th>
					<th>이미지</th>
					<th>버거이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th colspan="2">비고</th>
				</tr>`
				
	burgerList.forEach((obj,idx)=>{
		html += `<tr> 
					<td>${idx}</td>
					<td><img src="${burgerList[idx].img}"></td>
					<td>${burgerList[idx].name}</td>
					<td>${burgerList[idx].category}</td>
					<td>${burgerList[idx].price}</td>
					
					<td onclick="Del(${idx})">
					<button>[삭제]</button></td>
					
					<td onclick="Edit(${idx})">
					<button>[가격수정]</button></td>
				</tr>`
	})
	document.querySelector('.out_table').innerHTML = html
}

/* 2-1 삭제*/
function Del(idx){
	burgerList.splice(idx,1)
	outlist()
	category_select(0)
}

/* 2-2 수정*/
function Edit(idx){
	let eprice = parseInt(prompt('수정할 가격을 입력해주세요.'))
	
	if( isNaN(eprice)){
		alert('숫자로 입력하셔야 합니다.')
	}else{
	burgerList[idx].price= eprice
	outlist()
	category_select(0)
	}}


/* 3 주문된 주문 목록 현황 출력*/
orderOut()
function orderOut(){
	let orderout =`<tr> 
						<th> 주문번호 </th>
						<th> 버거이름 </th>
						<th> 요청/완료일 </th>
						<th> 상태  </th>
						<th> 비고 </th>
			   		</tr>`
			   
	orderList.forEach((obj,idx)=>{//주문리스트
		obj.items.forEach((o,j)=>{ //주문리스트에 아이템 반복
		//주문아이템 리스트
		orderout += `<tr> 
						<td>${obj.no}</td>
						<td>${o.name}</td>
						<td class="date${idx}">${obj.time}</td>`})
					
		if(obj.state){
		orderout += `<td class="quest${idx}">주문요청</td>
					 <td><button onclick="quest(${idx})" 
					 class="questbtn${idx}"	>[주문완료]</button></td>
				     </tr>`}
		else{
			orderout += `<td class="quest${idx}">주문완료</td>
					 <td></td>
				     </tr>`}
				     
	time(idx)
	
	})   //주문
	document.querySelector('.order_table').innerHTML = orderout;
}

/* 3-1 주문완료버튼*/
function quest( idx ){
	alert('주문이 완료되었습니다')
	orderList[idx].state = false ; //주문상태
	document.querySelector(`.questbtn${idx}`).style.display='none' //비고
	
	let  quset = document.querySelectorAll(`.quest${idx}`) //요청완료
	quset.forEach((o)=>{ o.innerHTML = '주문완료'})
	time(idx)
}
			

/*3-2 시간*/
function time(i){
	/*시간*/
	const date = new Date().toLocaleDateString('ko-kr');
	const time = new Date().toLocaleTimeString('ko-kr')

	let  today = document.querySelectorAll(`.date${i}`) //요청일
	today.forEach((o)=>{ o.innerHTML = date +" "+time})}

	
/*4 매출 현황*/
sales()


function sales(){
	let sales = `<tr> 
					<th> 제품 번호 </th> 
					<th> 버거이름 </th> 
					<th> 판매수량 </th> 
					<th> 매출액 </th> 
					<th> 순위 </th> 
				</tr>`
				
	group();
				
	// 1. 
	orderList.forEach( (o,i) => {
		
		sales+=`<tr> 
					<th> ${i} </th> 
					<th>  </th> 
					<th> 판매수량 </th> 
					<th> 매출액 </th> 
					<th> 순위 </th> 
				</tr>`
	}) 
				
	
	
	document.querySelector('.salseTable').innerHTML = sales
}




function group(){
let gplist = [  ]

	// 1. 제품 중복 제거 
	orderList.forEach( ( o,i) => {
		o.items.forEach( ( o2, i2 ) => {
			if( !gplist.includes(  o2.name ) ){
				gplist.push(  o2.name  );
			}
		})
	}) 
	console.log( gplist )
	
	// 2. 제품 수량 체크
	gplist.forEach( ( g ) => {
		let count = 0;
		orderList.forEach( ( o,i) => {
			o.items.forEach( ( o2, i2 ) => {
				if( g == o2.name ){ count++; }
			})
		}) 
		console.log( 'g : ' + count )
	})
	
}

















			