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
			
//------------------------- 사이드바 제품 목록 ---------------------
  	productList = r;	// 제품목록 결과를 전역변수 담아주기 
	produclistprint(  );
//------------------------ 마커 작업 -------------------------
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        //마커의 추가 코드를 작성하기위해 변수화
        let markers = r.map((p)=> { console.log(p)
            let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(p.plat, p.plng)
            });
            
//-------------------------- 클릭 이벤트 ----------------------
            // 지도에 클릭 이벤트를 등록합니다
			// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
			kakao.maps.event.addListener(marker, 'click', function() {
		       let html = `<button onclick="produclistprint()"> <== </button> <h3>제품상세페이지</h3>`;
		      html += `<div> 
					<div> ${ p.pname } </div>
					<div> ${ p.pcomment }  </div>
					<div> ${ p.pprice }  </div>
					<div> ${ p.pstate }  </div>
					<div> ${ p.pview }  </div>
					<div> ${ p.pdate }  </div>
					<div> <button type="button" onclick="setplike(${p.pno})"> ♡ </button> </div>
				</div>`
			document.querySelector('.productlistbox').innerHTML = html;
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
    productList.forEach( (p) => {
		html += `<div> 
					<span> ${ p.pname } </span>
					<span> ${ p.pcomment }  </span>
					<span> ${ p.pprice }  </span>
					<span> ${ p.pstate }  </span>
					<span> ${ p.pview }  </span>
					<span> ${ p.pdate }  </span>
				</div>`
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


function setplike(pno){
	if(memberInfo.mid == null){
		alert('회원기능입니다. 로그인후 사용해주세요'); return;
	}
	
	$.ajax({
		url:"/jspWeb/product/like?pno="+pno,
		method : "get",
		data: {"pno":pno },
		success : (r) => {console.log(r);}
	})
	
	$.ajax({
		url:"/jspWeb/product/like",
		method : "post",
		data: {"pno":pno },
		success : (r) => {console.log(r);
			if(r=='true'){
				alert('찜하기')
			}else{
				alert('삭제');
			}
		}
	})
	
	
	/*
	vs
	1)
	$.get ("/jspWeb/product/like?pno="+pno, () => {} )
	$.ajax({
		url:"/jspWeb/product/like?pno="+pno,
		method : "get",
		data: {"pno":pno },
		success : (r) => {console.log(r);}
	})
	
	2)
	$.get ("/jspWeb/product/like, {"data":data}, () => {} )
	
	$.ajax({
		url:"/jspWeb/product/like,
		method : "get",
		data: {"data":data },
		success : (r) => {console.log(r);}
	})
	
	3)
		$.post("/jspWeb/product/like")	
		$.ajax({
		url:"/jspWeb/product/like",
		method : "post",
		data: {"data":data },
		success : (r) => {console.log(r);}
	})
	
	*/
}

