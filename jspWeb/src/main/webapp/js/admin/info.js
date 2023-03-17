let pageObject = {
	page:1,
	listsize:2,
	key:"",
	searchtext:""
}

console.log( 'js열림')

getMemberList(1);
function getMemberList(page){
	
	pageObject.page = page;
	console.log(page)
	
	$.ajax({
		url: "/jspWeb/member",
		method : "get",
		data : pageObject ,
		success : (r)=>{
			console.log('ajax통신');
			console.log( r );	// 응답 결과 데이터 확인 
			// 1. 응답데이터 처리 
				// 1. 테이블 헤더 구성 
			let html = `<tr>
							<th width="150px"> 번호 </th>
							<th width="150px"> 프로필 </th>
							<th width="150px"> 아이디 </th>
							<th width="150px"> 이메일주소 </th>
 						</tr>`
			r.memberList.forEach( (o) =>{
				// 2. 테이블 내용물 추가 구성 
					// 만약에 회원 mimg 프로필이미지가 null 이면 기본프로필 사용 / 아니면 mimg 사용 
				html +=	`<tr>
							<td> ${ o.mno } </td>
							<td> <img src="/jspWeb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }" width="100%">  </td>
							<td> ${ o.mid } </td>
							<td> ${ o.memail } </td>
						</tr>`
			} ); // for end 
				// 3. 구성된html를 table 대입 
			document.querySelector('.mListTable').innerHTML = html;
			// ----------------------------페이징 버튼-------------------
			//이전 버튼
			html = '';
			html += page <= 1 ? `` : `<button onclick="getMemberList(${page-1})" type="button">이전 </button>`
			
			//페이징 번호버튼 들
				for(let i = r.startbtn ; i <= r.endbtn ; i++){ // 1부터 마지막 페이지 수
					html += `<button onclick="getMemberList(${i})" type="button"> ${i} </button>`;
				}
			
			//이후
				html += page >= r.totalpage ? 
				``:`<button onclick="getMemberList(${page+1})" type="button"> 이후 </button>`; 
				
			document.querySelector('.pagebtn').innerHTML = html;
			document.querySelector('.mcount').innerHTML = r.totalsize +"명";

			
		}//success e
	})
}

function search_member(){
	pageObject.key = document.querySelector('.memberSelect2').value;
	pageObject.searchtext = document.querySelector('.searchtext').value;
	getMemberList(1)
}

function setlistsize(){
	//1. select에서 선택된 값 가져오기
	let listsize =  document.querySelector('.listsize').value;
	console.log('listsize '+listsize);
	
	pageObject.listsize = listsize;
	
	getMemberList(1)
}

function search_reset(){
	pageObject.key= ""
	pageObject.searchtext= ""
	
	getMemberList(1);
}





