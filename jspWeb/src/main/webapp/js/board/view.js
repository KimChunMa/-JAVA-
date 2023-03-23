
if(memberInfo.mid == null){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = '로그인후 작성가능';
	document.querySelector('.rwritebtn').disabled = true;
}

	document.querySelector('.rcontent').disabled = false;

//현재 보고있는 게시물 번호
let bno = document.querySelector('.bno').value ;
console.log('view bno : '+ bno)
//해당 게시물 호출
getBoard();
function getBoard(){
	
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
				
				document.querySelector('.mimg').src =`/jspWeb/member/pimg/${r.mimg == null ? `default.webp` : r.mimg}`;
				console.log(r.mimg)
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.bview').innerHTML = r.bview;
				document.querySelector('.bup').innerHTML = r.likes;
				document.querySelector('.bdown').innerHTML = r.hates;
				document.querySelector('.bdate').innerHTML = r.bdate;
				document.querySelector('.bdate').innerHTML = r.bdate;
				
				document.querySelector('.infobox').innerHTML = html;
				
				document.querySelector('.pimgbox').innerHTML = r.mid;
				
				document.querySelector('.btitle').innerHTML = r.btitle;
				
				document.querySelector('.bcontent').innerHTML = r.bcontent;
				
				if(r.bfile == null){
				}else {
					html = ` ${r.bfile} <button type="button" onclick="bdownload( '${r.bfile}' )"> 다운로드 </button>`;
					document.querySelector('.bfile').innerHTML = html
				} // else e
				
				if(memberInfo.mid == r.mid){
					html =`
						<button type="button" class="bbtn" onclick="bdelete(${r.bno} , ${r.cno_fk})" > 삭제 </button>
						<button type="button" class="bbtn" onclick="bupdate(${r.bno})" > 수정 </button>`;
					document.querySelector('.btnbox').innerHTML = html;
				}
				
			}//success e
		}) // ajax e
}// getBoard e

//2. 파일 다운로드
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
	bno = document.querySelector('.bno').innerHTML;
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

//6. 댓글 쓰기
function rwrite(){
	$.ajax({
		url:"/jspWeb/board/reply",
		method:"post",
		data:{"bno":bno, "rcontent":document.querySelector('.rcontent').value
			 ,"type":1},
		success: (r)=>{
			console.log(r)
			if(r=="true"){
				alert('댓글작성완료');
				getReplayList();
				document.querySelector('.rcontent').value='';
				
				location.reload(); //전체페이지 새로고침 				
			}else{
				alert('실패')
			}
		}
	})
}

//7. 상위 댓글 출력
getReplayList()
function getReplayList(){
	$.ajax({
		url:"/jspWeb/board/reply",
		method:"get",
		data:{"bno":bno , "type":1},
		success: (r)=>{
			console.log(r)
			
			let html = '';
			
			r.forEach((o,i) =>{
				
					html += `
							<div>
								<span> ${o.ming} </span>
								<span> ${o.mid} </span>
								<span> ${o.rdate} </span>
								<span> ${o.rcontent} </span>
								<button type="button" onclick="rereplyview(${o.rno})">
								 답글 쓰기</button>
								  
								<div class="rereplybox${o.rno}"></div>
							</div>`;
			 
				
			})
			
			document.querySelector('.replylistbox').innerHTML = html;
		}
	})
}

//하위 댓글 구역 표시
function rereplyview(rno){
	
	
		
	$.ajax({
		url:"/jspWeb/board/reply",
		async:'false',	//동기화 통신
		method:"get",
		data:{"type":2, "rindex":rno, "bno":bno},
		success: (r)=>{
			console.log(r);
			
		
			let html = '';
			r.forEach((o)=>{
				html += `
						<div>
							<span> ${o.ming} </span>
							<span> ${o.mid} </span>
							<span> ${o.rdate} </span>
							<span> ${o.rcontent} </span>
							
						</div>`
			})//foreach
			 html += `
						<textarea class="rrcontent${rno}"> </textarea>
						<button type="button" onclick="rrwirte(${rno})"> 대댓글 작성</button>
						`;
			
			console.log(html)
			document.querySelector(`.rereplybox${rno}`).innerHTML = html;
		}//success
	})//$.ajax
	
	
}

//대댓글 쓰기
function rrwirte(rno){
	//bno , mno. rrcontent, rindex(상위댓글번호)
	
	$.ajax({
		url:"/jspWeb/board/reply",
		method:"post",
		data:{"type":2, "bno":bno , "rindex":rno , 
			  "rcontent":document.querySelector(`.rrcontent${rno}`).value},
		success: (r)=>{
			console.log(r)
			getReplayList()
			alert('대댓글 작성완료')
			location.reload(); 
		}
	})

}





/* 
	전송방법
		html :   1.<form
		js	 :   1.location.href=""
		jquery:  1.$.ajax({})
		servlet: 1. response.sendRedirect('경로');
				 2. response.getWriter.print('데이터');
*/




