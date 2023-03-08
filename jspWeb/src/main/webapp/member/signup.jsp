<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 회원가입 </h3>
	<form>
	아이디 : 			<input type="text" class="mid"> <br/>
	비밀번호 :		<input type="text" class="mpwd"> <br/>
	비밀번호 확인 :	<input type="text" class="mpwconfirm"> <br/>
	이메일 :			<input type="text" class="memail">	<br/>
	프로필 :			<input type="text" class="mimg">	<br/>
	<button type="button" onclick="signup()" > 가입</button>
	
	</form>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspWeb/js/member/signup.js"></script>
</body>
</html>