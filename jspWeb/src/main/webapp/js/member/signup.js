function signup(){
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
		document.querySelector('.idcheckconfirm').innerHTML = '사용가능한 아이디';
	
		$.ajax({
			url:"/jspWeb/mconfirm",
			methond:"get",
			data:{"mid":mid},
			success : (r)=>{
				console.log(r);
				if(r == 'true'){
					document.querySelector('.idcheckconfirm').innerHTML = '사용중인 아이디';
				}else{
					document.querySelector('.idcheckconfirm').innerHTML = '사용가능한 아이디';
				}
			}
		})
	
	}else{
		document.querySelector('.idcheckconfirm').innerHTML = '영소문자+숫자 조합 5~30사이로 입력해주세요';
	}
}



/*
	js 정규표현식 : 문자 특정 규칙 ,패턴, 집합표현할때 사용되는 언어
	문법
	/^ : 정규표현 시작
	&/ : 정규 표현 끝
	[a-z] : 소문자 a-z 집합
	[A-Z] : 대문자
	[0-9]
	[가-힣]
	{최소길이, 최대길이}
	
	[a-zA-Z]
	[a-zA-Z0-9가-힣]:영문+숫자+한글
	
	패턴검사 함수
	정규표현식.test(데이터) :정확하면 true or false
	/^[a-z]$/.test(qwe) --> true
	/^[a-z]$/.test(QWE) --> false
*/ 

