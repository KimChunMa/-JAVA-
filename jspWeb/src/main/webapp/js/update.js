console.log('업뎃')
console.log(memberInfo);

let bno = document.querySelector('.bno').value;
console.log("bno : "+bno)

getBoard()
function getBoard(){
	$.ajax({
		url:"/jspWeb/board/info",
		method:"get",
		data:{"type":2, "bno":bno},
		success: (r) =>{
			console.log(r);
			console.log(r.bfile)
			document.querySelector('.btitle').value = r.btitle;
			document.querySelector('.bcontent').value = r.bcontent;
			
			
			let cnoSelect = document.querySelector('.cno');
				console.log( cnoSelect ); // select 
				console.log( cnoSelect.options[0] );// select 안에 있는 첫번째 option
			for( let i = 0 ; i<cnoSelect.options.length ; i++  ){
				// i는 0 부터 옵션<option>태그 개수만큼 반복 
				if( cnoSelect.options[i].value == r.cno_fk ){
					// i번째 옵션<option>태그의 값과 현재 게시물의 카테고리번호와 일치하면
					cnoSelect.options[i].selected = true;
				}
			}
			
			let html = '';
			if(r.bfile == null){//없을때
				html += `첨부파일 없음`;
			}else{ // 있을때 
				html += `
				<div>
			기존 첨부파일 : <span class="oldfile"></span>
			<button type="button" onclick="bfiledelete()">삭제</button>
			 </div>
			 
			 `
			document.querySelector('.bfilebox').innerHTML = html;
			}
			html += `<div>
			변경할 첨부파일 : <input type="file" name="bfile" class="bfile">
			</div>`
			document.querySelector('.oldfile').innerHTML = r.bfile;
			
		}
	})
}


function bupdate(){
	let updateForm = document.querySelectorAll('.updateForm')[0];
	// 1. form 안에 있는 데이터 객체화 했다.
	let updateFormData = new FormData( updateForm );
		// 2. form 밖에 있거나 js에 있는 추가 데이터는 formData.set 추가
		// formdata객체명.set( '변수명' , 데이터 );
		updateFormData.set( 'bno' , bno ); // 수정할 대상
		
		console.log(updateFormData);
		
	$.ajax({
			url : "/jspWeb/board/info",
			method : "put" ,
			data : updateFormData , 
			contentType : false , 	
			processData : false , 
			success : (r)=>{
				console.log(r);
				if(r=='true'){
				alert('수정완료')}
				else{
					alert('수정실패')
				}
			}
		})
	location.href="/jspWeb/board/list.jsp?cno="+
	document.querySelector('.cno').value;
}


//3첨부파일만 삭제
function bfiledelete(){
	alert('첨부파일 삭제')
	
	$.ajax({
		url:"/jspWeb/board/info",
		method:"delete",
		data:{"type":2},//1 게시판 삭제 2 첨부파일 삭제
		success:(r)=>{
			if(r=='true'){
				alert('파일삭제')}
				else{
					alert('파일삭제 실패')
				}
		}
	})
	
}