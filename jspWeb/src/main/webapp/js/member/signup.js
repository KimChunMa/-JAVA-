let checkconfirm = document.querySelectorAll('.checkconfirm')

function signup(){
	//유효성 검사 체크
	let count = 0 ; 
	
	for(let i = 0 ; i < checkconfirm.length ; i++ ){
		if(checkconfirm[i].innerHTML == 'O'){count++;}
	}
	
	if(count != 4){alert('회원가입을 다시 해주세요.'); return;}
	
	//첨부파일 있을 때

	// 1. [ 첨부파일 있을때 ] html 에 file input 직접적으로 조작 불가능 
		// document.querySelector(".mimg").value ,  -- 불가능 
		// 1. form 객체 가져오기 
	let signupForm = document.querySelectorAll('.signupForm')[0];	// 첫번째 form 가져오기 
		// 2. form 안에 있는 data 객체 호출  [ js api 클래스 = FormData ]
	let signupFormData = new FormData( signupForm );
		console.log( signupFormData )
	// 2. [ 첨부파일 있을때 ] ajax 
	$.ajax({
		url : "/jspWeb/member",				// 서블릿 주소 
		method : "post",					// 첨부파일은 무조건 post/put
		data : signupFormData , 			// FormData 객체 전송 
		// 첨부파일 있을때 추가되는 속성 
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
				location.href="/jspWeb/index.jsp"; // 해당 페이지 이동 
			}else{ alert('회원가입실패') }
		}
	})
	
	
	
	/* 첨부파일 없을때
	let info ={
		mid : document.querySelector(".mid").value,
		mpwd : document.querySelector(".mpwd").value,
		mpwdconfirm : document.querySelector(".mpwconfirm").value,
		memail : document.querySelector(".memail").value,
		mimg : document.querySelector(".mimg").value,
	}
	
	$.ajax({
		url:"/jspWeb/member",
		method: "post",
		data :info,
		success : (r)=>{
			console.log('응답');
			console.log(r);
			if(r == 'true'){alert('회원가입 성공!'); memberPrint()}
			else{alert('회원가입 실패!')}
		}
		
	})
	*/
}

