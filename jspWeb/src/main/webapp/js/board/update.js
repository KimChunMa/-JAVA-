	if(memberInfo.mid == null ){
		alert('로그인하세요');
		location.href ="/jspWeb/member/login.jsp";
	}
	
	document.querySelector('.mid').innerHTML = memberInfo.mid;
	document.querySelector('.memail').value = memberInfo.memail;
	document.querySelector('.mimg').src=`/jspWeb/member/pimg/${memberInfo.mimg == null ? 'default.webp' : memberInfo.mimg}`;
	
function setUpdate(){
	
	let updateForm = document.querySelectorAll('.updateform')[0];
	
	let updateFormData = new FormData(updateForm);
	
	let defaultimg = document.querySelector('.defaultimg').checked
	updateFormData.set( "defaultimg" , defaultimg );
	
	$.ajax({
		url:"/jspWeb/member",
		method:"put",
		data:updateFormData,
		contentType : false ,	
		processData : false ,	
		success:(r)=>{
			console.log('통신')
			if(r=='true'){
				alert('수정완료');
				location.href="/jspWeb/member/logout.jsp"}
			else{
				alert('수정실패 : 비밀번호 오류!');
			}
		}
	})
	//첨부파일 없을때
	/*
	let info = {
			'mpwd' : document.querySelector('.mpwd').value,
			'newmpwd' : document.querySelector('.newmpwd').value,
			'memail' : document.querySelector('.memail').value,
	}
	console.log(info)
	
	$.ajax({
		url: "/jspWeb/member",
		method:"put",
		data: info,
		success:(r)=>{
			console.log('결과')
		}
	})
	*/
}