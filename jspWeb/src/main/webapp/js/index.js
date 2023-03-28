let productList = null; //제품 총 목록

//---------------- 지도 생성 -------------------
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
	center : new kakao.maps.LatLng(37.31756000352892 , 126.8332584339037), // 지도의 중심좌표 
    level : 6 // 지도의 확대 레벨 
}); 
    
// ------------------- 클러스터러 -------------------------
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 4 // 클러스터 할 최소 지도 레벨 
    });
  
  // ----------------------- 마커 이미지 변경 ------------------------------------ //
var imageSrc = '/jspWeb/img/ezenlogo.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(10, 20)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다



// 2. 현재 지도의 좌표 얻기
get동서남북(); // 처음 드래그안하고 한번
function get동서남북(){
	// 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
	let 남 = swLatLng.getLat();
	let 서 = swLatLng.getLng();
	let 북 = neLatLng.getLat();
	let 동 = neLatLng.getLng();

	getproductlist(동, 서, 남, 북) // 제품목록호출
}
   
   // --------------------- 지도 중심좌표 이동 이벤트 --------------------
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', () => {get동서남북();});

//------------------ 제품목록 호출 [1. 현재 보고있는 지도 좌표내 포함된 제품만]
function getproductlist(동, 서, 남, 북){
	
	clusterer.clear(); //클러스터 비우기 (누적금지)
	$.ajax({
		url:"/jspWeb/product/info",
		method : "get",
		async:false,
		data: {"동": 동 , "서":서 , "남":남 , "북":북},
		success: (r)=>{
	console.log(r)		
//------------------------- 사이드바 제품 목록 ---------------------
  	productList = r;	// 제품목록 결과를 전역변수 담아주기 
	produclistprint(  );
//------------------------ 마커 작업 -------------------------
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        //마커의 추가 코드를 작성하기위해 변수화
        let markers = r.map((p,i)=> { console.log(p)
            let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng),
                image: markerImage
            });
            
//-------------------------- 클릭 이벤트 ----------------------
            // 지도에 클릭 이벤트를 등록합니다
			// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
			kakao.maps.event.addListener(marker, 'click', function() {
		      productprint( i )
		});
            return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
    	}//success e
	}) // ajax e

}//function e
   
    
//------------ 클릭시 제품정보 출력 함수 -------------------    
function produclistprint(  ){ 
    let html = '<h3>제품목록페이지</h3>';
    productList.forEach( (p, i) => {
		
		html+= `
			<div class="productbox" onclick="productprint( ${i} )">
				<div class="pimgbox">
					<img src="/jspWeb/product/pimg/${p.pimglist[0]}">
				</div>
				<div class="pcontentbox"> 
					<div class="pdate"> ${ p.pdate } </div>
					<div class="pname"> ${ p.pname } </div>
					<div class="pprice"> ${ p.pprice } </div>
					<div class="petc">  
						<i class="far fa-eye"></i>  ${ p.pview }
						<i class="far fa-thumbs-up"></i> 5 
						<i class="far fa-thumbs-down"></i> 2 
						<i class="far fa-comment-dots"></i> 4
					</div>
				</div>
			</div>
		`;
	});
	document.querySelector('.productlistbox').innerHTML = html;
}
  
 /* object로 넘어옴 (객체)
  function productlistprint(r){
	 	let html = '<h3> 제품 상세 페이지</h3>';
		r.forEach( (p)=> {
			html += ` <div>
						<span> ${p.pno} </span>
						<span> ${p.pname} </span>
						<span> ${p.pprice} </span>
						<span> ${p.psatus} </span>
						<span> ${p.pview} </span>
						<span> ${p.pdate} </span>
						<span> <button type="button"> 💖</button> </span>
					  </div>	
					`
		});
		document.querySelector('.productlistbox').innerHTML = html;
  }
*/
//제품 개별 조회
function productprint( i ){
	let p = productList[i];
	
	let imghtml = '';
	p.pimglist.forEach((img,i)=>{
		
		if(i==0){
			imghtml+=`
				<div class="carousel-item active">
				      <img src="/jspWeb/product/pimg/${img}" class="d-block w-100" alt="...">
				</div>`
		}else{
			imghtml +=`
				<div class="carousel-item">
				      <img src="/jspWeb/product/pimg/${img}" class="d-block w-100" alt="...">
				</div>`
		}
		
	})
	
				
	let html= `
			<div class="pviewbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspWeb/member/pimg/${p.mimg == null ? 'default.webp' : p.mimg}" class="hpimg">
						<span class="mid"> ${p.mid} </span>
					</div>
					
					<div>
						<button type="button" class="pbadge" onclick="produclistprint()">목록보기</button>
					</div>
				</div>
			
			
			<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
			  <div class="carousel-inner">
			   
			    ${imghtml}
			  
			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
				
			<!-- 제품 상세 내용물  -->
			<div class="pdate"> ${p.pdate} </div>
			<div class="pname">  ${p.pname} </div>
			<div class="pcomment"> ${p.pcomment} </div>
			<div > <span class="pbadge" > ${p.pstate == 1 ? "판매중" : p.pastate == 2 ? "거래중": "거래완료"} </span> </div>
			<div class="pprice">${ p.pprice } </div>
			<div class="petc">  
						<i class="far fa-eye"></i>  ${ p.pview } 
						<i class="far fa-thumbs-up"></i> 5 
						<i class="far fa-thumbs-down"></i> 2 
						<i class="far fa-comment-dots"></i> 4
			</div>
			
			<div class="pviewbtnbox">
				<button type="button" onclick="setplike(${p.pno})"> <span class="plikebtn"> <i class="far fa-heart"></i> </span> </button>
				<button type="button" onclick="chatprint(${i})"> 채팅 </button>
			</div>
			
			</div>`
			document.querySelector('.productlistbox').innerHTML = html;
			getplike(p.pno) //찜하기
}

