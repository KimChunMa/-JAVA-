<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	.mListTable, .mListTable th , .mListTable td 
	{border:solid black 1px;}
	
	.pagebtn button {padding:10px; margin: 5px;}
	</style>
</head> 
<body>
	<%@ include file = "/header.jsp" %>
	<h3> 모든 회원 명단 </h3>
	
	<table class="mListTable" >

	</table>
	
	<div class="pagebtn">
	</div>
	
	
	<script src="/jspWeb/js/admin/info.js" ></script>
	
</body>
</html>