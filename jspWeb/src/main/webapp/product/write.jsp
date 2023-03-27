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
			<div>
			위도 : 
			<span id="clickLatlng"></span>
			
			<div id="map" style="width:100%;height:350px;"></div>
			
			<!-- 첨부파일 1개 -->
			첨부파일 : <input type="file" name="pfile" accept="image/*"><br/>
			
			<!-- 첨부파일 여러한개 -->
			첨부파일 : <input type="file" name="pfile1" ><br/>
			첨부파일 : <input type="file" name="pfile2" ><br/>
			첨부파일 : <input type="file" name="pfile3" ><br/>
			
			<!-- 첨부파일 동시 여러개 cos불가능 commons 가능 -->
			첨부파일 : <input type="file" name="pfile4" multiple="multiple" accept="image/*"><br/>
			
			<button onclick="onwrite()" type="button"> 제품 등록 </button>
			</div>
		</form>
		
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4315de7458dfbfb39489765a36f6371c"></script>
	<script src="/jspWeb/js/product/write.js"></script>
</body>
</html>