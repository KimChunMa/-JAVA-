//로그인
function login(){
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	$.ajax({
		url:"/jspWeb/Login",
		method:"post",
		data : {mid : mid , mpwd: mpwd},
		success:(r) => {
			console.log('통신')
			console.log(r);
			if(r=='true'){
				location.href="/jspWeb/index.jsp";
			}else{
				document.querySelector('.checkconfirm').innerHTML =  ('회원정보가 다릅니다.');
			}
			
		}
	})
}

//아이디 찾기 db수정
function findid(){
	let memail = document.querySelector('.memail').value;
	$.ajax({
		url:"/jspWeb/find",
		method:"get",
		// 1: 아이디 찾기 , 2: 비밀번호찾기
		data:{"type":1 , "memail": memail},
		success: (r) =>{
			console.log('통신');console.log(r);
			
			if( r == 'false'){
				document.querySelector('.checkconfirm').innerHTML = '동일한 회원정보가 없습니다.';
			}else{
				document.querySelector('.checkconfirm').innerHTML = '회원님의 아이디 : '+r;
			}
		}
	})
}

//비밀번호 찾기
function findpwd(){
	let info = {
		type : 2,
		"mid" : document.querySelector('.mid').value,
		"memail" : document.querySelector('.memail').value
	};
	
	$.ajax({
		url : "/jspWeb/find",
		method : "get",
		data:info,
		success:(r)=>{
			if(r == 'false'){
				document.querySelector('.checkconfirm').innerHTML = '동일한 회원정보가 없습니다.';
			}else{
				document.querySelector('.checkconfirm').innerHTML = '임시비밀번호를 이메일로 전송했습니다.'+r;
			}
		}
	})
}