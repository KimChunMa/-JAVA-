let markers = []; //좌표저장


// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 지도 생성 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.301398462198165,  126.863770374015), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 



//--------------------마커 이미지 변경------------
var imageSrc = '/jspWeb/img/약국.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(50, 45), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.54699, 127.09598); // 마커가 표시될 위치입니다



//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 약국  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
$.ajax({
	url:"https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=100&serviceKey=HqoBwy3a3VRhBsc0fT%2BkjaNrwQ9HPYpeU9wCigtIbh3OumQK7O0%2BXzFZPkEDrrBHJClqrCfv0x8oDUorou%2F9jg%3D%3D",
	method:"get",
	success: (r)=>{
		console.log(r)
		console.log(r.data)
		
		//------------------------- 주소로 좌표 변환 후 마커 -----------
		r.data.forEach((o,i)=>{
			
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(`${o.주소}`, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
					
					//좌표
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					markers.push(coords)
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords,
			            image: markerImage, // 마커이미지 설정 
			            clickable: true
			        });
			        
			        
			        
			        //---------------- 마커 클릭 이벤트 ----------
			        var iwContent = `<div style="padding:5px;">${o.약국명}</div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
				
					// 인포윈도우를 생성합니다
					var infowindow = new kakao.maps.InfoWindow({
					    content : iwContent,
					    removable : iwRemoveable
					});
					
					// 마커에 클릭이벤트를 등록합니다
					kakao.maps.event.addListener(marker, 'click', function() {
					      // 마커 위에 인포윈도우를 표시합니다
					      infowindow.open(map, marker);  
					});
							 
							 clusterer.addMarker(marker);
			 		
			 		
			 		
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        /*
			        var infowindow = new kakao.maps.InfoWindow({
			            content: `<div style="width:150px;text-align:center;padding:6px 0;">${o.약국명}</div>`
			        });
			        infowindow.open(map, marker);
					
					
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			        */
				   
				   
				   
			    }//if e 
			});// addressSearch e 
		})//forEach e
	
		
		
	}//success e
})// $.ajax e

//---------------------- 클러스터러 ------------------
  // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 5 // 클러스터 할 최소 지도 레벨 
        
    });









