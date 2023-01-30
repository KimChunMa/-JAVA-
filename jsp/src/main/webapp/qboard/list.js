let question = [{no: 1 , title: '문의내용1', write: '유재석', day: '2023-01-30', view:'10' , status:false, completed:''},
				{no: 2 , title: '문의내용2', write: '홍길동', day: '2023-01-29', view:'20' , status:false, completed:''},
				{no: 3 , title: '문의내용3', write: '강호동', day: '2023-01-38', view:'30' , status:false, completed:''},
				{no: 4 , title: '문의내용4', write: '황길동', day: '2023-01-37', view:'40' , status:false, completed:''},
				{no: 5 , title: '문의내용5', write: '일이삼', day: '2023-01-36', view:'50' , status:false, completed:''}]
				

quest_table()
function quest_table(){
	let html =`<tr> 
					<th width="5%"> 번호 </th> <th width="10%"> 제목 </th> 
					<th width="5%"> 작성자 </th> <th width="10%"> 작성일 </th> 
					<th width="5%"> 조회수 </th> <th width="10%"> 문의상태[접수/완료] </th> 
					<th width="15%"> 처리일 </th> </tr>`
	question.forEach((obj)=>{
		html += `<tr> <td> ${obj.no}</td> 
					  <td> <a href="/jsp/board/view.html" class="nav-link">${obj.title}</a></td>
					  <td> ${obj.write}</td>
					  <td> ${obj.day}</td>
					  <td> ${obj.view}</td>`
					  
		if(obj.status == false){
			html += `<td> 문의접수</td>
					 <td> </td> </tr>`
		}			  			
	})
	document.querySelector('.quest_table').innerHTML = html
}				