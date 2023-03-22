<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link href="/jspWeb/css/modal.css" rel="stylesheet">
		
</head>
<body>
	<%@include file ="/header.jsp" %>
	<p>//현재 약국좌표가 저장된 xy(=markers)를 map으로 하려했으나 map이 실행이안됨 </p>
	<!-- 1.지도 생성 -->
	<div class="container">
		<div id="map" style="width:100%;height:450px;"></div>
	</div>
	
	
		<!-- 모달 HTML -->
	<div class="modal_wrap">
		<div class="modal_box">
			<h3 class="modal_title">
				<!-- 제목이 들어가는 자리  -->
			</h3>
			<div class="modal_content">
				<!-- 내용이 들어가는 자리  -->
			</div>
			<div class="modal_btns">
				<button class="modal_check" 	type="button">확인</button>
				<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
			</div>
		</div>
	</div>
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	4315de7458dfbfb39489765a36f6371c&libraries=services,clusterer,drawing"></script>
	<script src="/jspWeb/js/api/api3.js"></script>
</body>
</html>