/* 

	소켓: 두 프로그램간의 양방향 통신 종착점 [도착지]
	서버소켓 :	[JAVA]서버가 가지고 있는 소켓
	클라이언트 소켓:	[js] 클라이언트가 가지고 있는 소켓 [각 클라이언트 마다]
	
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
		3.
	JAVA serverSocket 
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스위에 @ServerEndpoint("/서버소켓경로URL")
			@ServerEndpoint : WS의 URL 만들기
			@WebServlet : HTTP의 URL 만들기  
			
*/

								//소켓 클래스와 경로 같이
let 클라이언트소켓 = new WebSocket('ws:///jspWeb/chatting');
console.log(클라이언트소켓)

클라이언트소켓.onopen = function(e) {onopen(e);}
function onopen(e){alert('서버소켓에 들어갔다.');}

function send(){
	alert('전송완료!')
	
	let msgbox = document.querySelector('.msgbox').value
	
	//채팅창 보낼시 초기화
	document.querySelector('.msgbox').value=''
		
}



