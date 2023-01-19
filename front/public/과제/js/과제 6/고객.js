/* 공용 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/
let categoryList = [ '프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거']

let burgerList = [{ name:'기네스콰트로치즈와퍼', price:9800 ,
					img:'img/프리미엄/기네스콰트로치즈와퍼.png',category:'프리미엄'},
					
					{name:'몬스터X', price: 9200,
					img:'img/프리미엄/몬스터X.png',category:'프리미엄'},
					
					{name:'통새우와퍼와퍼', price:6200,
					img:'img/프리미엄/통새우와퍼.png',category:'프리미엄'},
					
					{ name : '치킨킹팩1' , price : 13000 , 
					img : 'img/스페셜/치킨킹팩.png' , category : '스페셜' }]

let cartList = []; //장바구니
let orderList=[]; //주문리스트
/* ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

category_print() //선출력 카테고리
category_select(0) //프리미엄 카테고리 선출력
product_print(0); //프리미엄 버거 선출력

let tprice = 0; //총가격


function time2(){
	/*시간*/
	const date = new Date().toLocaleDateString('ko-kr');
	const time = new Date().toLocaleTimeString('ko-kr')
	const time2 = date + time
	return time2;}

/*공용 끝 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/


//카테고리 출력
function category_print(){ 
	let html = `<ul>`
	
	categoryList.forEach((obj,idx)=>{ //카테고리 배열 순회
		html += `<li onclick="category_select(${idx})"
				 class="categoryli">${obj}</li>`})
				 
	html +=`<ul>`
	document.querySelector('.categorybox').innerHTML = html}

//카테고리 클릭시 => 빨갛게 => 일치하는 카테고리 버거 출력
function category_select(i){ 
	let categoryli = document.querySelectorAll(".categoryli")
	
	for(let j = 0 ; j < categoryli.length ; j++){ //카테고리 리스트 순회
		if(j==i){
			categoryli[j].classList.add('categoryselect');
		}else{
			categoryli[j].classList.remove('categoryselect');
		}
	}
	
	//랜더링
	product_print(i)
}

//카테고리 출력시 => 제품 출력
function product_print( index ){
	let html ='';
	
	for(let i = 0 ; i < burgerList.length ; i++){
		if(burgerList[i].category == categoryList[index])
			//버거리스트는 순회, 카테고리 리스트는 클릭한 부분만적용
		
	 html += `<div class="product" onclick="pClick(${i})">
			  		<img src="${burgerList[i].img}" width="100%"/>
					<div class="productinfo">
						<div class="ptitle">${burgerList[i].name}</div>
						<div class="pprice">${burgerList[i].price.toLocaleString()}원 </div>
					</div>
			</div>`;
	}
	document.querySelector('.productbox').innerHTML = html
}

//제품 클릭시 => 카트로
function pClick(idx){
	 //카트 집어넣기
	cartList.push(burgerList[idx])
	cart_print();}
	
//주문취소
function cancel(){
	alert("주문을 취소합니다.")
	cartList.splice(0); cart_print();}
	//배열 전체 삭제, 재출력

//주문하기
function order(){
	alert("주문 합니다.")
		
	let no = 0; //주문번호
	if(orderList.length == 0 ) {no = 1;} //주문이 없다면 주문번호 1
	else{no = orderList [orderList.length-1].no+1} //마지막 인덱스 주문객체의 주문+1
	
	let order ={
				no : no ,
				items : cartList.map((obj)=> { return obj;}), 
				time :  time2(),
				state : true,
				complete :0,
				price : `${tprice}`}
				
	orderList.push(order)

	//주문후
	cartList.splice(0); tprice=0; cart_print(); 
	orderOut(); sales(); }

//장바구니 제품 및 개수 출력
function cart_print(){
	
	let html ='';
	let Num = 0;
	
	cartList.forEach((obj,idx)=>{
		html+= `<div class="item">
					<div class="ititle">
					${cartList[idx].name}</div>
					<div class="iprice">
					${cartList[idx].price.toLocaleString()}원</div>
				</div>`
		Num++
		
		tprice += parseInt(`${cartList[idx].price}`)
	})
	
	
	document.querySelector('.cartbottom').innerHTML = html;
	document.querySelector('.total').innerHTML = Num;
	document.querySelector('.tprice').innerHTML = tprice.toLocaleString() + '원';}