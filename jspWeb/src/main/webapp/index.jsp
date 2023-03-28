<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html > 
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
	<!-- 사용자 css -->
	<link href="/jspWeb/css/index.css" rel="stylesheet">
	
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body >
	<%@ include file = "/header.jsp" %>
	
	<!-- 모달창 -->
	<div  class="searchbox">
		검색창
	</div>
	
	<div class="contentbox">
		<!-- 지도 -->
		<div id="map"></div>
		<!-- 사이드바 -->
		<div class="productlistbox" >
		
			
				
			
				
			</div>	<!-- productlistbox -->
		</div>
	
	<p id="result"></p>
	<%@ include file = "/footer.jsp" %>
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c&libraries=clusterer"></script>
	<script src="/jspWeb/js/index.js"></script>
	
</body>
</html>