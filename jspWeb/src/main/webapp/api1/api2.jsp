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
	
	
	
	
	<div class="container"> 
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:500px;"></div>
		<!-- 클릭한 위치에 좌표 알기 -->
		<div id="clickLatlng"></div>
		뮤
	</div>
	
	<!-- 하나만 추가  
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c"></script>
	-->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c&libraries=clusterer"></script>
	<script src="/jspWeb/js/api/api2.js"></script>
</body>
</html>