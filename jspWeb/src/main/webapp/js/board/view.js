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
				
				html = `${r.bdate} / ${r.bview} / ${r.likes} / ${r.hates}`;
				document.querySelector('.infobox').innerHTML = html;
				
				document.querySelector('.pimgbox').innerHTML = r.mid;
				
				document.querySelector('.btitle').innerHTML = r.btitle;
				
				document.querySelector('.bcontent').innerHTML = r.bcontent;
				
				if(r.bfile == null){
					document.querySelector('.bfile').innerHTML = '첨부파일없음';
				}else {
					html = ` ${r.bfile} <button type="button" onclick="bdownload( '${r.bfile}' )"> 다운로드 </button>`;
					document.querySelector('.bfile').innerHTML = html
				}
			}
		})
}

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


/* 
	전송방법
		html :   1.<form
		js	 :   1.location.href=""
		jquery:  1.$.ajax({})
		servlet: 1. response.sendRedirect('경로');
				 2. response.getWriter.print('데이터');
*/




