function join(){
	
	if(document.joinform.custno.value == ""){
		alert('회원번호을 입력해주세요')
		document.joinform.custno.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.custname.value == ""){
		alert('회원성명을 입력해주세요')
		document.joinform.custname.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.phone.value == ""){
		alert('전화번호을 입력해주세요')
		document.joinform.phone.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.address.value == ""){
		alert('주소를 입력해주세요')
		document.joinform.address.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.joindate.value == ""){
		alert('가입일자를 입력해주세요')
		document.joinform.joindate.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.grade.value == ""){
		alert('등급을 입력해주세요')
		document.joinform.grade.focus(); // 커서 이동
		return false;
	}
	
	if(document.joinform.city.value == ""){
		alert('도시코드를 입력해주세요')
		document.joinform.city.focus(); // 커서 이동
		return false;
	}
	
	//폼 전송
	document.joinform.submit();
	alert('회원 등록이 완료되었습니다.');
}