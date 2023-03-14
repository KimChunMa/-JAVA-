function regist(){
	let  signupForm = document.querySelectorAll('.signupForm')[0]
	console.log(signupForm);
	let formDate = new FormData(signupForm);
	console.log(formDate);
	
	$.ajax({
		url:"/jspWeb/Company",
		method:"post",
		data:formDate,
		contentType : false ,			
		processData : false ,	
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
			}else{ alert('회원가입실패') }
		}
	})
}