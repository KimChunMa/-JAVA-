let 단 = Number(prompt("단을 입력하세용")) //메세지로 입력하기
let 곱 = Number(prompt("곱을 입력하세용")) //메세지로 입력하기

function On(){

//텍스트로 입력할때
let dan =  Number(document.querySelector('#dan').value)
let multiply = Number(document.querySelector('#multiply').value) 

if(dan && multiply)
{
 단 = dan;
 곱 = multiply;
}


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
