function regist(){
	let  signupForm = document.querySelectorAll('.signupForm')[0]
	console.log(signupForm);
	let formDate = new FormData(signupForm);
	console.log(formDate);
	
	$.ajax({
		url:"/jspWeb/Company",
		method:"post",
		data:formDate,
		contentType : false ,			
		processData : false ,	
		success: (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('회원가입성공');
			}else{ alert('회원가입실패') }
		}
	})
}
print();
function print(){
	
	$.ajax({
		url : "/jspWeb/Company" ,
		method : "get" ,
		success : (r) =>{console.log('ajax확인')
		console.log(r)
			let html = 
						`<tr>
							<th> 사원번호 </th>
							<th> 사원사진 </th>
							<th> 사원명 </th>
							<th> 직급 </th>
							<th> 고용형태 </th>
							<th> 부서 </th>
							<th> 입사일 </th>
							<th> 퇴사일 </th>
							<th> 퇴사사유 </th>
							<th> 비고 </th>
						</tr>`;
			r.forEach((o , i ) => {
				//<img src="/jspweb/Ex/Member/pimg/${o.mimg == null ? 'X.jpg' : o.mimg}" width="20%">
				html += 
						`<tr>
							<td> ${o.wno}</td>
							<td><img src="/jspWeb/practice/과제1/img/${o.picture == null ? '' : o.picture}" width="20%"></td>
							<td> ${o.name}</td>
							<td> ${o.grade}</td>
							<td> ${o.worker}</td>
							<td> ${o.department}</td>
							<td> ${o.joinDate}</td>
							<td> ${o.retire}</td>
							<td> ${o.reason}</td>
							<td> <button type="button" onclick="upDate()">수정</button><button type="button" onclick="del()">삭제</button></td>
						</tr>`;
			})
			document.querySelector('.print').innerHTML = html;
			}
	});	
}