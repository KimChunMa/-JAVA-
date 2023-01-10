let 학생리스트 = [];

/*alert("고냥실행됩니다")*/

function onAdd(){
	//input 값 가져와서 넣기
	학생리스트.push(  document.querySelector('.sname').value )
	
	document.querySelector('#slist').innerHTML = '<li>'+학생리스트+'</li>'
	//문서에 넣기
}


/* 삭제 */
function Ondelete() {
	/* 인풋 텍스트 값 가져오기*/
	let dname = document.querySelector('.sname').value
	
	/*인풋 텍스트 값 찾기*/
	학생리스트.splice( 학생리스트.indexOf( dname ) , 1 );
	
	// [ 출력부 ]
	// 1. <ul> 가져와서  [ DOM 객체 ]
	// 2. <ul> innerHTML 이용한 <ul> {여기에 데이터 넣기} </ul>
	document.querySelector('#slist').innerHTML = '<li>'+학생리스트+'</li>'
	
}
