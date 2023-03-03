console.log('열림');

function Ex1(){
	
	let data = document.querySelector('.inputdata').value ;
	console.log(data);
	
	$.ajax({
		url: "http://192.168.17.34:8080/jspWeb/Ex1", //통신할 서블릿 주소
		method: "post", // http 메소드
		data : { "data" : data }, //데이터보내기
		success :function(result){ //데이터받기
			console.log(result)
		}  
	});
}

Ex2();
function Ex2(){
	$.ajax ({
		url : 'http://192.168.17.34:8080/jspWeb/Ex1',
		method:"get",
		//data : {},
		success : function(result){
			console.log( result );
			document.querySelector('.ex2box').innerHTML = result;
		}
	})
}
	
	//js --> 서글렛
	// 0. $ : jquery 표현식 [jqery 라이브러리]
	// 1. ajax 메소드 사용 : $.ajax() ;
	// 2. ajax 매개변수[속성:객체형태] : {} --> $.ajax({})
	// 3. 속성
		// 1. url : 통신할 경로 [서블릿(클래스) 주소]
		// 2. method : http 메소드 방식
		// 3. data : 통신할 떄 보낼 데이터
		// 4. success : 통신 성공
	/* 
		$.ajax ({ 
			url : 통신할 경로[서글릿 주소 : /프로젝트명/("/indextest")] , 
			
				url : "http://localhost:8080/jspWeb/indextest"
				url : "http:// 192.168.17.34/jspWeb/indextest"
				url : "/jspWeb/indextest"
				
			method : 메소드 방식 ,
				get
				post
			
			 
			data : { 매개변수명 , 데이터} ,
			
				jus객체형태 {매개변수명 : 데이터 , 매개변수명 : 데이터}
			 
			success : 통신후 응답 데이터 받기 
				
				1. success : function(){}
				2. success : function()=>{}
				
			})
	*/



