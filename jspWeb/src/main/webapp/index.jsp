<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%"> 
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body style="height:100%">
	<%@ include file = "/header.jsp" %>
	
	<!-- 모달창 -->
	<div style="position:fixed; left:10px; top:200px; z-index:999;
				width:100px; height:100px;
				 background-color:white;">
		검색창
	</div>
	
	<div style="display:flex; width:100%; height:100%">
		<!-- 지도 -->
		<div id="map" style="width:80%; height:100%;"></div>
		<!-- 사이드바 -->
		<div class="productlistbox" style="width:20%" >
		</div>
	</div>
	<p id="result"></p>
	<%@ include file = "/footer.jsp" %>
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c&libraries=clusterer"></script>
	<script src="/jspWeb/js/index.js"></script>
	
</body>
</html>