//채팅페이지 이동
function chatprint(i){
	
	if(memberInfo.mid == null){
		alert('회원기능 입니다.'); return;
	}
	
	let p = productList[i];
	
	//채팅창 가져오기
	let chathtml = '';
	$.ajax({
		url:"/jspWeb/product/chat",
		method:"get",
		data: {"pno":p.pno, },
		async:false, //동기식
		success:(r)=>{
			console.log(r);
			
			r.forEach( (o)=>{
				if(o.frommno == memberInfo.mno){
					chathtml += `<div class="sendbox">${o.ncontent}</div>`
				}else{
					chathtml += `<div class="receivebox">${o.ncontent}</div>`
				}
			})
			
		}
	})
	
	
	
	let html = `
				<div class="chatbox">
				<div class="pviewinfo">
					<div class="mimgbox">
						<img src="/jspWeb/product/pimg/${p.pimglist[0]}" class="hpimg">
						<span class="pname"> ${p.pname} </span>
					</div>
					
					<div>
						<button type="button" class="pbadge" onclick="produclistprint()">목록보기</button>
					</div>
				</div>
				
				<div class="chatcontent">
					${ chathtml }
				</div>
				
				<div class="chatbtn">
					<textarea rows="" cols="" class="ncontentinput"></textarea>
					<button type="button" onclick="sendchat(${p.pno}, ${p.mno})"> 전송 </button>
				</div>
				
			</div>	<!-- chatbox -->
			`
	document.querySelector('.productlistbox').innerHTML = html;
}

//채팅 보내기
function sendchat (pno, tomno){
	let ncontent = document.querySelector('.ncontentinput').value;
	$.ajax({
		url:"/jspWeb/product/chat",
		method:"post",
		data: {"pno":pno, "ncontent":ncontent, "tomno":tomno},
		success:(r)=>{
			console.log(r)
			if(r == "true"){
				document.querySelector('.ncontentinput').value = '';
				
			}
		}
		
	})	
}




//찜하기
function setplike(pno){
	if(memberInfo.mid == null){
		alert('회원기능입니다. 로그인후 사용해주세요'); return;
	}
	

	$.ajax({
		url:"/jspWeb/product/like",
		method : "post",
		data: {"pno":pno },
		success : (r) => {console.log(r);
			if(r=='true'){
				alert('찜하기');
				document.querySelector('.plikebtn').innerHTML = `<i class="fas fa-heart"></i>`;
			}else{
				alert('삭제');
				document.querySelector('.plikebtn').innerHTML = `<i class="far fa-heart"></i>`;
			}
		}
	})
	
	// vs
	// $.get( "/jspweb/product/like?pno="+pno , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like?pno="+pno , success : (r)=>{ console.log(r); } })
	
	// $.get( "/jspweb/product/like , { "data" : data } , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like" , data : { "data" : data } , success : (r)=>{ console.log(r); } })
	
	// $.post( "/jspweb/product/like , { "data" : data } , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like", method : "post" , data : { "data" : data } , success : (r)=>{ console.log(r); } })

	 
        // $(r).map( (인덱스,반복객체명) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // r.map( (반복객체명,인덱스) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // vs 
        // .forEach( (반복객체명,인덱스) => { } ) 	실행문에서 return X
	 
	 
}

//4. 현재회원이 해당 제품의 찜하기 상태 호출
function getplike(pno){
	console.log(pno)
	
	if( memberInfo.mid == null ){return "☆";}
	
	$.ajax({
		url:"/jspWeb/product/like",
		method : "get",
		async: 'false',
		data: {"pno":pno },
		success : (r) => {
			console.log( r )
			if(r == "true"){ document.querySelector('.plikebtn').innerHTML = '<i class="far fa-heart"></i>'; }
			else{ document.querySelector('.plikebtn').innerHTML = `<i class="fas fa-heart"></i>`; }
		}
	})
}