function idcheck(){
	let mid = document.querySelector('.mid').value;
	console.log(mid)
	//정규표현식 [대소문자 + 숫자 5~30 글자 ]
	let midj = /^[a-z0-9]{5,30}$/
	console.log(midj.test(mid));
	
	if(midj.test(mid)){
		document.querySelector('.checkconfirm').innerHTML = 'O';
	
		$.ajax({
			url:"/jspWeb/mconfirm",
			methond:"get",
			data:{mid:mid},
			success : (r)=>{
				console.log(r);
				if(r == 'true'){
					checkconfirm[0].innerHTML = '사용중인 아이디!';
				}else{
					checkconfirm[0].innerHTML = 'O';
				}
			}
		})
	
	}else{
		checkconfirm[0].innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
}



/*
	js 정규표현식 : 문자 특정 규칙 ,패턴, 집합표현할때 사용되는 언어
	문법
	/^ : 정규표현 시작
	&/ : 정규 표현 끝
	[a-z] : 소문자 a-z 집합
	[A-Z] : 대문자
	[0-9] == \d 
	[가-힣]
	{최소길이, 최대길이}
	+ : 앞에 있는 패턴 1개 이상 반복
	? : 앞에 있는 패턴 0개 이상 혹은 
	* : 앞 에 있는 패턴 0개 반복
	
	\ : 이스케이프 문자
	
	[a-zA-Z]
	[a-zA-Z0-9가-힣]:영문+숫자+한글
	
	1개이상 문자가 포함되어야하는 경우
		(?=.*[패턴문자]) : 해당 패턴 문자 하나이상
	(?=.*[a-z]) : 소문자 하나이상
	(?=.*[A-Z]) : 대문자 하나이상
	(?=.*[0-9]) : 숫자 한개 이상
	(?=.*[!@#$%^&*]) : 해당하는 특수문자 하나이상
	
	패턴검사 함수
	정규표현식.test(데이터) :정확하면 true or false
	/^[a-z]$/.test(qwe) --> true
	/^[a-z]$/.test(QWE) --> false
*/ 


//비밀번호 유효성 검사
function pwdcheck(){
	let mpwd = document.querySelector('.mpwd').value;
	console.log(mpwd)
				// 2. 정규표현식 : 영대소문자+숫자 조합 5~20 글자 
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	console.log(mpwdj.test(mpwd))
	if(mpwdj.test(mpwd)){
		checkconfirm[1].innerHTML = 'O';
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20 글자';
	}
}

//비밀번호 확인
function pwdconfirmcheck(){
	
	let mpwd = document.querySelector('.mpwd').value;
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value ;
	console.log(mpwdconfirm)
	//표현식
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/
	
	//제어
	if(mpwdj.test(mpwd)){
		if(mpwd == mpwdconfirm){ //두 비밀번호가 같으면
			checkconfirm[2].innerHTML = 'O';
		}else{ // 다르면
			checkconfirm[2].innerHTML = '일치하지 않습니다.';
		}
	}
}

//이메일 확인
function emailcheck(){
	let memail = document.querySelector('.memail').value;
	 console.log("이메일 "+memail)
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	//[a-zA-Z0-9._-] : 영대소or숫자or_- 
	//+@ : 1개이상의 []뒤에 @ 
	//+\. : 뒤에 .
	//+ co.kr
	
	if(memailj.test(memail)){
		checkconfirm[3].innerHTML = '인증버튼을 눌러주세요';
		document.querySelector('.authbtn').disabled = false;
	}else{
		checkconfirm[3].innerHTML = 'X';
	}
}


//이메일 인증버튼
function getauth(){
	//----------------------------메일 전송 테스트 -------------
	// ajax가 java에게 이메일 전송후 인증코드 받기
	/*
	$.ajax({
		url: "/jspWeb/email",
		method : "post",
		data:{memail: document.querySelector('.memail').value},
		success : (r)=>{
			console.log('통신');
			console.log(r);
		}
	})*/
	
	
	//---------------------- 인증코드 타이머--------------------
	let html = `
				<div class="timebox"> 02 : 00 </div>
					<input onkeyup="emailcheck()" type="text" 
						   class="authinput" placeholder="인증코드">
					<button type="button" onclick="authconfirm()"
					class="authconfirmbtn" >확인</button>	
				`
	document.querySelector('.authbox').innerHTML = html;
	timer = 120; // 인증 시간 대입
	settimer(); // 타이머 함수
	auth = 1234; // 인증코드                      
}

//타이머 함수
let auth = 0;
let timer = 0; // 인증시간
let timerinter; // interval 함수
function settimer(){
	 timerinter = setInterval(()=>{
		let minutes = parseInt( timer / 60); // 분계산
		let second = parseInt(timer % 60); //분계산후 초
		
		minutes = minutes < 10 ? "0" + minutes : minutes;
		second = second < 10 ? "0" + second : second;
		
		let timerHTML = minutes + " : " + second;
		document.querySelector('.timebox').innerHTML = timerHTML;
		
		timer--;
		
		//만약 인증시간이 0보다 작으면
		if(timer < 0 ){
			clearInterval(timerinter);
			checkconfirm[3].innerHTML = '인증실패';
				document.querySelector('.authbox').innerHTML = '';
		}
		
	} , 1000)
}

function authconfirm(){
	console.log('함수실행')
	//1. 입력받은 입력코드 호출
	let authinput =  document.querySelector('.authinput').value;
	
	if(auth == authinput ){//인증코드 일치
		clearInterval(timerinter);
		
		document.querySelector('.authbtn').innerHTML= '완료';
		document.querySelector('.authbtn').disabled = true;
		checkconfirm[3].innerHTML = 'O';
		
	} else{ // 인증코드 불일치
		checkconfirm[3].innerHTML = '인증코드 불일치';
	}
}




//이미지 미리보기
function premimg(obj){ //e 해당 함수를 실행시킨 객체
	console.log('첨부파일 바뀜'+obj)
	console.log(obj.files[0]) //현재 이벤트를 실행한 input 파일명 
	console.log(document.querySelector('.mimg').files[0])//class의 파일명
	
	//js 파일클래스
	let file = new FileReader();  // 파일읽기 클래스
	console.log(file)
	
	file.readAsDataURL(obj.files[0]) //파일 읽어오기 file[0]:첨부파일 한개
	
	
	//읽어온 파일 꺼내기 (바이트단위)
	file.onload = (e) =>{
		console.log("가져온파일")
		console.log(e.target.result)
		document.querySelector('.premimg').src = e.target.result;
	}
}
