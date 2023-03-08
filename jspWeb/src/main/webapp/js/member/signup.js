

function signup(){
	let info ={
		mid : document.querySelector(".mid").value,
		mpwd : document.querySelector(".mpwd").value,
		mpwdconfirm : document.querySelector(".mpwconfirm").value,
		memail : document.querySelector(".memail").value,
		mimg : document.querySelector(".mimg").value,
	}
	
	$.ajax({
		url:"/jspWeb/member",
		method: "post",
		data :info,
		success : (r)=>{
			console.log('응답');
			console.log(r);
			if(r == 'true'){alert('회원가입 성공!'); memberPrint()}
			else{alert('회원가입 실패!')}
		}
		
	})
	
}

//총 멤버 호출
memberPrint()
function memberPrint(){
	$.ajax({
		url:"/jspWeb/member",
		method: "get",
		success : (r)=>{
			let html = `<table border="1">
							<tr>
								<th>  번호 </th>
								<th>  아이디 </th>
								<th>  비밀번호 </th>
								<th>  이미지 </th>
								<th>  이메일 </th>
								<th>  비고 </th>
							</tr>` 
							
			r.forEach((o)=>{
				html += `<tr>
							<td> ${o.mno} </td>
							<td> ${o.mid} </td>
							<td> ${o.mpwd} </td>
							<td> ${o.mimg} </td>
							<td> ${o.memail} </td>
							<td>  </td>
						 </tr>`
			})
			html +=`</table>`
			
			document.querySelector('.memberList').innerHTML = html;
		}
		
	})
	
}