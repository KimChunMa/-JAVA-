
  $(document).ready(function() {
        $('#summernote').summernote(
			{height:500}
		);
    });
    

console.log(memberInfo.mno);
if(memberInfo.mno==0){
	
	alert('회원제 기능입니다. 로그인후 작성해주세요');
	location.href="/jspWeb/member/login.jsp"
}

function bwrite(){
	
	//1. 폼 문자열로 가져오기
	let writeForm = document.querySelector('.writeForm')
	console.log(writeForm)
	
	//2. 폼 객체로 가져오기
	let  writeFormAll = document.querySelectorAll('.writeForm')
	console.log(writeFormAll);
	
	//3. 폼 객체 ---> FormData 클래스
	let writeFormDate = new FormData(writeFormAll[0]);
	console.log(writeFormDate);
	
	//4
	$.ajax({
		url:"/jspWeb/board/info",
		method:"post",
		data:writeFormDate,
		contentType : false ,			
		processData : false ,	
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('글쓰기 성공');
				location.href="/jspWeb/board/list.jsp?cno="+document.querySelector('cno').value;
			}else{ alert('글쓰기 실패') }
		}
	})
}