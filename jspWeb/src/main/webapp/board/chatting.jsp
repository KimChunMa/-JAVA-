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
				
					<!-- 보낼떄 -->
					<div class="secontent">
						<div class="data"> 오전 10:10 </div>
						<div class="content"> 안녕하세요 </div>
					</div>
					
					<!-- 알람 -->
					<div class="alarm"> 
						<span>강호동님이 입장하셨습니다 </span>
					</div>
					
				
					
					<!-- 받을때 프로필, 시간, 내용-->
					<div>
						<span> <img src="/jspWeb/member/pimg/default.webp" class="hpimg"> </span>
						<div >
							<div> 강호동 </div>
							<div > 오전 10:10 </div>
							<div > 안녕하세요 </div>
						</div>
					
					
					</div>
					
				</div><!-- contentbox e -->
				
				<textarea class="form-control msgbox" rows="" cols=""></textarea>
				
				<div class="cattingbtnbox">
					<div> 이모티콘 </div>
					<div> 첨부파일 </div>
					<button  type="button" class="sendbtn"> 보내기 </button>
				</div>
		</div>
	
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