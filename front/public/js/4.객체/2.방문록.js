let boardArray =[];

function write(){
	console.log('함수실행')
	console.log('입력됨');
	let name = document.querySelector('.name').value;
	console.log(name);
	let content = document.querySelector('.content').value;
	console.log(content);

	let border= {write : name , content : content}
	console.log(border)
	
	boardArray.push(board);
	
	let html = `<tr> <th>번호</th> <th>내용</th> <th>작성자</th> </tr>`

	for(let i=0; i<boardArray.length ; i++ ){
		html += `<tr> 
					<td>${i+1}</td>
					<td>${boardArray[i].content} </td>
					<td>${boardArray[i].write} </td>
				</tr>`;
	}
	
	document.querySelector('.게시물테이블').innerHTML = html; 
}

