getBoard();
function getBoard(){
	let bno = document.querySelector('.bno').innerHTML ;
	
		$.ajax({
			url: "/jspWeb/board/info", 		
			method: "get", 
			data: {"type":2, "bno":bno},
			success: (r)=>{
				console.log('통신');
				console.log(r);
				
				let html = '';
				
				html = `${r.bdate} / ${r.bview} / 
				<button onclick="bIncrease(2)" type="button">${r.likes}</button>
				 /
				 <button onclick="bIncrease(3)" type="button">${r.hates}</button>`;
				
				document.querySelector('.infobox').innerHTML = html;
				
				document.querySelector('.pimgbox').innerHTML = r.mid;
				
				document.querySelector('.btitle').innerHTML = r.btitle;
				
				document.querySelector('.bcontent').innerHTML = r.bcontent;
				
				if(r.bfile == null){
					document.querySelector('.bfile').innerHTML = '첨부파일없음';
				}else {
					html = ` ${r.bfile} <button type="button" onclick="bdownload( '${r.bfile}' )"> 다운로드 </button>`;
					document.querySelector('.bfile').innerHTML = html
				} // else e
				
				if(memberInfo.mid == r.mid){
					html =`
						<button type="button" onclick="bdelete(${r.bno} , ${r.cno_fk})" > 삭제 </button>
						<button type="button" onclick="bupdate(${r.bno})" > 수정 </button>`;
					document.querySelector('.btnbox').innerHTML = html;
				}
				
			}//success e
		}) // ajax e
}// getBoard e

function bdownload(bfile){
	console.log(bfile)
	/*
	$.ajax({
		url:"/jspWeb/filedownLoad",
		method:"get",
		data:{"bfile":bfile},
		success: (r)=>{
			console.log(r);
		}
	})
	*/
	location.href="/jspWeb/filedownLoad?bfile="+bfile;
}


//3. 조회수 좋아요수 싫어요수
bIncrease(1); // 현재 jsp/js열리는 순간 증가
function bIncrease(type){
	//현재 게시물 번호
	let bno = document.querySelector('.bno').innerHTML;
	console.log("bno : " + bno);
	
	$.ajax({
		url : "/jspWeb/board/view",
		method: "get",
		data: {"type": type, "bno":bno},
		success: (r)=>{
			console.log('a');
			console.log(r);
			getBoard();
		}
	})
	
}// bincrease e

//게시물 삭제 버튼
function bdelete( bno, cno ){
	console.log(cno)
	$.ajax({
		url: "/jspWeb/board/info",
		method:"delete",
		data:{"bno":1, "type":type},
		success:(r)=>{
			console.log(r)
			if(r=='true'){
				alert('삭제 성공');
				location.href="/jspWeb/board/list.jsp?cno="+cno;
			}else{
				alert('삭제 실패')
			}
		}//success e
	})//ajax e
}//bdelete e

//수정
function bupdate(bno){
	location.href="/jspWeb/board/update.jsp?bno="+bno;
}




/* 
	전송방법
		html :   1.<form
		js	 :   1.location.href=""
		jquery:  1.$.ajax({})
		servlet: 1. response.sendRedirect('경로');
				 2. response.getWriter.print('데이터');
*/




