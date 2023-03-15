	$.ajax({
		url: "/jspWeb/board/info", 		
		method: "get", // 첨부파일은 무조건 post/put
		data:{"type":1},
		success: (r)=>{
			console.log(r)
			let html =`<tr>
							<th> 게시물 번호</th>
							<th>	제목</th>
							<th> 작성자</th>
							<th> 작성일 </th>
							<th> 조회수 </th>
							<th> 좋아요 </th>
							<th> 싫어요</th>
							<th> 카테고리</th>
					   </tr>`;
					   
			r.forEach((o)=>{
				html += `<tr>
							<td> ${o.bno}</td>
							<td><a href="/jspWeb/board/view.jsp?bno=${o.bno}">${o.btitle}</a></td>
							<td> ${o.mid}</td>
							<td> ${o.bdate}</td>
							<td> ${o.bview}</td>
							<td> ${o.likes}</td>
							<td> ${o.hates}</td>
							<td> ${o.cno_fk}</td>
					   </tr>`;
			})
			document.querySelector('.table').innerHTML=html;
		}
})


/* 
	HTTP 이용한 PK 이동
	
	<a href="/jspWeb/board/view.jsp?변수명=데이터">
*/