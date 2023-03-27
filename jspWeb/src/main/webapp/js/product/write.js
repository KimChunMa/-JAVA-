//0.좌표
let plat=0;
let plng = 0;

//1. 제품등록
function onwrite(){
	
	//1. 폼 객체
	let writeForm = document.querySelectorAll('.writeForm')[0];
	//2. 폼 데이터 객체 선언
	let writeFormData = new FormData(writeForm);
	//3. 좌표[위도/경도]
		//set 중복불가능
	writeFormData.set("plat", plat);	
	writeFormData.set("plng", plng);
	console.log(writeFormData)
	
	if(plat == 0 || plng == 0){alert('위치를 등록해주세요'); return;}
	
	if(fileList.length < 1){
		alert('하나이상의 이미지를 등록해주세요');
		return;
	}
	
	//폼에 드래그된 파일들을 등록
		//중복가능
	fileList.forEach( (f)=>{ 
		writeFormData.append("fileList",f)
	})
	
	$.ajax({
		url : "/jspWeb/product/info",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData : false,
		success : (r) =>{
			console.log(r);
			
			if(r == 'true'){
				alert('상품등록 성공');
				location.href="/jspWeb/index.jsp"
			}else{
				alert('상품등록 실패')
			}
		}
		
	})
}



// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 지도생성 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.31756000352892 , 126.8332584339037), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 지도를 클릭한 위치에 표출할 마커ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);


//-------------------------- 지도클릭 이벤트 ------------
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
	    
    /*
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    */
   
   plat = latlng.getLat();
   plng = latlng.getLng();
   console.log("위도 : "+  latlng.getLat())
   console.log("위도 : "+   latlng.getLng())
   
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});


// -------------------------- 드래그앤 드랍 구현 -------------
// 1. 드래그앤드랍할 구역 [DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');

let fileList = []; 

// 2. 해당구역에 이벤트 등록
	// 1. dragenter
fileDrop.addEventListener("dragenter", (r) =>{
	console.log('드래그 요소가 해당 구역에닿았을떄')
	e.preventDefault(); // 고유 이벤트 제거
})

	//2. 
fileDrop.addEventListener('dragover', (e)=>{
	console.log('드래그 요소가 해당 구역에 위치했을떄');
	e.preventDefault(); // 고유 이벤트 제거
})

	//3. 
fileDrop.addEventListener('dragleave', (e)=>{
	console.log('드래그 요소가 해당 구역에 나갔을때');
	e.preventDefault(); // 고유 이벤트 제거
})

	//4. 
fileDrop.addEventListener('drop', (e)=>{
	console.log('드래그 요소가 해당 구역에 드랍 되었을때');
	//문제 : 브라우저에 드랍했을떄 해당 페이지 열림
	e.preventDefault(); // 고유 이벤트 제거
	//1. 드랍된 파일을 호출 
	let files = e.dataTransfer.files
	console.log(files);
	
	for(let i = 0 ; i < files.length ; i++){
		console.log(files[i])
		if(f != null && f != undefined){
			//비어있지않고 정의되어 있으면
			fileList.push(files[i]);
		}
	}//for e
	console.log(fileList)
})




