let 단 = Number(prompt("단을 입력해주세요"))
let 곱 = Number(prompt("곱을 입력해주세요"))


function On(){
let table = '<table> <tr> <th>단</th> <th>곱</th> <th>결과</th></tr>';


let dan= document.querySelector('#dan').value;
let mutiply= document.querySelector('#mutiply').value;

if (dan && mutiply){
	단 = dan;
	곱 = mutiply;
}
	
	for(let i = 1;i <= 곱 ;i++)
	{
		table += '<tr>'
		
		table += '<td>'+단+'</td>'
		
		table += '<td>'+i+'</td>'
		
		table += '<td>'+단*곱+'</td>'
			
		table += '</tr>'
	}
	
	table += '</table>'
	
	document.querySelector('#Tbox').innerHTML = table;
}