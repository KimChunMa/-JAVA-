let contentArrays = [];


function addContent(){
	contentArrays.push(document.querySelector('#box').value);

let table = ' <table> <tr> <th> 번호 </th> <th> 방문록 </th> </tr>'	
	for(let i = 0 ; i < contentArrays.length ; i ++)
	{
		table += '<tr>'
			table += '<td>'+ (i+1) +'</td>'
			table += '<td>'+ contentArrays[i] +'</td>'
		
		table += '</tr>'
		
	}
	table += '</table>'

	document.querySelector('#write').innerHTML = table;

}