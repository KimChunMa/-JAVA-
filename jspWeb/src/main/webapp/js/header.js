

let memberInfo = null;
//로그인 성공한 회원 정보 호출
getLogin();
function getLogin(){
	
	$.ajax({
		url :"/jspWeb/Login",
		method : "get" ,
		async: false, // 동기화 ajax함수가 끝날때까지 다른곳에서 사용 x
		success:(r)=>{
			
			memberInfo=r;
			console.log(r);
			
			//html 구성
			
			let  html = '';
			
			if(r.mid == null ){
				html+= `<a href="/jspWeb/member/signup.jsp">회원가입</a> `
				html+= `<a href="/jspWeb/member/login.jsp">로그인</a> `
			}else{
				html += `<div class="dropdown">
							  <button class="hpimghtn" type="button" data-bs-toggle="dropdown" >
							    <img class="hpimg" src="/jspWeb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" >
							  </button>
							  <ul class="dropdown-menu">
							    <li><a class="dropdown-item" href="/jspWeb/member/info.jsp"> 내프로필 </a></li>
							    <li><a class="dropdown-item" href="#"> 친구목록 </a></li>
							    <li><a class="dropdown-item" href="/jspWeb/member/logout.jsp"> 로그아웃 </a></li>
							  </ul>
						</div>  <!-- 드롭다운 e -->
							${r.mid}님 
							<a href="#">쪽찌함</a>
							<a href="#">포인트</a>`
				
				if(r.mid == 'admin'){
					html += `<a href="/jspWeb/admin/info.jsp">관리자 페이지</a> `
				}
			}
			
			document.querySelector('.submenu').innerHTML = html;
		}
	})
}

let 알림용소켓 = null;
if(memberInfo.mid == null){
	
}else{
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	// 1. JS : 클라이언트소켓 생성
	알림용소켓 = new WebSocket('ws://localhost:8080/jspWeb/alarm/'+memberInfo.mid)
	// 2. 클라이언트 소켓 이벤트 메소드 정의
	알림용소켓.onopen = (e) => {console.log('알림용 서버소켓 들어옴')}
	알림용소켓.onclose = (e) => {console.log('알림용 서버 소켓에 나감')}
	알림용소켓.onerror = (e) => {console.log('알림용 서버 소켓 오류')}
	알림용소켓.onmessage = (e) => {onalarm(e)}
}

function onalarm( e ){
	let msgbox = document.querySelector('.msgbox')
	msgbox.style.bottom = "50px";
	
	// 4초 후에 자동 내려가기
	// n초 후에 이벤트 실행 setItimenout
	
	//n초 마다 이벤트 실행setInterval
	
	setTimeout( ()=>{msgbox.style.bottom = "-100px"} , 4000 ) 
	
	//여러명이 채팅요청하면 DAO 메소드 충돌 발생
		//Dao 메소드에 synchronized 키워드 사용
		//스레드1 해당 메소드를 사용하고 있을때 [return 전] 다른 스레드 2 해당 메소드에 대기상태
		//멀티 스레드 : HttpServlet
	getcontent(); //채팅 받았을때 채팅방내 채팅내용 렌더링	
}




