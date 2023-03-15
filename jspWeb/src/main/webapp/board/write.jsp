<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file ="/header.jsp" %>
	<h3> 글쓰기 </h3>
	
	<div class="container">
		<form class="writeForm" >
			카테고리 : <select name="cno">
						<option value="1"> 공지사항 </option>
						<option value="2"> 커뮤니티 </option>
						<option value="3"> QnA </option>
						<option value="4"> 노하우 </option>
					 </select> <br/>
			제목 : <input type="text" name="btitle"> <br/>
			내용 : <textarea rows="10" cols="40" name="bcontent"></textarea> <br/>
			첨부파일 : <input type="file" name="bfile">
			
			<button type="button" onclick="bwrite()"> 쓰기 </button>
		</form>
	</div>
	
	
	<script src="/jspWeb/js/board/write.js"></script>
	
	<!--
		html -> form [동기식: 페이지전환 있음] 
		<form action="통신할 URL" method="http 메소드"
		1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송 타입
		2. enctype="multipart/form-data" 
		form 안에 <button > type 생략시 type="submit"(폼보내기) 
		 
		vs JS ------- > AJAX [비동기식, 동기식] 
				
		
		>
	 -->
	
	
</body>
</html>