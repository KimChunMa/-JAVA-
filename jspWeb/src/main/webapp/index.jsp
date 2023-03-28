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
		
			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspWeb/product/pimg/default.png">
				</div>
					<div class="pname"> LG 노트북 팝니다 </div>
					<div class="pprice"> 3,3000원</div>
					<div class="petc">  
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5 
						<i class="far fa-thumbs-down"></i> 2 
						<i class="far fa-comment-dots"></i> 4
					</div>
				</div>
				
			
			<div class="productbox">
				<div class="pimgbox">
					<img src="/jspWeb/product/pimg/default.png">
				</div>
					<div class="pname"> LG 노트북 팝니다 </div>
					<div class="pprice"> 3,3000원</div>
					<div class="petc">  
						<i class="far fa-eye"></i> 30
						<i class="far fa-thumbs-up"></i> 5 
						<i class="far fa-thumbs-down"></i> 2 
						<i class="far fa-comment-dots"></i> 4
					</div>
			</div>
			
				
			</div>	<!-- productlistbox -->
			
			
		</div>
	
	<p id="result"></p>
	<%@ include file = "/footer.jsp" %>
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c&libraries=clusterer"></script>
	<script src="/jspWeb/js/index.js"></script>
	
</body>
</html>