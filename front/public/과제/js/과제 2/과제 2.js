let 단 = Number(prompt("단을 입력하세용"))
let 곱 = Number(prompt("곱을 입력하세용"))



function On(){
let tbl = '<tr> <th> 단 </th> <th> 곱 </th> <th> 결과 </th> </tr>';

	for(let i = 1 ; i <= 곱 ;i++ )
	{//+1행 만들기
		tbl += '<tr>' //행먼저
		
		tbl+='<td>'+단+'</td>' 
		
		tbl+='<td>'+i+'</td>'
		
		tbl+='<td>'+단*곱+'</td>'
	
		tbl += '</tr>'
	}//+1행 만들기 끝
	
	
document.querySelector("#table").innerHTML = tbl;

}
