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
	<%@ include file = "/header.jsp" %>
	
	<div class="container"> 
	
		<h3> 회원가입 </h3>
		<form class="signupForm">	<!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		
			<h3> Community</h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다. </p>
			
			<div class="title">아이디 	</div> 		
			<div>
				<input type="text" name="mid" class="mid"  
					   onkeyup="idcheck()" maxlength="30">
			</div>
			
			<div class="title"> 비밀번호  </div> 	
			<div>
				<input onkeyup="pwdcheck()" maxlength="20" 
					   type="password" name="mpwd" class="mpwd" >		
			</div>
			
			<span class="checkconfirm"></span>
			
			<div class="subbtnbox">
				<a href="/jspWeb/member/findid.jsp">아이디 찾기</a>
				<a href="/jspWeb/member/findpwd.jsp">비밀번호 찾기</a>
			</div>
			<div class=""></div>
			
			<button onclick="login()" type="button" class="signupbtn"> 로그인 </button>
		</form>
	</div>
	
	<script src="/jspWeb/js/member/login.js"></script>	
</body>
</html>