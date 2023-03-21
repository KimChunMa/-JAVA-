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
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:500px;"></div>
		<!-- 클릭한 위치에 좌표 알기 -->
		<div id="clickLatlng"></div>
		뮤
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c"></script>
	
	<script src="/jspWeb/js/api/api2.js"></script>
</body>
</html>