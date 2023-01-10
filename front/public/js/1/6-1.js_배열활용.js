let 학생리스트 = [];

/*alert("고냥실행됩니다")*/

function onAdd(){
	/*alert("클릭했습니다")*/
	
	//받기
	학생리스트.push(document.querySelector('.sname').value)
	//.클래스 , #아이디
	/*alert(sname.value);*/
	
	//넣기
	let slist =  document.querySelector('#slist')
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'

}

/* 삭제 */
function Ondelete() {
	let dname = document.querySelector('#slist').value 
	// input 값 넣기
	
	학생리스트.splice(학생리스트.indexOf(dname),1);
	//input값 인덱스 찾기
	
	let slist =  document.querySelector('#slist')
	//html 리스트 아이디 
	
	slist.innerHTML = '<li>' + 학생리스트 + '</li>'
	//리스트 다시 출력
}
