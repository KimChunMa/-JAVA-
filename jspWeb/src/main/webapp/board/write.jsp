<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body>
	<%@ include file ="/header.jsp" %>
	<h3> 글쓰기 </h3>
	
	<script>
	if(memberInfo.mno==0){
		
		alert('회원제 기능입니다. 로그인후 작성해주세요');
		location.href="/jspWeb/member/login.jsp"
	}
	</script>
	
	<% 
		//jsp 로그인 여부 제어
		Object obj = request.getSession().getAttribute("login");
	if(obj == null){
		response.sendRedirect("/jspWeb/member/login.jsp");
	}
	%>
	
	
	
	<div class="container">
		<form class="writeForm" >
			카테고리 : <select name="cno" class="cno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 커뮤니티 </option>
						<option value="3"> QnA </option>
						<option value="4"> 노하우 </option>
					 </select> <br/>
			제목 : <input type="text" name="btitle"> <br/>
			내용 : <textarea rows="10" cols="40" name="bcontent" id="summernote"
			></textarea> <br/>
			첨부파일 : <input type="file" name="bfile"><br/>
			
			<button type="button" onclick="bwrite()"> 쓰기 </button>
		</form>
	</div>
	
	
	
	
	<!--
		html -> form [동기식: 페이지전환 있음] 
		<form action="통신할 URL" method="http 메소드"
		1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송 타입
		2. enctype="multipart/form-data" 
		form 안에 <button > type 생략시 type="submit"(폼보내기) 
		 
		vs JS ------- > AJAX [비동기식, 동기식] 
				
		
		>
	 -->
	
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  <script src="/jspWeb/js/board/write.js"></script>
	
	
</body>
</html>