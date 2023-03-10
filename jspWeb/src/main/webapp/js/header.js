//로그인 성공한 회원 정보 호출

getLogin();
function getLogin(){
	
	$.ajax({
		url :"/jspWeb/Login",
		method : "get" ,
		success:(r)=>{
			console.log('성공');
			console.log(r);
			
			//html 구성
			
			let  html = '';
			
			if(r == null ){
				html+= `<a href="/jspWeb/member/signup.jsp">회원가입</a> `
				html+= `<a href="/jspWeb/member/login.jsp">로그인</a> `
			}else{
				html += `<div class="dropdown">
							  <button class="hpimghtn" type="button" data-bs-toggle="dropdown" >
							    <img class="hpimg" src="/jspWeb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" >
							  </button>
							  <ul class="dropdown-menu">
							    <li><a class="dropdown-item" href="#"> 내프로필 </a></li>
							    <li><a class="dropdown-item" href="#"> 친구목록 </a></li>
							    <li><a class="dropdown-item" href="/jspWeb/member/Logout.jsp"> 로그아웃 </a></li>
							  </ul>
						</div>  <!-- 드롭다운 e -->
							${r.mid}님 
							<a href="#">쪽찌함</a>
							<a href="#">포인트</a>`
				
				if(r.mid == 'admin'){
					html += `<a href="/jspWeb/admin/info.jsp">관리자 페이지</a> `
				}
			}
			console.log(html)
			document.querySelector('.submenu').innerHTML = html;
		}
	})
}