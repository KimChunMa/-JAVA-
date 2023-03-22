<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file ="/header.jsp" %>
	<div class="container">
		<!-- 채팅 내용물 -->
		<div class="contentbox">
			<!-- 채팅입력 -->
			<textarea class="msgbox" rows="" cols=""></textarea>
			
			<!-- 채팅 전송 -->
			<button type="button" onclick="send()">보내기</button>
		</div>
	
	
	</div>
	
	
	<script src="/jspWeb/js/board/chatting.js"></script>
	
</body>
</html>