let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
]


			

border_print(null, null) //처음 페이지
function border_print( key, keyword){ //검색후 페이지	
	console.log(key); 	console.log(keyword); 	
	let html = `<thead>
				<tr>
					<th width="5%"> 번호 </th> <th width="45%" > 제목 </th> <th width="10%"> 작성자 </th> 
					<th width="10%"> 작성일 </th> <th width="10%"> 조회수 </th> <th width="10%">좋아요</th> <th width="10%">싫어요</th>
				</tr>
			</thead>`
				
	boardlist.forEach((obj,idx)=>{
		html += `<tbody> <tr> 
					  <td>${obj.no} </td>
					  <td><a href="view.html"  class="nav-link">${obj.title}</a> </td>
					  <td>${obj.writer} </td>
					  <td>${obj.date} </td>
					  <td>${obj.view} </td>
					  <td>${obj.up} </td>
					  <td>${obj.down} </td>
				</tr> </tbody>`
	})
	
	document.querySelector('#table').innerHTML = html
	}
	
document.querySelector('.searbtn').addEventListener('click', (e)=>{
	
	let keyword = document.querySelector('.keyword').value
	
	let key = document.querySelector('.key').value
	console.log(key); 	console.log(keyword) ;
	border_print(key, keyword)
	
})