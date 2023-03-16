
getBoardList(1);
function getBoardList( page ){
		$.ajax({
			url: "/jspWeb/board/info", 		
			method: "get", // 첨부파일은 무조건 post/put
			data:{"type":1, "page":page},
			success: (r)=>{
				console.log(r)
				
				
				
				
				//--------------------------페이징 출력-------------------------
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
						   
				r.boardList.forEach((o)=>{
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
				//--------------------------- 페이징 버튼 출력 ---------------
				//이전
				html = '';
				html +=  page <= 1 ?
				`` 
				:
				`<button onclick="getBoardList(${page-1})" type="button" > 이전 </button>`
				
				//페이징 번호버튼 들
				for(let i = r.startbtn ; i <= r.endbtn ; i++){ // 1부터 마지막 페이지 수
					html += `<button onclick="getBoardList(${i})" type="button"> ${i} </button>`;
				}
				
				//이후
				html += page >= r.totalpage ? 
				``
				:
				`<button onclick="getBoardList(${page+1})" type="button"> 이후 </button>`; 
				
				document.querySelector('.pagebox').innerHTML = html;
			}//success end
		})//ajax end
}




/* 
	HTTP 이용한 PK 이동
	
	<a href="/jspWeb/board/view.jsp?변수명=데이터">
*/