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
	클라이언트소켓 = new WebSocket('ws://192.168.17.148:8080/jspWeb/chatting/'+memberInfo.mid);
	console.log(클라이언트소켓);
}

// 클라이언트소켓 객체에 정의한 함수 대입
//연동성공했을 때
클라이언트소켓.onopen = function(e) {서버소켓연결(e);}  
클라이언트소켓.onmessage = function(e) {메세지받기(e);}
클라이언트소켓.onclose = function(e){연결해제(e)}




//2. 클라이언트 소켓이 접속했을때 이벤트/함수 정의
//접속했을때 하고싶은 js함수 정의
function 서버소켓연결(e){
	자료보내기(memberInfo.mid+"님 이 채팅방에 접속하셨습니다.",'alarm')
} 





//3. 클라이언트소켓이 서버에게 메세지 보내기 [@OnMessage] 
//(1. 보내기 버튼 누를떄 2. 입력창에서 엔터) type="msg""
function send(){
	let msgbox = document.querySelector('.msgbox').value
	
	//메세지전송
		//json형식의 문자열 타입 만들어서 문자열로 타입으로 전송
		// JSON.parse(JSON형식의 문자열 타입) : String --> json변환
		// JSON.stringify(JSON형식의 문자열 타입) : json변환 --> String
	let msg = {
		type: 'msg',
		msgbox : msgbox
	}
	
	클라이언트소켓.send(JSON.stringify(msg)) // @onMessage
	
	//채팅창 보낼시 초기화
	document.querySelector('.msgbox').value=''
}


//4-2 type에 따른 HTML 구별
function 메시지타입구분(msg){
	let json = JSON.parse(msg);
	let html = '';
	if(json.type == 'msg'){
		html += `<div class="content"> ${json.msgbox}  </div>`
	}else if(json.type=='emo'){
		html += `<div class="content emocontent"><img src="/jspWeb/img/imoji/emo${json.msgbox}.gif" width="50px"></div>`
	}
	return html;
}


//4. 서버로부터 메세지가 왔을떄 메세지 받기
function 메세지받기(e){ // <--- e <--- getBasicRemote()
	console.log(e);
	console.log(e.data);
	console.log(JSON.parse(e.data)); // 문자열 json -> 객체json 형변환
	
	let data= JSON.parse(e.data);
	
	//명단 [여러개 = list/Array] vs 메세지 정보 [1개=dto/obj]
		// Array 타입 확인 : array.isArray(객체) :해당 객체가 배열/리스트면 true
	if( Array.isArray(data) ){
		let html = '';
		console.log(data)
		data.forEach((o)=>{
			html += `
					<div class="connetbox">		<!-- 접속 명단 1명 기준 -->
						<div> <img src="/jspWeb/member/pimg/${ o.frommimg==null ? 'default.webp' : o.frommimg  }" class="hpimg"> </div>
						<div class="name"> ${o.frommid} </div> 
					</div>
					`;
		})
		console.log('a')
		console.log(html)
		document.querySelector('.connectlistbox').innerHTML = html;
	
	}
	
	else if( JSON.parse(data.msg).type=='alarm'){
			contentbox.innerHTML += 
				`<div class="alarm"> 
					<span> ${JSON.parse(data.msg).msgbox }</span>
				</div>`
	}
	//보낸사람 == 현재유저 일치시
	else if(data.frommid == memberInfo.mid){
		contentbox.innerHTML += `
								<div class="secontent">
									<div class="date"> ${data.time} </div>
									<div class="content"> ${메시지타입구분(data.msg)}  </div>
								</div>`;
	}else{//받은 사람
				contentbox.innerHTML += `<div class="tocontent">
									<div><img src="/jspWeb/member/pimg/${ data.frommimg==null ? 'default.webp' : data.frommimg  }" class="hpimg"></div>
									<div class="rcontent">
										<div class="name"> ${ data.frommid } </div>
										<div class="contentdate">
											<div class="content">  ${메시지타입구분(data.msg)} </div>
											<div class="date"> ${ data.time } </div>
										</div>
									</div>
								</div>`
	}
	let top = contentbox.scrolltop; // 현재 스크롤상단위치 좌표
	let height = contentbox.scrollHeight; //현재 스크롤 높이 [기본값 contentbox ]
	
	//상단위치를 바닥으로 
	contentbox.scrollTop = contentbox.scrollHeight; 
	
}


//5. 서버와 연결이 끊겼을때 . [클라이언소켓 객체가 초기화될때 -> F5, 페이지전환할때 ]
function 연결해제(e){
	//세션종료후 발생함으로 알릴수없음
	//자료보내기(memberInfo.mid+"님 이 채팅방에 나가셨습니다.",'alarm')
}

//6 엔터키
function enterkey(){
	// 입력한 키코드가 13[엔터면] 메세지 전송
	if(window.event.keyCode == 13){
		send();
	}
}

//7 이모티콘 출력
getemo();
function getemo(){
	let html = '';
	for(let i = 1 ; i<=43 ; i++){
		html += `<img onclick="자료보내기(${i},'emo')" src="/jspWeb/img/imoji/emo${i}.gif" width="50px">`
	}
	document.querySelector('.enolist').innerHTML = html;
}

//자료 보내기
function 자료보내기(msgbox, type){
	let msg = {
		type: type,
		msgbox : msgbox
	}
	클라이언트소켓.send(JSON.stringify(msg));
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
