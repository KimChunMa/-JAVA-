/*방명록 배열*/
let contentArrays = []; 


/*버튼 기능 */
function addContent(){
	
	/*방명록 배열 넣기 */
	contentArrays.push(document.querySelector('#box').value);

	print_table()
}

function onDelete( dNum ){ 
	contentArrays.splice(dNum,1)
		print_table()
}
	
	
function print_table(){ 
	
	let table = ' <table> <tr> <th> 번호 </th> <th> 방문록 </th> <th> 비고 </th> </tr>'	

	/*방명록 배열 길이까지 행 늘리기 */
	for(let i = 0 ; i < contentArrays.length ; i ++)
	{
		table += '<tr>'
			table += `<td>${i+1}</td>`
			table += `<td>${contentArrays[i]}</td>`
			table += `<td><button onclick="onDelete( ${i} )">삭제</button></td>`
		table += '</tr>'
	}
	
	/*방명록 테이블 끝*/
	table += '</table>'

	/*덮어쓰기*/
	document.querySelector('#write').innerHTML = table;
	}