

function signup(){
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
		data :"info",
		success : (r)=>{
			console.log('응답');
			console.log(r);
			if(r == 'true'){alert('회원가입 성공!')}
			else{alert('회원가입 실패!')}
		}
		
	})
	
}