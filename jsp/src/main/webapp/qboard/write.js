let 저장소 =[];

function quest_submit(){
	let quset = {
		write: document.querySelector('.q_write').value, 
		pw: document.querySelector('.q_pw').value, 
		title: document.querySelector('.q_title').value, 
		text: document.querySelector('.q_text').value, 
	}
	
	저장소.push(quset)
	
	let form = document.querySelector('.write_form');
	let form_data = new FormData(form); console.log(form_data)
	
	alert('글쓰기성공')
	
	//결과
	let result = false;
	if(result) {alert('글쓰기성공'); location.href=`list.html`;}
	else{alert('글쓰기실패')}
}