<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/jspWeb/css/signup.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container"> 
		<form class="signupForm">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		
			<h3> 아이디 찾기 </h3>
			<p> 아이디를 찾는 중 입니다. </p>
		
				
			<div class="title"> 이메일  </div> 
				<div class="mailbox">
					<input  type="text" name="memail" class="memail">
				</div>
					
				<span class="checkconfirm"></span>
			
			
			<button onclick="findid()" type="button" class="signupbtn"> 아이디찾기 </button>
		</form>
	</div>
	
	<script src="/jspWeb/js/member/login.js"></script>	
</body>
</html>