let boardArray =[];

function submit(){
let name = document.querySelector('.name').value;
let content = document.querySelector('.content').value;
let pw = document.querySelector('.pw').value

//입력된 정보 객체에 저장
let border= {write : name , content : content , pw :pw}
	
	//하나의 배열형태로 저장
	boardArray.push(border);
	write();
}


function del(i){ //메세지로 동일한 비밀번호 배열을 삭제
	let pw = prompt('게시물 비밀번호 입력:')
		if( boardArray[i].pw == pw ){
		boardArray.splice([i],1);
		alert('삭제되었습니다');	
		}else{alert('잘못된 패스워드 입니다.')}
	
	write();
}

function modify(i){ //메세지로 동일한 비밀번호 객체를통해 수정
	let pw = prompt('게시물 비밀번호 입력:')
		if( boardArray[i].pw == pw ){
			let content =  prompt('새로운내용을 입력하세요 입력:')
			boardArray[i].content = content
			alert('수정되었습니다.');	
		}else{alert('잘못된 패스워드 입니다.')}
	
	write();
}

function write(){ // 배열에 저장된 객체를 복붙
	//버튼을 누를떄마다 초기화
	let html = `<tr> <th>번호</th> <th>내용</th> <th>작성자</th> <th>비고</th></tr>`

	for(let i=0; i<boardArray.length ; i++ ){
		html += `<tr> 
					<td>${i+1}</td>
					<td>${boardArray[i].content} </td>
					<td>${boardArray[i].write} </td>
					<td><button onclick="del(${i})">삭제</button>
						<button onclick="modify(${i})">수정</button>
					</td>
				</tr>`;
	}
	document.querySelector('.게시물테이블').innerHTML = html; 
}
