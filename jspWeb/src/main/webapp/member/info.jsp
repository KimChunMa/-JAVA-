<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	
	<div class="container">
	
		<h3> 회원 정보 </h3>
		
		<div>
			<div>
				<img class="mimg" alt="" src="">
			</div>
			
			<div>
				<div>아이디</div>
				<div class="mid"></div>
			</div>
			
			<div>
				<div>이메일</div>
				<div class="memail"></div>
			</div>
			
			<div>
				<div>보유포인트</div>
				<div class="mpoint"></div>
			</div>
			
			<button type="button"> 회원수정 </button>
			<button type="button"> 회원탈퇴 </button>
			
		</div>
		
	</div>
	
	<script src="/jspWeb/js/member/info.js"></script>
</body>
</html>

<!--  
	동일한 HTML에서 열리는 js 파일은 메모리 공유
	단 먼저 호출된 js 순
	주의 ajax
		1. $.ajax({}) 비동기 통신 [요청보내고 응답을 기다리지않음]
		
 -->