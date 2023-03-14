	console.log(memberInfo);
	console.log(memberInfo.mpoint);
	if(memberInfo.mid == null ){
		alert('로그인하세요');
		location.href ="/jspWeb/member/login.jsp";
	}
	
	
	
	document.querySelector('.mid').innerHTML = memberInfo.mid;
	document.querySelector('.memail').innerHTML = memberInfo.memail;
	
		console.log(memberInfo.mpoint);

	document.querySelector('.mimg').src=`/jspWeb/member/pimg/${memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg}`;
		console.log(memberInfo.mpoint);
	document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;
	
	//2.회원탈퇴
	function setDelete(){
		console.log(document.querySelector('.mpwd').value)
		$.ajax({
			url:"/jspWeb/member",
			method:"delete",
			data : {"mpwd": document.querySelector('.mpwd').value},
			success:(r)=>{
				console.log('통신');
				console.log(r);
				
				if(r == 'true'){
					alert('탈퇴 성공');
					location.href="/jspWeb/member/logout.jsp";
					
				}else{
					alert('회원탈퇴 실패 [관리자 문의바람]');
				}
			}
		})
	}

	