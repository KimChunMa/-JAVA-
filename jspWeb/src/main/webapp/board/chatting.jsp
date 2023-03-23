<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspWeb/css/chatting.css" rel="stylesheet">
	<script src="https://kit.fontawesome.com/e89fff508e.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@include file ="/header.jsp" %>
	<div class="container cattingwrap">
	
		<div class="connectlistbox"> <!-- 접속 명단 표시 구역 -->
			
			
		</div>
	
	
	
	
		<div class="cattingbox">	<!-- 채팅구역 -->
				<div class="contentbox"> <!-- 채팅창 -->
				</div><!-- contentbox e -->
				
				<!-- 채팅입력 -->
				<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				
				<!-- 채팅 전송 -->
				<div class="cattingbtnbox">
					
					<!-- bs:드롭다운
						클릭위치에 data-bs-toggle = "dropdown"
						드롭다운시 표시할 위치 : class="dropdown-menu"
						 -->
					
					<!-- 드롭다운 -->
					<button class="emobtn" type="button" data-bs-toggle="dropdown">
						<i class="far fa-smile-wink"></i>
					</button>
					
					<!-- 드롭다운 클릭시 보임 -->
					<div class="dropdown-menu enolist"></div>
					
					<button type="button" onclick="send()">보내기</button>
				</div>
		</div>
	
		
	
	
	</div>
	
	
	<script src="/jspWeb/js/board/chatting.js"></script>
	
</body>
</html>