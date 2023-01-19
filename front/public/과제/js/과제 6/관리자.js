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
	category_select(index);
	burgarList();
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
					<td>${burgerList[idx].price.toLocaleString()}원</td>
					
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
	burgarList();
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
function sales(){ //주문시 시동
	let sales = `<tr> 
					<th> 제품 번호 </th> 
					<th> 버거이름 </th> 
					<th> 판매수량 </th> 
					<th> 매출액 </th> 
					<th> 순위 </th> 
				</tr>`
				

	// 1. 제품 중복 제거 
	let nameList = [  ]
	orderList.forEach( ( o) => { //주문리스트
		o.items.forEach( ( o2 ) => {//주문내 상품리스트
			if( !nameList.includes(  o2.name ) ){ //중복이 없다면
				nameList.push(  o2.name );} //이름푸쉬
		})
	}) 
	
	
	// 2. 제품 수량 체크
	let gpList =[];
	nameList.forEach( ( name ) => { //이름리스트
	  let count = 0;
		orderList.forEach( ( order ) => { //주문리스트
			order.items.forEach( (item ) => { //주문내 상품 리스트
				if( name == item.name )
				{ count++; } //이름리스트와 주문내 상품리스트가 있다면 카운트업
			})
		}) 
	 let sells ={ name:name , count:parseInt(count)};
	 gpList.push(sells)
	})
	
	//매출액
	let price =0;
	gpList.forEach((obj,idx)=>{
		burgerList.forEach((bobj)=>{
			if(obj.name == bobj.name)
			{obj.price = bobj.price; obj.money = obj.price*obj.count;}
		})
	})
	
		//순위
	
		gpList.forEach((obj,idx)=>{
			let rank=1;
			gpList.forEach((obj2)=>{
				console.log(obj.money)
				console.log('ㅡㅡㅡㅡㅡㅡ비교')
				console.log(obj2.money)
				
				if(obj.money < obj2.money){
					rank++; console.log('랭크는'); console.log(rank)
				}
			})
			obj.rank=rank;	
		})	
	
	
	gpList.forEach((obj,idx)=>{
		sales +=`<tr>
					<td> ${idx+1}</td>	
					<td> ${obj.name}</td>
					<td> ${obj.count}</td>
					<td> ${(obj.money).toLocaleString()}원</td>
					<td> ${obj.rank}</td>
				</tr>`
	})
	document.querySelector('.salseTable').innerHTML = sales
}

















			