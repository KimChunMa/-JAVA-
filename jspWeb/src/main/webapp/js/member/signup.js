

function signup(){
	//첨부파일 있을 때
		console.log( 'signup 함수 열림');

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
				location.href="/jspweb/index.jsp"; // 해당 페이지 이동 
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

