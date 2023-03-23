<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>
	<div class="container">
	
		<form class="writeForm">
			제품명 :	<input type="text" name="pname"> 
			제품설명 : <input type="text" name="pcomment"> 
			제품가격 : <input type="text" name="pprice"> 
			위도 : 
			<div id="map" style="width:100%;height:350px;"></div>
			<button onclick="onwrite()" type="button"> 제품 등록 </button>
		</form>
		
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c"></script>
	<script src="/jspWeb/js/product/write.js"></script>
</body>
</html>