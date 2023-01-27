let productList = [
	  { title: '신원 SS&FW 독점 균일 특가! 가디건/니트/원피스/팬츠外' , size: '[ 55, 66 ]' ,
	  price:141400 , sale: 14140, discount: 0.9, img:'신원.jpg',
	  like: 54, review:412},
	  { title: '[본사]LAP 설맞이 신상 BEST 니트/가디건/원피스 단독가!' , size: '[ FF, S, 55, 66 ]' ,
	  price:79000 , sale: 19000, discount: 0.75, img:'본사.jpg',
	  like: 54, review:412},
	  { title: '[SOUP/비지트인뉴욕] 본사 최종 시즌오프 BIG SALE! 가디건/니트/원피스/코트' , size: '[ FFF ]' ,
	  price:10000 , sale: 9900, discount: 0.1, img:'비지트인뉴옥.jpg',
	  like: 54, review:412},
	  { title: '[샐리]겨울 시즌OFF 코트/자켓/점퍼/니트 BEST 아이템 모음' , size: '[ FREE ]' ,
	  price:10000 , sale: 9900, discount: 0.1, img:'샐리.jpg',
	  like: 54, review:412},
	  { title: '[조이너스/NNF 외] 여성의류 F/W 역대급 초특가세일! 3900원부터~' , size: '[ 55, 66, 77, 88 ,99 ]' ,
	  price:10000 , sale: 9900, discount: 0.1, img:'조이너스.jpg',
	  like: 54, review:412},
	  { title: '[쉬즈미스/르오트 외] 겨울신상+BEST 아우터/이너' , size: '[ FREE ]' ,
	  price:10000 , sale: 9800, discount: 0.1, img:'쉬즈미스.jpg',
	  like: 54, review:412}
	]


product_print()
function product_print(){
	let html ='';
	
	productList.forEach((o,i)=>{
		html +=  `
				<div class="item">			<!-- 제품 1개 -->
				<img src="img/${o.img}">			<!-- 제품 이미지 -->
				<div class="item_info">				<!-- 제품정보 구역 -->
					<div class="item_title">${o.title}</div>	<!-- 제품명 -->
					<div class="item_size">${o.size}</div>	<!-- 제품사이즈 -->
					<div class="item_price">${o.price.toLocaleString()}원</div>	<!-- 제품가격 -->
					
					<div> 
						<span class="item_sale">${ (o.price- parseInt(o.price*o.discount)).toLocaleString()}원</span>	<!-- 판매가 -->
						<span class="item_discount">${parseInt(o.discount * 100)}%</span>	<!-- 할인률 -->
					</div>
				</div>
				
					<div class="item_bottom">	<!-- 제품정보 하단 구역 -->
						<div> 
							<span class="badge text-bg-danger">주문폭주</span>		<!-- 배지 -->
							<span class="badge text-bg-primary">1+1</span>
						</div>
						<div class="item_review"> ${o.like} ${o.review}</div>	
					</div>
			</div>`
	})
	
	
	document.querySelector('.itembox').innerHTML = html
}