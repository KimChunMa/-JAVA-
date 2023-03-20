// pageObject : 현재페이지, 검색, 전송타입 보관된 객체
let pageObject ={
	page : 1 ,
	key : "",
	keyword:"",
	type:1,
	cno:document.querySelector('.cno').value, //카테고리
	listsize : 3
}

let cnameHTML ='';
if(pageObject.cno ==1){cnameHTML='공지사항'}
if(pageObject.cno ==2){cnameHTML='커뮤니티'}
if(pageObject.cno ==3){cnameHTML='QnA'}
if(pageObject.cno ==4){cnameHTML='노하우'}
document.querySelector('.cname').innerHTML = cnameHTML;


getBoardList(1);
function getBoardList( page ){
		pageObject.page = page; // 인수로 받은 현재페이지를 객체에 대입
		
		$.ajax({
			url: "/jspWeb/board/info", 		
			method: "get", // 첨부파일은 무조건 post/put
			data:pageObject,
			success: (r)=>{
				console.log(r)
				console.log(r.boardList)
				//--------------------------페이징 출력-------------------------
				let html = ``;
			
			r.boardList.forEach( ( o , i ) => {
				html += `
						<div class="boardcontent">
							<div>
								<img alt="" class="hpimg" 
								src="/jspWeb/member/pimg/
								${o.mimg == null ? 'default.webp' : o.mimg}
								">
								
								<span class="mid"> ${o.mid} </span>
								<span class="bdate"> ${o.bdate} </span>
							</div>
							<div class="btitle"> 
								<a href="/jspWeb/board/view.jsp?bno=${o.bno}">${o.btitle}</a> 
							</div>
							<div class="cbottom">
								<span> <i class="far fa-eye"></i> <span class="bview">${o.bview}</span> </span>
								<span> <i class="far fa-thumbs-up"></i> <span class="bup">${o.likes}</span> </span>
								<span> <i class="far fa-thumbs-down"></i> <span class="bdown">${o.hates}</span> </span>
								<span> <i class="far fa-comment-dots"></i> <span class="rcount">${o.rcount} </span> </span>
							</div>
						</div>`;
			})
			document.querySelector('.boardTable').innerHTML = html;
			//-------------------------------------------
			
				//--------------------------- 페이징 버튼 출력 ---------------
				//이전
				html = '';
				html +=  page <= 1 ?
				`` 
				:
				`<button onclick="getBoardList(${page-1})" type="button" class="pagebtns" > 이전 </button>`
				
				//페이징 번호버튼 들
				for(let i = r.startbtn ; i <= r.endbtn ; i++){ // 1부터 마지막 페이지 수
					html += `<button onclick="getBoardList(${i})" class="pagebtns"  type="button"> ${i} </button>`;
				}
				
				//이후
				html += page >= r.totalpage ? 
				``
				:
				`<button onclick="getBoardList(${page+1})" type="button" class="pagebtns"> 이후 </button>`; 
				
				document.querySelector('.pagebox').innerHTML = html;
				// -------------------- 게시물 수 출력 ----------------
				document.querySelector('.seachcount').innerHTML = `게시물 수 : ${r.totalsize}`;
			
			
			}//success end
		})//ajax end
}

//검색 기능
function getsearch(){
	console.log(pageObject)
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	
	getBoardList(1);
}

//전체보기
function allPrint(){
	pageObject.key = '';
	pageObject.keyword = '';
	getBoardList(1);
}


function setlistsize(){
	
	//1. select에서 선택된 값 가져오기
	let listsize =  document.querySelector('.listsize').value;
	console.log('listsize '+listsize);
	
	pageObject.listsize = listsize;
	
	
	getBoardList(1);
	
}


/* 
	HTTP 이용한 PK 이동
	
	<a href="/jspWeb/board/view.jsp?변수명=데이터">
*/