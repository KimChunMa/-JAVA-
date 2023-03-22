/* 

	소켓: 두 프로그램간의 양방향 통신 종착점 [도착지]
	서버소켓 :	[JAVA]서버가 가지고 있는 소켓
	클라이언트 소켓:	[js] 클라이언트가 가지고 있는 소켓 [각 클라이언트 마다]
	
	new WebSocket(서버소켓URL)			@ServerEndpoint("/서버소켓URL")
	1.클라이언트소켓.onopen()	<-- 연 결--> @OnOpen
	2.클라이언트소켓.send()		-- 보내기 --> @OnMessage
	3.클라이언트소켓.onmessage	<<--보내기   session.getBasicRemote().sendText(메세지);
	4.
	
	
	카카오톡 유저					카카오톡 본사/서버실
	클라이언트						서버
							
	유재석		안녕 --->		채팅방(유재석,강호동,신동엽) {서버소켓}
	(소켓)		<--- 안녕		제주도
	안산
	
	강호동		
	(소켓)		<--- 안녕
	수원
	
	신동엽		
	(소켓)		<--- 안녕
	서울

	JS WebSocket 	HTTP
		1. JS에서 제공하는 클래스 new WebSocket(ws://URL); 
		2. 소켓 객체 만들기		
			let 클라이언트소켓 = new WebSocket();
		3. 소켓이 서버소켓과 연동
			1. WebSocket 생성자에서 해당 서버소켓의 통신
			
			
	JAVA serverSocket 
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스위에 @ServerEndpoint("/서버소켓경로URL")
			@ServerEndpoint : WS의 URL 만들기
			@WebServlet : HTTP의 URL 만들기
			  
		3. 클라이언트 소켓이 서버소켓 [엔드포인트]으로  접속했을때
			@OnOpen : 클라이언트소켓이 접속했을때 매핑[연결]
			
*/


let contentbox = document.querySelector('.contentbox')
let 클라이언트소켓 = null;

if(memberInfo.mid == null){ //헤더 js
	alert('로그인 전용입니다.');
	location.href="/jspWeb/member/login.jsp";
}else{
	//1. 클라이언트소켓 생성				//소켓 클래스와 경로 같이
	클라이언트소켓 = new WebSocket('ws://localhost:8080/jspWeb/chatting/'+memberInfo.mid);
	console.log(클라이언트소켓);
}

// 클라이언트소켓 객체에 정의한 함수 대입
//연동성공했을 때
클라이언트소켓.onopen = function(e) {서버소켓연결(e);}  
클라이언트소켓.onmessage = function(e) {메세지받기(e);}
클라이언트소켓.onclose = function(e){연결해제(e)}




//2. 클라이언트 소켓이 접속했을때 이벤트/함수 정의
//접속했을때 하고싶은 js함수 정의
function 서버소켓연결(e){ contentbox.innerHTML += '<div> ----- 채팅방 입장 ----- </div>'} 





//3. 클라이언트소켓이 서버에게 메세지 보내기 [@OnMessage]
function send(){
	let msgbox = document.querySelector('.msgbox').value
	
	//메세지전송
	클라이언트소켓.send(msgbox) // @onMessage
	
	alert('전송완료!')
	//채팅창 보낼시 초기화
	document.querySelector('.msgbox').value=''
}

//4. 서버로부터 메세지가 왔을떄 메세지 받기
function 메세지받기(e){ // <--- e <--- getBasicRemote()
	console.log(e);
	console.log(e.data);
	console.log(JSON.parse(e.data)); // 문자열 json -> 객체json 형변환
	contentbox.innerHTML += `<div> ${e.data} </div>`
}


//5. 서버와 연결이 끊겼을때 . [클라이언소켓 객체가 초기화될때 -> F5, 페이지전환할때 ]
function 연결해제(e){
	console.log('연결해제')
}


/*
	클라이언트소켓 필드				서버소켓
	opopen			=	
	onclose			=
	onmessage		=
	
	통신결과
	onmessage = function(e){console.log('연결해제')}
	
	AJAX 필드
		success : function(r)=>{}
		success : (r) => {}
*/
