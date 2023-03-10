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
			
			let  html = '<a href="/jspWeb/index.jsp">홈 </a><br/>';
			
			if(r == null ){
				html+= `<a href="/jspWeb/member/signup.jsp">회원가입</a> `
				html+= `<a href="/jspWeb/member/login.jsp">로그인</a> `
			}else{
				if(r.mid == 'admin'){
					html += `<a href="/jspWeb/admin/info.jsp">관리자 페이지</a> `
				}
				html += `<img src="/jspWeb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg">`
				html+=`${r.mid}님 안녕하세요 `
				html+= `<a href="/jspWeb/member/logout.jsp">로그아웃</a> `
			}
			console.log(html)
			document.querySelector('.submenu').innerHTML = html;
		}
	})
}