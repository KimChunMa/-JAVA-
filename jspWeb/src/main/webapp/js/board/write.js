
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
				alert('성공');
		
			}else{ alert('실패') }
		}
	})
}