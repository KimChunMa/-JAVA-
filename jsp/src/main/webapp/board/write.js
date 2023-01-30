let 게시물임시저장소 = []


function board_write(){
	let board = { //1. 첨부파일 없을 때
		btitle:	document.querySelector('.btitle').value,
		bcontent: document.querySelector('.bcontent').value,
		bpwriter: document.querySelector('.bwriter').value,
		bpassword: document.querySelector('.bpassword').value
	};
	
	// 2. 첨부파일 있을 때
	//폼 전체를 가져옴
	let writeform = document.querySelector('.writeform');
	
	let formdata = new FormData(writeform); console.log(writeform)
		
		게시물임시저장소.push(board)
	//결과
	let result = false;
	if(result) {alert('글쓰기성공'); location.href=`list.html`;}
	else{alert('글쓰기실패')}
	
}

/*썸머 api
$(document).ready(function() {
  $('#summernote').summernote({height:300, lang: 'ko-KR'});
});
*/
