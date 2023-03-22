<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspWeb/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file ="/header.jsp" %>
	<div class="container">
	
		<div class="cattingbox">	<!-- 채팅구역 -->
				<div class="contentbox"> <!-- 채팅창 -->
				<!-- 
					보낼떄
					<div class="secontent">
						<div class="date"> 오전 10:10 </div>
						<div class="content"> 안녕하세요 </div>
					</div>
					
					알람
					<div class="alarm"> 
						<span>강호동님이 입장하셨습니다 </span>
					</div>
					
					받을때 프로필, 시간, 내용
					<div class="tocontent">
						<div> <span> <img src="/jspWeb/member/pimg/default.webp" class="hpimg"> </span> </div>
						<div class="rcontent">
							<div class="name"> 강호동 </div>
							<div class="contentdate">
								<div class="content"> 안녕하세요 </div>
								<div class="date"> 오전 10:10 </div>
							</div>
						</div>
					
					
					</div> -->
					
				</div><!-- contentbox e -->
				
				<!-- 채팅입력 -->
				<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""></textarea>
				
				<!-- 채팅 전송 -->
				<button type="button" onclick="send()">보내기</button>
			
		</div>
	
		
	
	
	</div>
	
	
	<script src="/jspWeb/js/board/chatting.js"></script>
	
</body>
</html>