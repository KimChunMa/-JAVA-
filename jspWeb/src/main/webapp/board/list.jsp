<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.pagebox button{padding:10px 15px; margin:10px;}
</style>

</head>
<body>
	<%@ include file ="/header.jsp" %>
	
	<div class="container">
	
		<h3> 게시물 목록 </h3>
		<a href="write.jsp">게시물 쓰기</a>
		
		<table class="boardTable table table-hover">
		</table>
		
		<div class="pagebox" >
		</div>
	</div>
	

	
	<script src="/jspWeb/js/board/list.js"></script>
</body>
</html>