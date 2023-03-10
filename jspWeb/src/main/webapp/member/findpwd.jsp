<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspWeb/css/signup.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더 -->
	<%@ include file = "/header.jsp" %>
	
	<div class="container"> <!-- bs : 박스권 -->
		<form class="signupForm">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		
			<h3> 패스워드찾기 </h3>
			<p> 회원님의 계정 정보를 찾아드립니다 </p>
			
			<div class="title">아이디 	</div> 		
			<div>
				<input type="text" name="mid" class="mid"  
					   maxlength="30">
				
			</div>
			
			<div class="title">이메일</div>
			<input type="text" name="memail" 	class="memail" >
			
			<span class="checkconfirm"></span>
			<button class="signupbtn" onclick="findpwd()" type="button"> 아이디찾기 </button>
		</form>
	</div>
	
	<!-- 정의 js  -->	
	<script src="/jspWeb/js/member/login.js" type="text/javascript"></script>
</body>
</html>