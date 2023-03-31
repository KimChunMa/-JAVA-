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
		
		<button type="button" onclick="setpay(10000)"> 10000 원 </button>
		
		<button type="button" onclick="setpay(50000)">50000 원</button> <!-- 결제하기 버튼 생성 -->
		
		<h3> 본인인증 </h3>
		
	
	</div>
		
	
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="/jspWeb/js/member/point.js"></script>
</body>
</html>